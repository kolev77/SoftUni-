package kolev.exam.services.api;

import kolev.exam.dto.branches.BranchImportJsonDto;
import kolev.exam.entities.Branch;

public interface BranchService {
    String add(BranchImportJsonDto branchDto);
}