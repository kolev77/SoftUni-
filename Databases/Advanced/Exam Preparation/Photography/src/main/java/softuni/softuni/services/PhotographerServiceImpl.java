package softuni.softuni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.softuni.dtos.bindings.PhotographerImportFromJsonDto;
import softuni.softuni.dtos.views.photographer.PhotographerLandscapeViewDto;
import softuni.softuni.dtos.views.photographer.PhotographerOrderedViewDto;
import softuni.softuni.dtos.views.photographer.PhotographerSameCamerasViewDto;
import softuni.softuni.dtos.views.photographer.PhotographersSameCamerasViewDto;
import softuni.softuni.entities.Camera;
import softuni.softuni.entities.Lens;
import softuni.softuni.entities.Photographer;
import softuni.softuni.repositories.CameraRepository;
import softuni.softuni.repositories.LensRepository;
import softuni.softuni.repositories.PhotographerRepository;
import softuni.softuni.utilities.MapperConverter;
import softuni.softuni.utilities.RandomNumber;
import softuni.softuni.validators.DTOValidator;

import java.util.Arrays;
import java.util.List;

@Transactional
@Service
public class PhotographerServiceImpl implements PhotographerService {

    private final PhotographerRepository photographerRepository;
    private final CameraRepository cameraRepository;
    private final LensRepository lensRepository;
    private final MapperConverter mapperConverter;

    @Autowired
    public PhotographerServiceImpl(PhotographerRepository photographerRepository, CameraRepository cameraRepository, LensRepository lensRepository, MapperConverter mapperConverter) {
        this.photographerRepository = photographerRepository;
        this.cameraRepository = cameraRepository;
        this.lensRepository = lensRepository;
        this.mapperConverter = mapperConverter;
    }

    @Override
    public List<Photographer> findAll() {
        return this.photographerRepository.findAll();
    }

    @Override
    public Photographer findById(long id) {
        return this.photographerRepository.findOne(id);
    }

    @Override
    public Photographer createOne(PhotographerImportFromJsonDto photographerImportFromJsonDto) {
        List<Camera> cameras = this.cameraRepository.findAll();
        Photographer photographer = this.mapperConverter.convert(photographerImportFromJsonDto, Photographer.class);
        photographer.setPrimaryCamera(cameras.get(RandomNumber.getRandomNumber(cameras.size())));
        photographer.setSecondaryCamera(cameras.get(RandomNumber.getRandomNumber(cameras.size())));

        if (DTOValidator.isValid(photographer)) {
            if (photographerImportFromJsonDto.getLensesIds() == null || !photographerImportFromJsonDto.getLensesIds().isEmpty()) {
                List<Lens> lenses = this.lensRepository.getLenses(photographerImportFromJsonDto.getLensesIds());
                for (Lens lens : lenses) {
                    if (lens.getCompatibleWith().equals(photographer.getPrimaryCamera().getMake()) || lens.getCompatibleWith().equals(photographer.getSecondaryCamera().getMake())) {
                        lens.setLensOwner(photographer);
                    }
                }
                if (photographer.getId() == 0) {
                    photographer = this.photographerRepository.save(photographer);
                }

            } else {
                photographer = this.photographerRepository.save(photographer);
            }
        } else {
            photographer = null;
        }
        return photographer;
    }

    @Override
    public List<Photographer> createMany(Iterable<Photographer> photographers) {
        return this.photographerRepository.save(photographers);
    }

    @Override
    public Photographer updateOne(Photographer photographer) {
        return this.photographerRepository.save(photographer);
    }

    @Override
    public List<Photographer> updateMany(Iterable<Photographer> photographers) {
        return this.photographerRepository.save(photographers);
    }

    @Override
    @Modifying
    public void deleteById(long id) {
        this.photographerRepository.delete(id);
    }

    @Override
    @Modifying
    public void deleteByPhotographer(Photographer photographer) {
        this.photographerRepository.delete(photographer);
    }

    @Override
    public List<PhotographerOrderedViewDto> getOrderedPhotographers() {
        List<Photographer> photographers = this.photographerRepository.getPhotographersByOrderByFirstNameAscLastNameDesc();
        PhotographerOrderedViewDto[] orderedViewDtos = this.mapperConverter.convert(photographers, PhotographerOrderedViewDto[].class);
        return Arrays.asList(orderedViewDtos);
    }

    @Override
    public List<PhotographerLandscapeViewDto> getLandscapePhotographers() {
        List<Photographer> landscapePhotographers = this.photographerRepository.getLandscapePhotographers();
        return Arrays.asList(this.mapperConverter.convert(landscapePhotographers, PhotographerLandscapeViewDto[].class));
    }

    @Override
    public PhotographersSameCamerasViewDto getSameCamerasPhotographers() {
        List<Photographer> photographers = this.photographerRepository.getSameCamerasPhotographers();
        List<PhotographerSameCamerasViewDto> photographerSameCamerasViewDtos = Arrays.asList(this.mapperConverter.convert(photographers, PhotographerSameCamerasViewDto[].class));
        PhotographersSameCamerasViewDto photographersSameCamerasViewDto = new PhotographersSameCamerasViewDto();
        photographersSameCamerasViewDto.setPhotographerSameCamerasViewDtos(photographerSameCamerasViewDtos);
        return photographersSameCamerasViewDto;
    }
}