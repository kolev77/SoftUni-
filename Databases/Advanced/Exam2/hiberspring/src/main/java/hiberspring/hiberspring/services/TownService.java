package hiberspring.hiberspring.services;



import hiberspring.hiberspring.dtos.bindings.TownImportFromJsonDto;
import hiberspring.hiberspring.entities.Town;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface TownService {
    Town createOne(TownImportFromJsonDto townImportFromJsonDto);

    List<Town> createMany(Iterable<Town> townsImportFromJsonDto);
}
