package darius.licenta.backend.dto.story;

import java.io.Serializable;

public class InsertStoryDto implements Serializable {
    private String description;

    public InsertStoryDto(String description) {
        this.description = description;
    }

    public InsertStoryDto() {
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof InsertStoryDto)) return false;
        final InsertStoryDto other = (InsertStoryDto) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof InsertStoryDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        return result;
    }

    public String toString() {
        return "InsertStoryDto(description=" + this.getDescription() + ")";
    }
}
