package darius.licenta.backend.dto.normal.story.request.update;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class UpdateStoryCategories implements Serializable {
    private final Long id;
    private final Set<CategoryDto> categories;

    public UpdateStoryCategories(Long id, Set<CategoryDto> categories) {
        this.id = id;
        this.categories = categories;
    }

    public Long getId() {
        return this.id;
    }

    public Set<CategoryDto> getCategories() {
        return this.categories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateStoryCategories that = (UpdateStoryCategories) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(categories, that.categories);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UpdateStoryCategories{" +
                "id=" + id +
                ", categories=" + categories +
                '}';
    }

    public static class CategoryDto implements Serializable {
        private final Long id;

        public CategoryDto(Long id) {
            this.id = id;
        }

        public Long getId() {
            return this.id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            CategoryDto that = (CategoryDto) o;

            return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "CategoryDto{" +
                    "id=" + id +
                    '}';
        }
    }
}
