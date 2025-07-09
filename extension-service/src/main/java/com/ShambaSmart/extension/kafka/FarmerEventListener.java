package com.ShambaSmart.extension.kafka;

import com.shambasmart.common.dto.FarmerEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class FarmerEventListener {

    @KafkaListener(topics = "farmer_created", groupId = "extension-group", containerFactory = "kafkaListenerContainerFactory")
    public void handleFarmerEvent(FarmerEvent event) {
        log.info("Received farmer event: {}", event);

        // TODO: Store farmer, trigger agronomy advice generation, etc.
    }
}
