package darius.licenta.backend.dto.normal.board.response.fulldetails;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Objects;

public class CategoryDto implements Serializable {
    private final Long id;
    private final String categoryName;
    private final Blob categoryPicture;

    public CategoryDto(Long id, String categoryName, Blob categoryPicture) {
        this.id = id;
        this.categoryName = categoryName;
        this.categoryPicture = categoryPicture;
    }

    public Long getId() {
        return this.id;
    }

    public String getCategoryName() {
        return this.categoryName;
    }

    public Blob getCategoryPicture() {
        return this.categoryPicture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoryDto that = (CategoryDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(categoryName, that.categoryName)) return false;
        return Objects.equals(categoryPicture, that.categoryPicture);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (categoryName != null ? categoryName.hashCode() : 0);
        result = 31 * result + (categoryPicture != null ? categoryPicture.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "CategoryDto{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", categoryPicture=" + categoryPicture +
                '}';
    }
}
