package hiberspring.hiberspring.controllers;


import hiberspring.hiberspring.dtos.bindings.TownImportFromJsonDto;
import hiberspring.hiberspring.entities.Town;
import hiberspring.hiberspring.io.Writer;
import hiberspring.hiberspring.serializers.Serializer;
import hiberspring.hiberspring.services.TownService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;



@Controller
public class TownController {
    private static final String TOWNS_JSON_INPUT_PATH = "/jsons/input/photographers.json";
    private static TownService townService;
    private final Serializer jsonSerializer;
    private final Writer writer;




    public TownController(@Qualifier("json") Serializer jsonSerializer, TownService townService, Writer writer) {
        this.jsonSerializer = jsonSerializer;
        this.townService = townService;
        this.writer = writer;
    }


    public void importTowns(){
        TownImportFromJsonDto[] townImportFromJsonDtos = this.jsonSerializer.deserialize(TownImportFromJsonDto[].class,TOWNS_JSON_INPUT_PATH);

        for (TownImportFromJsonDto townImportFromJsonDto : townImportFromJsonDtos) {
            Town town = this.townService.createOne(townImportFromJsonDto);
            if (town != null){
                this.writer.println("Successfully imported town !");
            }else {
                this.writer.println("INVALID TOWN !");
            }
        }

    }
}
