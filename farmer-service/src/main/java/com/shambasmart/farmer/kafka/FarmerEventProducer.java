package com.shambasmart.farmer.kafka;

import com.shambasmart.common.dto.FarmerEvent;
import com.shambasmart.farmer.model.Farmer;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FarmerEventProducer {

    private final KafkaTemplate<String, FarmerEvent> kafkaTemplate;

    public void publishFarmerCreated(Farmer farmer) {
        FarmerEvent event = FarmerEvent.builder()
                .farmerId(farmer.getId())
                .name(farmer.getName())
                .region(farmer.getRegion())
                .build();

        kafkaTemplate.send("farmer-events", event);
    }
}
