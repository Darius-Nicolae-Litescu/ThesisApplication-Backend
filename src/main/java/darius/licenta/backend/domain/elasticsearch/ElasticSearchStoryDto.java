package darius.licenta.backend.domain.elasticsearch;

import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Document(indexName = "story")
public class ElasticSearchStoryDto implements Serializable {
    private final Long id;
    private final String title;
    private final String description;
    private final Date modificationDate;
    private final Set<CategoryDto> categories;
    private final Long priorityId;
    private final String priorityTitle;
    private final String priorityDescription;
    private final Integer priorityLevel;
    private final Blob priorityPriorityIcon;
    private final Long softwareApplicationId;
    private final String softwareApplicationName;
    private final String softwareApplicationDescription;
    private final Date softwareApplicationModificationDate;

    public ElasticSearchStoryDto(Long id, String title, String description, Date modificationDate, Set<CategoryDto> categories, Long priorityId, String priorityTitle, String priorityDescription, Integer priorityLevel, Blob priorityPriorityIcon, Long softwareApplicationId, String softwareApplicationName, String softwareApplicationDescription, Date softwareApplicationModificationDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.modificationDate = modificationDate;
        this.categories = categories;
        this.priorityId = priorityId;
        this.priorityTitle = priorityTitle;
        this.priorityDescription = priorityDescription;
        this.priorityLevel = priorityLevel;
        this.priorityPriorityIcon = priorityPriorityIcon;
        this.softwareApplicationId = softwareApplicationId;
        this.softwareApplicationName = softwareApplicationName;
        this.softwareApplicationDescription = softwareApplicationDescription;
        this.softwareApplicationModificationDate = softwareApplicationModificationDate;
    }

    public Long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getModificationDate() {
        return this.modificationDate;
    }

    public Set<CategoryDto> getCategories() {
        return this.categories;
    }

    public Long getPriorityId() {
        return this.priorityId;
    }

    public String getPriorityTitle() {
        return this.priorityTitle;
    }

    public String getPriorityDescription() {
        return this.priorityDescription;
    }

    public Integer getPriorityLevel() {
        return this.priorityLevel;
    }

    public Blob getPriorityPriorityIcon() {
        return this.priorityPriorityIcon;
    }

    public Long getSoftwareApplicationId() {
        return this.softwareApplicationId;
    }

    public String getSoftwareApplicationName() {
        return this.softwareApplicationName;
    }

    public String getSoftwareApplicationDescription() {
        return this.softwareApplicationDescription;
    }

    public Date getSoftwareApplicationModificationDate() {
        return this.softwareApplicationModificationDate;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ElasticSearchStoryDto)) return false;
        final ElasticSearchStoryDto other = (ElasticSearchStoryDto) o;
        if (!other.canEqual(this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) return false;
        final Object this$title = this.getTitle();
        final Object other$title = other.getTitle();
        if (!Objects.equals(this$title, other$title)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (!Objects.equals(this$description, other$description))
            return false;
        final Object this$modificationDate = this.getModificationDate();
        final Object other$modificationDate = other.getModificationDate();
        if (!Objects.equals(this$modificationDate, other$modificationDate))
            return false;
        final Object this$categories = this.getCategories();
        final Object other$categories = other.getCategories();
        if (!Objects.equals(this$categories, other$categories))
            return false;
        final Object this$priorityId = this.getPriorityId();
        final Object other$priorityId = other.getPriorityId();
        if (!Objects.equals(this$priorityId, other$priorityId))
            return false;
        final Object this$priorityTitle = this.getPriorityTitle();
        final Object other$priorityTitle = other.getPriorityTitle();
        if (!Objects.equals(this$priorityTitle, other$priorityTitle))
            return false;
        final Object this$priorityDescription = this.getPriorityDescription();
        final Object other$priorityDescription = other.getPriorityDescription();
        if (!Objects.equals(this$priorityDescription, other$priorityDescription))
            return false;
        if (this.getPriorityLevel() != other.getPriorityLevel()) return false;
        final Object this$priorityPriorityIcon = this.getPriorityPriorityIcon();
        final Object other$priorityPriorityIcon = other.getPriorityPriorityIcon();
        if (!Objects.equals(this$priorityPriorityIcon, other$priorityPriorityIcon))
            return false;
        final Object this$softwareApplicationId = this.getSoftwareApplicationId();
        final Object other$softwareApplicationId = other.getSoftwareApplicationId();
        if (!Objects.equals(this$softwareApplicationId, other$softwareApplicationId))
            return false;
        final Object this$softwareApplicationName = this.getSoftwareApplicationName();
        final Object other$softwareApplicationName = other.getSoftwareApplicationName();
        if (!Objects.equals(this$softwareApplicationName, other$softwareApplicationName))
            return false;
        final Object this$softwareApplicationDescription = this.getSoftwareApplicationDescription();
        final Object other$softwareApplicationDescription = other.getSoftwareApplicationDescription();
        if (!Objects.equals(this$softwareApplicationDescription, other$softwareApplicationDescription))
            return false;
        final Object this$softwareApplicationModificationDate = this.getSoftwareApplicationModificationDate();
        final Object other$softwareApplicationModificationDate = other.getSoftwareApplicationModificationDate();
        return Objects.equals(this$softwareApplicationModificationDate, other$softwareApplicationModificationDate);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ElasticSearchStoryDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $title = this.getTitle();
        result = result * PRIME + ($title == null ? 43 : $title.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $modificationDate = this.getModificationDate();
        result = result * PRIME + ($modificationDate == null ? 43 : $modificationDate.hashCode());
        final Object $categories = this.getCategories();
        result = result * PRIME + ($categories == null ? 43 : $categories.hashCode());
        final Object $priorityId = this.getPriorityId();
        result = result * PRIME + ($priorityId == null ? 43 : $priorityId.hashCode());
        final Object $priorityTitle = this.getPriorityTitle();
        result = result * PRIME + ($priorityTitle == null ? 43 : $priorityTitle.hashCode());
        final Object $priorityDescription = this.getPriorityDescription();
        result = result * PRIME + ($priorityDescription == null ? 43 : $priorityDescription.hashCode());
        result = result * PRIME + this.getPriorityLevel();
        final Object $priorityPriorityIcon = this.getPriorityPriorityIcon();
        result = result * PRIME + ($priorityPriorityIcon == null ? 43 : $priorityPriorityIcon.hashCode());
        final Object $softwareApplicationId = this.getSoftwareApplicationId();
        result = result * PRIME + ($softwareApplicationId == null ? 43 : $softwareApplicationId.hashCode());
        final Object $softwareApplicationName = this.getSoftwareApplicationName();
        result = result * PRIME + ($softwareApplicationName == null ? 43 : $softwareApplicationName.hashCode());
        final Object $softwareApplicationDescription = this.getSoftwareApplicationDescription();
        result = result * PRIME + ($softwareApplicationDescription == null ? 43 : $softwareApplicationDescription.hashCode());
        final Object $softwareApplicationModificationDate = this.getSoftwareApplicationModificationDate();
        result = result * PRIME + ($softwareApplicationModificationDate == null ? 43 : $softwareApplicationModificationDate.hashCode());
        return result;
    }

    public String toString() {
        return "ElasticSearchStoryDto(id=" + this.getId() + ", title=" + this.getTitle() + ", description=" + this.getDescription() + ", modificationDate=" + this.getModificationDate() + ", categories=" + this.getCategories() + ", priorityId=" + this.getPriorityId() + ", priorityTitle=" + this.getPriorityTitle() + ", priorityDescription=" + this.getPriorityDescription() + ", priorityLevel=" + this.getPriorityLevel() + ", priorityPriorityIcon=" + this.getPriorityPriorityIcon() + ", softwareApplicationId=" + this.getSoftwareApplicationId() + ", softwareApplicationName=" + this.getSoftwareApplicationName() + ", softwareApplicationDescription=" + this.getSoftwareApplicationDescription() + ", softwareApplicationModificationDate=" + this.getSoftwareApplicationModificationDate() + ")";
    }

    public static class CategoryDto implements Serializable {
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
            if (!other.canEqual(this)) return false;
            final Object this$id = this.getId();
            final Object other$id = other.getId();
            if (!Objects.equals(this$id, other$id)) return false;
            final Object this$categoryName = this.getCategoryName();
            final Object other$categoryName = other.getCategoryName();
            if (!Objects.equals(this$categoryName, other$categoryName))
                return false;
            final Object this$categoryPicture = this.getCategoryPicture();
            final Object other$categoryPicture = other.getCategoryPicture();
            return Objects.equals(this$categoryPicture, other$categoryPicture);
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
            return "ElasticSearchStoryDto.CategoryDto(id=" + this.getId() + ", categoryName=" + this.getCategoryName() + ", categoryPicture=" + this.getCategoryPicture() + ")";
        }
    }
}
