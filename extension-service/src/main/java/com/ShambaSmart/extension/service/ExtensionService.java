package com.ShambaSmart.extension.service;

import com.ShambaSmart.extension.dto.AgronomyAdviceDto;
import com.ShambaSmart.extension.mapper.ExtensionModelsMapper;
import com.ShambaSmart.extension.model.*;
import com.ShambaSmart.extension.repository.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class ExtensionService {

    public final AgronomyAdviceRepository agronomyAdviceRepository;
    public final ExtensionModelsMapper extensionModelsMapper;
    public final FarmAlertRepository farmAlertRepository;
    public final FarmQueryRepository farmQueryRepository;
    public final QueryResponseRepository queryResponseRepository;
    public final RecommendationsRepository recommendationsRepository;
    public final TrainingMaterialRepository trainingMaterialRepository;

    public ExtensionService(AgronomyAdviceRepository agronomyAdviceRepository, ExtensionModelsMapper extensionModelsMapper, FarmAlertRepository farmAlertRepository, FarmQueryRepository farmQueryRepository, QueryResponseRepository queryResponseRepository, RecommendationsRepository recommendationsRepository, TrainingMaterialRepository trainingMaterialRepository) {
        this.agronomyAdviceRepository = agronomyAdviceRepository;
        this.extensionModelsMapper = extensionModelsMapper;
        this.farmAlertRepository = farmAlertRepository;
        this.farmQueryRepository = farmQueryRepository;
        this.queryResponseRepository = queryResponseRepository;
        this.recommendationsRepository = recommendationsRepository;
        this.trainingMaterialRepository = trainingMaterialRepository;
    }


    /**
     * Fetches agronomy advice based on crop and region.
     *
     * @param crop   The crop for which advice is needed.
     * @param region The region where the crop is grown.
     * @return AgronomyAdviceDto containing the advice, or null if not found.
     */
    public AgronomyAdviceDto getAgronomyAdvice(String crop, String region) {

        log.info("Fetching agronomy advice for crop: {} and region: {}", crop, region);
        AgronomyAdvice agronomyAdvice = agronomyAdviceRepository.findByCropAndRegion(crop, region);
        if (agronomyAdvice == null) {
            log.warn("No agronomy advice found for crop: {} and region: {}", crop, region);
            return null;
        }

        return extensionModelsMapper.AgronomyAdviceToDto(agronomyAdvice);

    }


    /**
     * Retrieves farm alerts for a specific farm ID.
     *
     * @param farmId The ID of the farm for which alerts are requested.
     * @return List of FarmAlert objects associated with the farm ID.
     */
    public List<FarmAlert> getFarmAlerts(String farmId) {

        log.info("Fetching farm alerts for farm ID: {}", farmId);
        List<FarmAlert> alerts = farmAlertRepository.findByFarmId(farmId);
        if (alerts.isEmpty()) {
            log.warn("No alerts found for farm ID: {}", farmId);
        }
        return alerts;

    }


    /**
     * Retrieves training materials based on the specified topic.
     *
     * @param topic The topic for which training materials are requested.
     * @return List of TrainingMaterial objects related to the topic.
     */
    public List<TrainingMaterial> getTrainingMaterials(String topic) {
        log.info("Fetching training materials for topic: {}", topic);
        List<TrainingMaterial> materials;
        if (topic != null && !topic.isEmpty()) {
            materials = trainingMaterialRepository.findByTopic(topic);
        } else {
            materials = trainingMaterialRepository.findAll();
        }

        if (materials.isEmpty()) {
            log.warn("No training materials found for topic: {}", topic);
        }

        return materials;
    }

    /**
     * Retrieves personalized recommendations for a specific farm.
     *
     * @param farmId The ID of the farm for which recommendations are requested.
     * @return Recommendations object containing personalized recommendations for the farm.
     */
    public Recommendations getRecommendation(String farmId) {
        log.info("Fetching personalized recommendations for farm ID: {}", farmId);
        Recommendations recommendation = recommendationsRepository.findByFarmId(farmId);
        if (recommendation == null) {
            log.warn("No recommendations found for farm ID: {}", farmId);
            return new Recommendations(); // Return an empty Recommendations object if none found
        }

        return ExtensionModelsMapper.RecommendationsToDto(recommendation);
    }


    public QueryResponse submitQuery(FarmerQuery query) {
        log.info("Submitting farmer query: {}", query.getQueryText());
        // Save the query to the repository
        farmQueryRepository.save(query);

        // Create a response object
        QueryResponse response = new QueryResponse();
        response.setQueryId(query.getFarmerId());
        response.setResponseMessage("Thank you for your query. Our team will get back to you shortly.");

        // Save the response to the repository
        queryResponseRepository.save(response);

        return response;
    }
}


