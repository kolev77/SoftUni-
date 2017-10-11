package hiberspring.hiberspring.controllers;


import hiberspring.hiberspring.dtos.bindings.BranchImportFromJsonDto;
import hiberspring.hiberspring.dtos.bindings.TownImportFromJsonDto;
import hiberspring.hiberspring.entities.Branch;
import hiberspring.hiberspring.entities.Town;
import hiberspring.hiberspring.io.Writer;
import hiberspring.hiberspring.serializers.Serializer;
import hiberspring.hiberspring.services.BranchService;
import hiberspring.hiberspring.services.TownService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;


@Controller
public class BranchController {
    private static final String BRANCHES_JSON_INPUT_PATH = "/jsons/input/branches.json";
   private static BranchService branchService;
    private final Serializer jsonSerializer;
    private final Writer writer;




    public BranchController(@Qualifier("json") Serializer jsonSerializer, BranchService branchService, Writer writer) {
        this.jsonSerializer = jsonSerializer;
        this.branchService = branchService;
        this.writer = writer;
    }


    public void importBranches(){
        BranchImportFromJsonDto[] branchImportFromJsonDtos = this.jsonSerializer.deserialize(BranchImportFromJsonDto[].class,BRANCHES_JSON_INPUT_PATH);

        for (BranchImportFromJsonDto branchImportFromJsonDto : branchImportFromJsonDtos) {
            Branch branch = this.branchService.createOne(branchImportFromJsonDto);
            if (branch != null){
                this.writer.println("Successfully imported town !");
            }else {
                this.writer.println("INVALID TOWN !");
            }
        }

    }
}
