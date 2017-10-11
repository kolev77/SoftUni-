package kolev.exam.services.impl;

import kolev.exam.constants.ResultMessages;
import kolev.exam.dto.branches.BranchImportJsonDto;
import kolev.exam.entities.Branch;
import kolev.exam.entities.Town;
import kolev.exam.repositories.BranchRepository;
import kolev.exam.repositories.TownRepository;
import kolev.exam.services.api.BranchService;
import kolev.exam.utils.DTOConverter;
import kolev.exam.utils.DataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    private final TownRepository townRepository;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository, TownRepository townRepository) {
        this.branchRepository = branchRepository;
        this.townRepository = townRepository;
    }


    @Override
    public String add(BranchImportJsonDto branchDto) {
        Branch branch = DTOConverter.convert(branchDto, Branch.class);
        branch.setTown(this.townRepository.findByName(branchDto.getTown()));
        this.townRepository.findByName(branchDto.getTown());


        String result;
        if (DataValidator.isValid(branch)) {
            this.branchRepository.save(branch);
            result = String.format(ResultMessages.SUCCESSFUL, branch.getClass().getSimpleName(), branch);
        } else {
            result = ResultMessages.ERROR;
        }

        return result;
    }
}
