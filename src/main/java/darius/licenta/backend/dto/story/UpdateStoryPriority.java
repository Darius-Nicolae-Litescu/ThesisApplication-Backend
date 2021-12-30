package darius.licenta.backend.dto.story;

import java.io.Serializable;

public class UpdateStoryPriority implements Serializable {
    private long storyId;
    private long priorityId;

    public UpdateStoryPriority(long storyId, long priorityId) {
        this.storyId = storyId;
        this.priorityId = priorityId;
    }

    public UpdateStoryPriority() {
    }

    public long getStoryId() {
        return this.storyId;
    }

    public long getPriorityId() {
        return this.priorityId;
    }

    public void setStoryId(long storyId) {
        this.storyId = storyId;
    }

    public void setPriorityId(long priorityId) {
        this.priorityId = priorityId;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UpdateStoryPriority)) return false;
        final UpdateStoryPriority other = (UpdateStoryPriority) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getStoryId() != other.getStoryId()) return false;
        if (this.getPriorityId() != other.getPriorityId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UpdateStoryPriority;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $storyId = this.getStoryId();
        result = result * PRIME + (int) ($storyId >>> 32 ^ $storyId);
        final long $priorityId = this.getPriorityId();
        result = result * PRIME + (int) ($priorityId >>> 32 ^ $priorityId);
        return result;
    }

    public String toString() {
        return "UpdateStoryPriority(storyId=" + this.getStoryId() + ", priorityId=" + this.getPriorityId() + ")";
    }
}
