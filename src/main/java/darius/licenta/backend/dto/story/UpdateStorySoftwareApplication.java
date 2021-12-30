package darius.licenta.backend.dto.story;

import java.io.Serializable;

public class UpdateStorySoftwareApplication implements Serializable {
    private long storyId;
    private long softwareApplicationId;

    public UpdateStorySoftwareApplication(long storyId, long softwareApplicationId) {
        this.storyId = storyId;
        this.softwareApplicationId = softwareApplicationId;
    }

    public UpdateStorySoftwareApplication() {
    }

    public long getStoryId() {
        return this.storyId;
    }

    public long getSoftwareApplicationId() {
        return this.softwareApplicationId;
    }

    public void setStoryId(long storyId) {
        this.storyId = storyId;
    }

    public void setSoftwareApplicationId(long softwareApplicationId) {
        this.softwareApplicationId = softwareApplicationId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UpdateStorySoftwareApplication)) return false;
        final UpdateStorySoftwareApplication other = (UpdateStorySoftwareApplication) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getStoryId() != other.getStoryId()) return false;
        if (this.getSoftwareApplicationId() != other.getSoftwareApplicationId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UpdateStorySoftwareApplication;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $storyId = this.getStoryId();
        result = result * PRIME + (int) ($storyId >>> 32 ^ $storyId);
        final long $softwareApplicationId = this.getSoftwareApplicationId();
        result = result * PRIME + (int) ($softwareApplicationId >>> 32 ^ $softwareApplicationId);
        return result;
    }

    public String toString() {
        return "UpdateStorySoftwareApplication(storyId=" + this.getStoryId() + ", softwareApplicationId=" + this.getSoftwareApplicationId() + ")";
    }
}
