package hiberspring.hiberspring.services;


import hiberspring.hiberspring.dtos.bindings.BranchImportFromJsonDto;
import hiberspring.hiberspring.dtos.bindings.TownImportFromJsonDto;
import hiberspring.hiberspring.entities.Branch;
import hiberspring.hiberspring.entities.Town;
import hiberspring.hiberspring.repositories.BranchRepository;
import hiberspring.hiberspring.repositories.TownRepository;
import hiberspring.hiberspring.services.BranchService;
import hiberspring.hiberspring.utilities.MapperConverter;
import hiberspring.hiberspring.validators.DTOValidator;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;
    private final MapperConverter mapperConverter;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, MapperConverter mapperConverter) {
        this.branchRepository = branchRepository;
        this.mapperConverter = mapperConverter;
    }

    @Override
    public Branch createOne(BranchImportFromJsonDto branchImportFromJsonDto) {
        Branch branch = this.mapperConverter.convert(branchImportFromJsonDto,Branch.class);
        if (DTOValidator.isValid(branch)){
            branch = this.branchRepository.save(branch);
        }
        return branch;
    }

    @Override
    public List<Branch> createMany(Iterable<Branch> branches) {
        return branchRepository.save(branches);
    }


}
