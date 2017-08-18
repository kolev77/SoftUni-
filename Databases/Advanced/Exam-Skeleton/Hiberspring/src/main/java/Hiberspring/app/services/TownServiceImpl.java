package Hiberspring.app.services;

import Hiberspring.app.dtos.bindings.TownImportFromJsonDto;
import Hiberspring.app.entities.Town;
import Hiberspring.app.repositories.TownRepository;
import Hiberspring.app.utilities.MapperConverter;
import Hiberspring.app.validators.DTOValidator;
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
        List<Town> convertedTowns = new ArrayList<>();
        for (Town townDto : townsImportFromJsonDto) {
            Town town = this.mapperConverter.convert(townDto,Town.class);
            if (DTOValidator.isValid(town)){
                convertedTowns.add(town);
                this.townRepository.save(town);
            }
        }
        return convertedTowns;
    }
}
