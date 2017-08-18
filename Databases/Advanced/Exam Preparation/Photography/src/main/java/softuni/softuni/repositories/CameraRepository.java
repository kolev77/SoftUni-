package softuni.softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.softuni.entities.Camera;

@Repository
public interface CameraRepository extends JpaRepository<Camera, Long> {
}