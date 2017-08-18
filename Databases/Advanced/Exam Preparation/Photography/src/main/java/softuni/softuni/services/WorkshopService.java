package softuni.softuni.services;

import softuni.softuni.entities.Accessory;

import softuni.softuni.dtos.bindings.workshop.WorkshopImportFromXmlDto;
import softuni.softuni.dtos.views.workshop.WorkshopsByLocationViewDto;
import softuni.softuni.entities.Workshop;

import java.util.List;

public interface WorkshopService {

    List<Workshop> findAll();

    Workshop findById(long id);

    Workshop createOne(WorkshopImportFromXmlDto workshopImportFromXmlDto);

    List<Workshop> createMany(Iterable<Workshop> workshops);

    Workshop updateOne(Workshop workshop);

    List<Workshop> updateMany(Iterable<Workshop> workshops);

    void deleteById(long id);

    void deleteByWorkshop(Workshop workshop);

    WorkshopsByLocationViewDto getWorkshopsByLocation();
}