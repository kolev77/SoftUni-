package app.terminal;

import app.domain.dto.DTOConvertUtil;
import app.domain.dto.json.PersonDto;
import app.domain.model.Person;
import app.domain.model.PhoneNumber;
import app.io.JsonParser;
import app.io.XmlParser;
import app.serialize.Serializer;
import app.service.PersonService;
import app.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolationException;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.*;

@Component
public class Terminal implements CommandLineRunner {
    @Autowired
    private PersonService personService;

    private static final String PERSON_INPUT_JSON = "/files/input/json/person.json";
    private static final String PERSONS_INPUT_JSON = "/files/input/json/persons.json";
    private static final String PERSONS_OUTPUT_JSON = "/src/main/resources/files/output/json/personsByCountry.json";

    @Autowired
    @Qualifier(value = "JsonSerializer")
    private Serializer serializer;

//    @Autowired
//    @Qualifier(value = "XmlSerializer")
//    private Serializer serializerXml;

    @Override
    public void run(String... strings) throws Exception {
        importPersonJson();
        importPersonsJson();
        exportPersonByCountry();
        List<Person> bulgarians = personService.findByCountry("Bulgaria");
        System.out.println("asd");
    }

    private void exportPersonByCountry() {
        List<Person> bulgarians = personService.findByCountry("Bulgaria");
        List<PersonDto[]> bulgarianDtos = DTOConvertUtil.convert(bulgarians, PersonDto[].class);
        serializer.serialize(bulgarianDtos,PERSONS_OUTPUT_JSON);
        System.out.println("ASD");
    }

    private void importPersonsJson() {
        PersonDto[] personsDtos = serializer.deserialize(PersonDto[].class, PERSONS_INPUT_JSON);

        for (PersonDto personsDto : personsDtos) {
            importPerson(personsDto);
        }
    }

    private void importPersonJson() {
        PersonDto personDto = serializer.deserialize(PersonDto.class, PERSON_INPUT_JSON);
        importPerson(personDto);
    }

    private void importPerson(PersonDto personDto) {

        Person person = DTOConvertUtil.convert(personDto, Person.class);

        PersonDto newP = DTOConvertUtil.convert(person, PersonDto.class);
        personService.create(person);
    }
}
