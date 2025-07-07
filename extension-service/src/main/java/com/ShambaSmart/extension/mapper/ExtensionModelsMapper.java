package com.ShambaSmart.extension.mapper;

import com.ShambaSmart.extension.dto.*;
import com.ShambaSmart.extension.model.*;

import java.time.LocalDateTime;

public class ExtensionModelsMapper {

    public AgronomyAdvice AgronomyAdviceDtoToEntity(AgronomyAdviceDto adviceDto) {
        if (adviceDto == null) {
            return null;
        }

        AgronomyAdvice advice = new AgronomyAdvice();
        advice.setCrop(adviceDto.getCrop());
        advice.setRegion(adviceDto.getRegion());
        advice.setPlantingGuide(adviceDto.getPlantingGuide());
        advice.setFertilizerRecommendation(adviceDto.getFertilizerRecommendation());
        advice.setPestManagementTips(adviceDto.getPestManagementTips());
        advice.setPlantingSeason(adviceDto.getPlantingSeason());

        return advice;
    }

    public AgronomyAdviceDto AgronomyAdviceToDto(AgronomyAdvice advice) {
        if (advice == null) {
            return null;
        }

        AgronomyAdviceDto adviceDto = new AgronomyAdviceDto();
        adviceDto.setCrop(advice.getCrop());
        adviceDto.setRegion(advice.getRegion());
        adviceDto.setPlantingGuide(advice.getPlantingGuide());
        adviceDto.setFertilizerRecommendation(advice.getFertilizerRecommendation());
        adviceDto.setPestManagementTips(advice.getPestManagementTips());
        adviceDto.setPlantingSeason(advice.getPlantingSeason());

        return adviceDto;
    }

    //farm alert mapper

    public FarmAlert FarmAlertDtoToEntity(FarmAlertDto farmAlertDto) {
        if (farmAlertDto == null) {
            return null;
        }

        FarmAlert farmAlert = new FarmAlert();
        farmAlert.setFarmId(farmAlertDto.getFarmId());
        farmAlert.setAlertType(farmAlertDto.getAlertType());
        farmAlert.setMessage(farmAlertDto.getMessage());
        farmAlert.setTimestamp(LocalDateTime.parse(farmAlertDto.getTimestamp()));

        return farmAlert;
    }

    public FarmAlertDto FarmAlertToDto(FarmAlert farmAlert) {
        if (farmAlert == null) {
            return null;
        }

        FarmAlertDto farmAlertDto = new FarmAlertDto();
        farmAlertDto.setFarmId(farmAlert.getFarmId());
        farmAlertDto.setAlertType(farmAlert.getAlertType());
        farmAlertDto.setMessage(farmAlert.getMessage());
        farmAlertDto.setTimestamp(farmAlert.getTimestamp().toString());

        return farmAlertDto;
    }

    //farmerQuery mapper
    public FarmerQuery FarmQueryDtoToEntity(FarmerQueryDto farmerQueryDto) {
        if (farmerQueryDto == null) {
            return null;
        }

        FarmerQuery query = new FarmerQuery();
        query.setFarmerId(farmerQueryDto.getFarmerId());
        query.setFarmId(farmerQueryDto.getFarmId());
        query.setQueryText(farmerQueryDto.getQueryText());

        return query;
    }

    public FarmerQuery FarmQueryToDto(FarmerQuery farmerQuery) {
        if (farmerQuery == null) {
            return null;
        }

        FarmerQuery query = new FarmerQuery();
        query.setFarmerId(farmerQuery.getFarmerId());
        query.setFarmId(farmerQuery.getFarmId());
        query.setQueryText(farmerQuery.getQueryText());

        return query;
    }

    //Query response mapper

    public QueryResponse QueryResponseDtoToEntity(QueryResponseDto queryResponseDto) {
        if (queryResponseDto == null) {
            return null;
        }
        QueryResponse queryResponse = new QueryResponse();
        queryResponse.setQueryId(queryResponseDto.getQueryId());
        queryResponse.setStatus(queryResponseDto.getStatus());
        queryResponse.setResponseMessage(queryResponseDto.getResponseMessage());

        return queryResponse;
    }

    public QueryResponseDto QueryResponseToDto(QueryResponse queryResponse) {
        if (queryResponse == null) {
            return null;
        }
        QueryResponseDto queryResponseDto = new QueryResponseDto();
        queryResponseDto.setQueryId(queryResponse.getQueryId());
        queryResponseDto.setStatus(queryResponse.getStatus());
        queryResponseDto.setResponseMessage(queryResponse.getResponseMessage());

        return queryResponseDto;
    }

    //Recommendation mapper
    public Recommendations RecommendationsDtoToEntity(RecommendationsDto recommendationsDto) {
        if (recommendationsDto == null) {
            return null;
        }

        Recommendations recommendations = new Recommendations();
        recommendations.setFarmId(recommendationsDto.getFarmId());
        recommendations.setCropSuggestion(recommendationsDto.getCropSuggestion());
        recommendations.setSoilImprovementTip(recommendationsDto.getSoilImprovementTip());
        recommendations.setIrrigationPlan(recommendationsDto.getIrrigationPlan());

        return recommendations;
    }

    public static Recommendations RecommendationsToDto(Recommendations recommendations) {
        if (recommendations == null) {
            return null;
        }

        Recommendations recommendations1 = new Recommendations();
        recommendations1.setFarmId(recommendations.getFarmId());
        recommendations1.setCropSuggestion(recommendations.getCropSuggestion());
        recommendations1.setSoilImprovementTip(recommendations.getSoilImprovementTip());
        recommendations1.setIrrigationPlan(recommendations.getIrrigationPlan());

        return recommendations1;
    }

    //training material mapper

    public TrainingMaterial TrainingMaterialDtoToEntity(TrainingMaterialDto trainingMaterialDto){
        if (trainingMaterialDto ==null){
            return null;
        }
        TrainingMaterial trainingMaterial = new TrainingMaterial();
        trainingMaterial.setId(trainingMaterialDto.getId());
        trainingMaterial.setTopic(trainingMaterialDto.getTopic());
        trainingMaterial.setTitle(trainingMaterialDto.getTitle());
        trainingMaterial.setUrl(trainingMaterialDto.getUrl());
        trainingMaterial.setLanguage(trainingMaterialDto.getLanguage());


        return trainingMaterial;
    }

    public TrainingMaterialDto TrainingMaterialToDto(TrainingMaterial trainingMaterial) {
        if (trainingMaterial == null) {
            return null;
        }
        TrainingMaterialDto trainingMaterialDto = new TrainingMaterialDto();
        trainingMaterialDto.setId(trainingMaterial.getId());
        trainingMaterialDto.setTopic(trainingMaterial.getTopic());
        trainingMaterialDto.setTitle(trainingMaterial.getTitle());
        trainingMaterialDto.setUrl(trainingMaterial.getUrl());
        trainingMaterialDto.setLanguage(trainingMaterial.getLanguage());

        return trainingMaterialDto;
    }

}
