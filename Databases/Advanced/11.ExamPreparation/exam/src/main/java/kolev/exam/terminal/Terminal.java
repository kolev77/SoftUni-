package kolev.exam.terminal;

import kolev.exam.dto.branches.BranchImportJsonDto;
import kolev.exam.dto.employeeCards.EmployeeCardImportJsonDto;
import kolev.exam.dto.employees.EmployeeExportJsonDto;
import kolev.exam.dto.products.ProductImportXmlDto;
import kolev.exam.dto.products.ProductsWrapperImportXmlDto;
import kolev.exam.dto.towns.TownImportJsonDto;
import kolev.exam.entities.Branch;
import kolev.exam.entities.Employee;
import kolev.exam.entities.EmployeeCard;
import kolev.exam.entities.Town;
import kolev.exam.io.ConsoleWriter;
import kolev.exam.serialize.api.Serializer;
import kolev.exam.services.api.*;
import kolev.exam.utils.DTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

import static kolev.exam.constants.Paths.*;

@Controller
public class Terminal implements CommandLineRunner {

    @Autowired
    private TownService townService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BranchService branchService;

    @Autowired
    private EmployeeCardService employeeCardService;

    @Autowired
    private ProductService productService;

    @Autowired
    @Qualifier("JsonSerializer")
    private Serializer jsonSerializer;

    @Autowired
    @Qualifier("XmlSerializer")
    private Serializer xmlSerializer;

    @Autowired
    private ConsoleWriter consoleWriter;


    @Override
    public void run(String... strings) throws Exception {
        //imports
        importTownsJson();
        importBranchesJson();
        importEmployeeCardsJson();
        importProductsXml();


        // exports
        exportProductiveEmployees();


    }

    private void exportProductiveEmployees() {
        List<Employee> productiveEmployees = this.employeeService.findAllProductiveEmployees();
        List<EmployeeExportJsonDto> employeeExportJsonDtos = new ArrayList<>();

        for (Employee productiveEmployee : productiveEmployees) {
            EmployeeExportJsonDto employeeExportJsonDto = DTOConverter.convert(productiveEmployee, EmployeeExportJsonDto.class);
            employeeExportJsonDto.setFullName(String.format("%s %s",
                    productiveEmployee.getFirstName(),
                    productiveEmployee.getLastName()));
            employeeExportJsonDtos.add(employeeExportJsonDto);
        }
        this.jsonSerializer.serialize(employeeExportJsonDtos, PRODUCTIVE_EMPLOYEES_OUTPUT_JSON);
    }

    private void importProductsXml() {
        ProductsWrapperImportXmlDto productsWrapperDto = this.xmlSerializer.deserialize(ProductsWrapperImportXmlDto.class, PRODUCTS_INPUT_XML);
        for (ProductImportXmlDto productImportXmlDto : productsWrapperDto.getProducts()) {
            String result = this.productService.add(productImportXmlDto);
            this.consoleWriter.writeLine(result);
        }
    }

    private void importEmployeeCardsJson() {
        EmployeeCardImportJsonDto[] emlployeeCardDtos = this.jsonSerializer.deserialize(EmployeeCardImportJsonDto[].class, EMPLOYEE_CARDS_INPUT_JSON);
        for (EmployeeCardImportJsonDto emlployeeCardDto : emlployeeCardDtos) {
            EmployeeCard employeeCard = DTOConverter.convert(emlployeeCardDto, EmployeeCard.class);
            String result = this.employeeCardService.add(employeeCard);
            this.consoleWriter.writeLine(result);
        }
    }

    private void importBranchesJson() {
        BranchImportJsonDto[] branchDtos = this.jsonSerializer.deserialize(BranchImportJsonDto[].class, BRANCHES_INPUT_JSON);
        for (BranchImportJsonDto branchDto : branchDtos) {
            String result = this.branchService.add(branchDto);
            this.consoleWriter.writeLine(result);
        }
    }

    private void importTownsJson() {
        TownImportJsonDto[] townDtos = this.jsonSerializer.deserialize(TownImportJsonDto[].class, TOWNS_INPUT_JSON);

        for (TownImportJsonDto townDto : townDtos) {
            Town town = DTOConverter.convert(townDto, Town.class);
            String result = this.townService.add(town);
            this.consoleWriter.writeLine(result);
        }
    }
}
