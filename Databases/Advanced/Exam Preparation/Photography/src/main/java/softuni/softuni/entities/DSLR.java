package softuni.softuni.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "DSLR_cameras")
@PrimaryKeyJoinColumn(name = "camera_id")
public class DSLR extends Camera {

    @Column(name = "max_shutter_speed")
    private int maxShutterSpeed;

    public int getMaxShutterSpeed() {
        return this.maxShutterSpeed;
    }

    public void setMaxShutterSpeed(int maxShutterSpeed) {
        this.maxShutterSpeed = maxShutterSpeed;
    }
}