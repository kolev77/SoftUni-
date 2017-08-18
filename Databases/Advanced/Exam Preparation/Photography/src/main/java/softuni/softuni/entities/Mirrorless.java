package softuni.softuni.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "mirrorless_cameras")
@PrimaryKeyJoinColumn(name = "camera_id")
public class Mirrorless extends Camera {

    @Column(name = "max_video_resolution")
    private String maxVideoResolution;

    @Column(name = "max_frame_rate")
    private int maxFrameRate;

    public String getMaxVideoResolution() {
        return this.maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    public int getMaxFrameRate() {
        return this.maxFrameRate;
    }

    public void setMaxFrameRate(int maxFrameRate) {
        this.maxFrameRate = maxFrameRate;
    }
}