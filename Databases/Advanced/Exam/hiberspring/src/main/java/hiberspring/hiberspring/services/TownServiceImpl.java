package hiberspring.hiberspring.services;


import hiberspring.hiberspring.dtos.bindings.TownImportFromJsonDto;
import hiberspring.hiberspring.entities.Town;
import hiberspring.hiberspring.repositories.TownRepository;
import hiberspring.hiberspring.utilities.MapperConverter;
import hiberspring.hiberspring.validators.DTOValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class TownServiceImpl implements TownService {

    private final TownRepository townRepository;
    private final MapperConverter mapperConverter;

    @Autowired
    public TownServiceImpl(TownRepository townRepository, MapperConverter mapperConverter) {
        this.townRepository = townRepository;
        this.mapperConverter = mapperConverter;
    }

    @Override
    public Town createOne(TownImportFromJsonDto townImportFromJsonDto) {
        Town town = this.mapperConverter.convert(townImportFromJsonDto,Town.class);
        if (DTOValidator.isValid(town)){
            town = this.townRepository.save(town);
        }

        return town;
    }

    @Override
    public List<Town> createMany(Iterable<Town> townsImportFromJsonDto) {

        return this.townRepository.save(townsImportFromJsonDto);
    }
}
