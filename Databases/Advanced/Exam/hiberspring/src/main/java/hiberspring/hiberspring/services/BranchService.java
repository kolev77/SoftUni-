package hiberspring.hiberspring.services;



import hiberspring.hiberspring.dtos.bindings.BranchImportFromJsonDto;
import hiberspring.hiberspring.dtos.bindings.TownImportFromJsonDto;
import hiberspring.hiberspring.entities.Branch;
import hiberspring.hiberspring.entities.Town;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public interface BranchService {
    Branch createOne(BranchImportFromJsonDto branchImportFromJsonDto);

    List<Branch> createMany(Iterable<Branch> branches);
}
