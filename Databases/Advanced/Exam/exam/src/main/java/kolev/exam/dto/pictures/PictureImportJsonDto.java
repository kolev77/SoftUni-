package kolev.exam.dto.pictures;

import com.google.gson.annotations.Expose;

import java.math.BigDecimal;

public class PictureImportJsonDto {
    @Expose
    private String path;

    @Expose
    private BigDecimal size;

    public PictureImportJsonDto() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BigDecimal getSize() {
        return size;
    }

    public void setSize(BigDecimal size) {
        this.size = size;
    }
}
