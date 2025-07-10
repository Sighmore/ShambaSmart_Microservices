package com.ShambaSmart.input.mapper;

import com.ShambaSmart.input.dto.FarmInputDTO;
import com.ShambaSmart.input.model.FarmInput;

import java.util.List;
import java.util.stream.Collectors;

public class FarmInputMapper {

    public static FarmInputDTO FarmInputToDTO(FarmInput entity) {
        return FarmInputDTO.builder()
                .id(entity.getId())
                .name(entity.getName())
                .type(entity.getType())
                .description(entity.getDescription())
                .quantityAvailable(entity.getQuantityAvailable())
                .supplier(entity.getSupplier())
                .build();
    }

    public static FarmInput FarmInputDtoToEntity(FarmInputDTO dto) {
        return FarmInput.builder()
                .id(dto.getId())
                .name(dto.getName())
                .type(dto.getType())
                .description(dto.getDescription())
                .quantityAvailable(dto.getQuantityAvailable())
                .supplier(dto.getSupplier())
                .build();
    }

    //mapping model list to DTO list
    public static List<FarmInputDTO> FarmInputListToDTOList(List<FarmInput> entities) {
        return entities.stream()
                .map(FarmInputMapper::FarmInputToDTO)
                .collect(Collectors.toList());
    }
}

