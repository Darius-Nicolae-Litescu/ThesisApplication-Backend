package darius.licenta.backend.dto.story;

import java.io.Serializable;

public class UpdateStoryCategory implements Serializable {
    private long storyId;
    private long categoryId;

    public UpdateStoryCategory(long storyId, long categoryId) {
        this.storyId = storyId;
        this.categoryId = categoryId;
    }

    public UpdateStoryCategory() {
    }

    public long getStoryId() {
        return this.storyId;
    }

    public long getCategoryId() {
        return this.categoryId;
    }

    public void setStoryId(long storyId) {
        this.storyId = storyId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UpdateStoryCategory)) return false;
        final UpdateStoryCategory other = (UpdateStoryCategory) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getStoryId() != other.getStoryId()) return false;
        if (this.getCategoryId() != other.getCategoryId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UpdateStoryCategory;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $storyId = this.getStoryId();
        result = result * PRIME + (int) ($storyId >>> 32 ^ $storyId);
        final long $categoryId = this.getCategoryId();
        result = result * PRIME + (int) ($categoryId >>> 32 ^ $categoryId);
        return result;
    }

    public String toString() {
        return "UpdateStoryCategory(storyId=" + this.getStoryId() + ", categoryId=" + this.getCategoryId() + ")";
    }
}
