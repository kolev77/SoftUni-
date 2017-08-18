package softuni.softuni.services;

import softuni.softuni.dtos.bindings.accessory.AccessoryImportFromXmlDto;
import softuni.softuni.entities.Accessory;

import java.util.List;

public interface AccessoryService {

    List<Accessory> findAll();

    Accessory findById(long id);

    Accessory createOne(Accessory accessory);

    List<Accessory> createMany(Iterable<AccessoryImportFromXmlDto> accessoryImportFromXmlDtos);

    Accessory updateOne(Accessory accessory);

    List<Accessory> updateMany(Iterable<Accessory> accessorys);

    void deleteById(long id);

    void deleteByAccessory(Accessory accessory);
}