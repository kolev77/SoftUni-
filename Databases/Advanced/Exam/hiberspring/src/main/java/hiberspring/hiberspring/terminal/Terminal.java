package hiberspring.hiberspring.terminal;


import hiberspring.hiberspring.controllers.TownController;
import hiberspring.hiberspring.entities.Town;
import hiberspring.hiberspring.repositories.TownRepository;
import hiberspring.hiberspring.services.TownService;
import hiberspring.hiberspring.services.TownServiceImpl;
import hiberspring.hiberspring.utilities.MapperConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Terminal implements CommandLineRunner {

    private final TownController townController;

    @Autowired
    public Terminal(TownController townController) {
        this.townController = townController;
    }


    @Override
    public void run(String... strings) throws Exception {

        // Json imports
        //this.lensController.importLenses();
        //this.cameraController.importCameras();
        //this.photographerController.importPhotographers();

        // Xml imports
        //this.accessoryController.importAccesories();
        //this.workshopController.importWorkshops();

        // Json exports
        //this.photographerController.exportOrderedPhotographers();
        //this.photographerController.exportLandscapePhotographers();

        // Xml exports
        //this.photographerController.exportSameCamerasPhotographers();
        //this.workshopController.exportWorkshopsByLocation();
    }
}