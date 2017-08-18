package softuni.softuni.services;
import softuni.softuni.dtos.bindings.CameraImportFromJsonDto;
import softuni.softuni.entities.Camera;

import java.util.List;

public interface CameraService {

    List<Camera> findAll();

    Camera findById(long id);

    Camera createOne(CameraImportFromJsonDto cameraImportFromJsonDto);

    List<Camera> createMany(Iterable<Camera> cameras);

    Camera updateOne(Camera camera);

    List<Camera> updateMany(Iterable<Camera> cameras);

    void deleteById(long id);

    void deleteByCamera(Camera camera);
}