package darius.licenta.backend.dto.storytask;

import java.io.Serializable;

public class StoryCommentDto implements Serializable {
    private long id;

    public StoryCommentDto(long id) {
        this.id = id;
    }

    public StoryCommentDto() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StoryCommentDto)) return false;
        final StoryCommentDto other = (StoryCommentDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StoryCommentDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        return result;
    }

    public String toString() {
        return "StoryCommentDto(id=" + this.getId() + ")";
    }
}
