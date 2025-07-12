package com.ShambaSmart.payment.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;


@Component
public class MpesaClient {

    @Value("${mpesa.consumerKey}")
    private String consumerKey;

    @Value("${mpesa.consumerSecret}")
    private String consumerSecret;

    @Value("${mpesa.businessShortCode}")
    private String businessShortCode;

    @Value("${mpesa.passkey}")
    private String passkey;

    @Value("${mpesa.callbackUrl}")
    private String callbackUrl;

    private final RestTemplate restTemplate = new RestTemplate();

    public String getAccessToken() {
        String auth = Base64.getEncoder().encodeToString((consumerKey + ":" + consumerSecret).getBytes());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Basic " + auth);

        HttpEntity<Void> request = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(
                "https://sandbox.safaricom.co.ke/oauth/v1/generate?grant_type=client_credentials",
                HttpMethod.GET,
                request,
                Map.class
        );

        return (String) response.getBody().get("access_token");
    }

    public ResponseEntity<String> pushSTK(String phoneNumber, String amount, String accountRef) {
        String token = getAccessToken();

        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String password = Base64.getEncoder().encodeToString(
                (businessShortCode + passkey + timestamp).getBytes()
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        int amountInt = (int) Double.parseDouble(amount);


        Map<String, String> body = new HashMap<>();
        body.put("BusinessShortCode", businessShortCode);
        body.put("Password", password);
        body.put("Timestamp", timestamp);
        body.put("TransactionType", "CustomerPayBillOnline");
        body.put("Amount", String.valueOf(amountInt));
        body.put("PartyA", phoneNumber); // user
        body.put("PartyB", businessShortCode); // your paybill
        body.put("PhoneNumber", phoneNumber);
        body.put("CallBackURL", callbackUrl);
        body.put("AccountReference", accountRef);
        body.put("TransactionDesc", "Payment for farm input");

        HttpEntity<Map<String, String>> request = new HttpEntity<>(body, headers);

        return restTemplate.postForEntity(
                "https://sandbox.safaricom.co.ke/mpesa/stkpush/v1/processrequest",
                request,
                String.class
        );
    }
}

