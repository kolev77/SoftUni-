package softuni.softuni.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.softuni.dtos.bindings.CameraImportFromJsonDto;
import softuni.softuni.entities.Camera;
import softuni.softuni.entities.DSLR;
import softuni.softuni.entities.Mirrorless;
import softuni.softuni.repositories.CameraRepository;
import softuni.softuni.utilities.MapperConverter;
import softuni.softuni.validators.DTOValidator;

import java.util.List;

@Transactional
@Service
public class CameraServiceImpl implements CameraService {

    private final CameraRepository cameraRepository;
    private final MapperConverter mapperConverter;

    @Autowired
    public CameraServiceImpl(CameraRepository cameraRepository, MapperConverter mapperConverter) {
        this.cameraRepository = cameraRepository;
        this.mapperConverter = mapperConverter;
    }

    @Override
    public List<Camera> findAll() {
        return this.cameraRepository.findAll();
    }

    @Override
    public Camera findById(long id) {
        return this.cameraRepository.findOne(id);
    }

    @Override
    public Camera createOne(CameraImportFromJsonDto cameraImportFromJsonDto) {
        Camera camera = null;
        if (cameraImportFromJsonDto.getType() != null) {
            if (cameraImportFromJsonDto.getType().equals(DSLR.class.getSimpleName())) {
                camera = this.mapperConverter.convert(cameraImportFromJsonDto, DSLR.class);
            } else if ((cameraImportFromJsonDto.getType().equals(Mirrorless.class.getSimpleName()))) {
                camera = this.mapperConverter.convert(cameraImportFromJsonDto, Mirrorless.class);
            }
        }

        if (camera != null && DTOValidator.isValid(camera)) {
            camera = this.cameraRepository.save(camera);
        } else {
            camera = null;
        }
        return camera;
    }

    @Override
    public List<Camera> createMany(Iterable<Camera> cameras) {
        return this.cameraRepository.save(cameras);
    }

    @Override
    public Camera updateOne(Camera camera) {
        return this.cameraRepository.save(camera);
    }

    @Override
    public List<Camera> updateMany(Iterable<Camera> cameras) {
        return this.cameraRepository.save(cameras);
    }

    @Override
    @Modifying
    public void deleteById(long id) {
        this.cameraRepository.delete(id);
    }

    @Override
    @Modifying
    public void deleteByCamera(Camera camera) {
        this.cameraRepository.delete(camera);
    }

}