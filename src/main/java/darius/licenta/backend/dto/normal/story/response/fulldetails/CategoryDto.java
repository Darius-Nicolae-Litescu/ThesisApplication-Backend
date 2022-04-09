package darius.licenta.backend.dto.normal.story.response.fulldetails;

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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof CategoryDto)) return false;
        final CategoryDto other = (CategoryDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) return false;
        final Object this$categoryName = this.getCategoryName();
        final Object other$categoryName = other.getCategoryName();
        if (!Objects.equals(this$categoryName, other$categoryName))
            return false;
        final Object this$categoryPicture = this.getCategoryPicture();
        final Object other$categoryPicture = other.getCategoryPicture();
        if (!Objects.equals(this$categoryPicture, other$categoryPicture))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof CategoryDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $categoryName = this.getCategoryName();
        result = result * PRIME + ($categoryName == null ? 43 : $categoryName.hashCode());
        final Object $categoryPicture = this.getCategoryPicture();
        result = result * PRIME + ($categoryPicture == null ? 43 : $categoryPicture.hashCode());
        return result;
    }

    public String toString() {
        return "CategoryDto(id=" + this.getId() + ", categoryName=" + this.getCategoryName() + ", categoryPicture=" + this.getCategoryPicture() + ")";
    }
}
