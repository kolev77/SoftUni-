package com.softuni.virus.services;

import com.softuni.virus.models.service.CapitalServiceModel;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CapitalService {

    List<CapitalServiceModel> getAllCapitals();

    CapitalServiceModel getByName(String name);


}
