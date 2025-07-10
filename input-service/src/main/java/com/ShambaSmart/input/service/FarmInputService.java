package com.ShambaSmart.input.service;

import com.ShambaSmart.input.dto.FarmInputDTO;
import com.ShambaSmart.input.mapper.FarmInputMapper;
import com.ShambaSmart.input.model.FarmInput;
import com.ShambaSmart.input.repository.FarmInputRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FarmInputService {

    public final FarmInputRepository farmInputRepository;
    public final FarmInputMapper farmInputMapper;


    public FarmInputService(FarmInputRepository farmInputRepository, FarmInputMapper farmInputMapper) {
        this.farmInputRepository = farmInputRepository;
        this.farmInputMapper = farmInputMapper;
    }

    //check whether it first exists then create if not
    public FarmInput createInput(FarmInputDTO input) {

        //check if the input already exists
        if (farmInputRepository.existsById(input.getId())) {
            throw new RuntimeException("Farm input with ID " + input.getId() + " already exists.");
        }

        //map the DTO to the entity
        FarmInput farmInput = FarmInputMapper.FarmInputDtoToEntity(input);

        //save the farm input to the database
        return farmInputRepository.save(farmInput);

    }

    // Method to retrieve all farm inputs via the repository using List<FarmInput> then convert to DTOs
    public List<FarmInputDTO> getAllInputs() {

        //fetch all farm inputs from the repository
        List<FarmInput> farmInputs = farmInputRepository.findAll();

        //check if the list is empty
        if (farmInputs.isEmpty()) {
            throw new RuntimeException("No farm inputs found.");
        }

        //return the list of farm inputs
        return FarmInputMapper.FarmInputListToDTOList(farmInputs);

    }

    public FarmInput getInputById(Long id) {

        //check if the input exists
        if (farmInputRepository.existsById(id)) {
            return farmInputRepository.findById(id).orElseThrow(() -> new RuntimeException("Farm input not found"));
        } else {
            throw new RuntimeException("Farm input with ID " + id + " does not exist.");
        }

    }

    public FarmInput updateInput(Long id, FarmInputDTO updatedInput) {

        //check if the input exists
        if (farmInputRepository.existsById(id)) {
            FarmInput existingInput = farmInputRepository.findById(id).orElseThrow(() -> new RuntimeException("Farm input not found"));
            //update the existing input with the new values
            existingInput.setName(updatedInput.getName());
            existingInput.setType(updatedInput.getType());
            existingInput.setDescription(updatedInput.getDescription());
            existingInput.setQuantityAvailable(updatedInput.getQuantityAvailable());
            existingInput.setSupplier(updatedInput.getSupplier());
            return farmInputRepository.save(existingInput);
        } else {
            throw new RuntimeException("Farm input with ID " + id + " does not exist.");
        }

    }

    public void deleteInput(Long id) {

        //check the existence of the record in the database
        if (farmInputRepository.existsById(id)) {
            farmInputRepository.deleteById(id);
        } else {
            throw new RuntimeException("Farm input with ID " + id + " does not exist.");
        }


    }
}
