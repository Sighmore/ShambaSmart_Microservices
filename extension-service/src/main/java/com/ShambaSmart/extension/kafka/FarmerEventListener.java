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

    @KafkaListener(topics = "farmer_updated", groupId = "extension-group", containerFactory = "kafkaListenerContainerFactory")
    public void handleFarmerUpdatedEvent(FarmerEvent event) {
        // TODO: Handle farmer update, update extension services as per new data
        log.info("Received updated farmer event: {}", event);
    }

    @KafkaListener(topics = "farmer_deleted", groupId = "extension-group", containerFactory = "kafkaListenerContainerFactory")
    public void handleFarmerDeletedEvent(FarmerEvent event) {
        // TODO: Handle farmer deletion, e.g., remove from database, notify other services
        log.info("Received deleted farmer event: {}", event);
    }

    @KafkaListener(topics = "farmer_retrieved", groupId = "extension-group", containerFactory = "kafkaListenerContainerFactory")
    public void handleFarmerAdviceGeneratedEvent(FarmerEvent event) {
        // TODO: trigger agronomy advice generation based on retrieved farmer data
        log.info("Received farmer retrieved event: {}", event);
    }
}
