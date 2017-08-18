package softuni.softuni.services;

import softuni.softuni.dtos.bindings.accessory.AccessoryImportFromXmlDto;
import softuni.softuni.entities.Accessory;
import softuni.softuni.entities.Photographer;
import softuni.softuni.repositories.AccessoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.softuni.repositories.PhotographerRepository;
import softuni.softuni.utilities.MapperConverter;
import softuni.softuni.utilities.RandomNumber;

import java.util.Arrays;
import java.util.List;

@Transactional
@Service
public class AccessoryServiceImpl implements AccessoryService {

    private final AccessoryRepository accessoryRepository;
    private final PhotographerRepository photographerRepository;
    private final MapperConverter mapperConverter;

    @Autowired
    public AccessoryServiceImpl(AccessoryRepository accessoryRepository, PhotographerRepository photographerRepository, MapperConverter mapperConverter) {
        this.accessoryRepository = accessoryRepository;
        this.photographerRepository = photographerRepository;
        this.mapperConverter = mapperConverter;
    }

    @Override
    public List<Accessory> findAll() {
        return this.accessoryRepository.findAll();
    }

    @Override
    public Accessory findById(long id) {
        return this.accessoryRepository.findOne(id);
    }

    @Override
    public Accessory createOne(Accessory accessory) {
        return this.accessoryRepository.save(accessory);
    }

    @Override
    public List<Accessory> createMany(Iterable<AccessoryImportFromXmlDto> accessoryImportFromXmlDtos) {
        Accessory[] accessories = this.mapperConverter.convert(accessoryImportFromXmlDtos, Accessory[].class);
        List<Photographer> photographers = this.photographerRepository.findAll();
        for (Accessory accessory : accessories) {
            accessory.setAccessoryOwner(photographers.get(RandomNumber.getRandomNumber(0, photographers.size() - 1)));
        }
        return this.accessoryRepository.save(Arrays.asList(accessories));
    }

    @Override
    public Accessory updateOne(Accessory accessory) {
        return this.accessoryRepository.save(accessory);
    }

    @Override
    public List<Accessory> updateMany(Iterable<Accessory> accessorys) {
        return this.accessoryRepository.save(accessorys);
    }

    @Override
    @Modifying
    public void deleteById(long id) {
        this.accessoryRepository.delete(id);
    }

    @Override
    @Modifying
    public void deleteByAccessory(Accessory accessory) {
        this.accessoryRepository.delete(accessory);
    }

}