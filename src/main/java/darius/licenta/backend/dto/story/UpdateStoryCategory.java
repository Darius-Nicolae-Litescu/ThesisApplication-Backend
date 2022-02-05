package darius.licenta.backend.dto.story;

import java.io.Serializable;
import java.util.Set;

public class UpdateStoryCategory implements Serializable {
    private final long id;
    private final Set<CategoryDto> categories;

    public UpdateStoryCategory(long id, Set<CategoryDto> categories) {
        this.id = id;
        this.categories = categories;
    }

    public long getId() {
        return this.id;
    }

    public Set<CategoryDto> getCategories() {
        return this.categories;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UpdateStoryCategory)) return false;
        final UpdateStoryCategory other = (UpdateStoryCategory) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$categories = this.getCategories();
        final Object other$categories = other.getCategories();
        if (this$categories == null ? other$categories != null : !this$categories.equals(other$categories))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UpdateStoryCategory;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $categories = this.getCategories();
        result = result * PRIME + ($categories == null ? 43 : $categories.hashCode());
        return result;
    }

    public String toString() {
        return "UpdateStoryCategory(id=" + this.getId() + ", categories=" + this.getCategories() + ")";
    }

    public static class CategoryDto implements Serializable {
        private final long id;

        public CategoryDto(long id) {
            this.id = id;
        }

        public long getId() {
            return this.id;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof CategoryDto)) return false;
            final CategoryDto other = (CategoryDto) o;
            if (!other.canEqual((Object) this)) return false;
            if (this.getId() != other.getId()) return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof CategoryDto;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final long $id = this.getId();
            result = result * PRIME + (int) ($id >>> 32 ^ $id);
            return result;
        }

        public String toString() {
            return "UpdateStoryCategory.CategoryDto(id=" + this.getId() + ")";
        }
    }
}
