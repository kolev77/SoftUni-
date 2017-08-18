package Hiberspring.app.services;

import Hiberspring.app.dtos.bindings.TownImportFromJsonDto;
import Hiberspring.app.entities.Town;

import java.util.List;

public interface TownService {
    Town createOne(TownImportFromJsonDto townImportFromJsonDto);

    List<Town> createMany(Iterable<Town> townsImportFromJsonDto);
}
