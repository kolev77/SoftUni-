package com.softuni.virus.services;

import com.softuni.virus.models.service.CapitalServiceModel;
import com.softuni.virus.repositories.CapitalRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CapitalServiceImpl implements CapitalService {
    private final CapitalRepository capitalRepository;

    @Autowired
    public CapitalServiceImpl(CapitalRepository capitalRepository) {
        this.capitalRepository = capitalRepository;
    }

    @Override
    public List<CapitalServiceModel> getAllCapitals() {
        ModelMapper modelMapper = new ModelMapper();

        return this.capitalRepository.findAll()
                .stream()
                .map(x -> modelMapper.map(x, CapitalServiceModel.class))
                .collect(Collectors.toList());
    }

    @Override
    public CapitalServiceModel getByName(String name) {
        ModelMapper modelMapper = new ModelMapper();

        return modelMapper.map(this.capitalRepository.findByName(name), CapitalServiceModel.class);
    }
}
