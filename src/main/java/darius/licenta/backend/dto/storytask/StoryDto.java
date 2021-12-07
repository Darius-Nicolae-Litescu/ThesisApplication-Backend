package darius.licenta.backend.dto.storytask;

import java.io.Serializable;

public class StoryDto implements Serializable {
    private long id;

    public StoryDto(long id) {
        this.id = id;
    }

    public StoryDto() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof StoryDto)) return false;
        final StoryDto other = (StoryDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof StoryDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        return result;
    }

    public String toString() {
        return "StoryDto(id=" + this.getId() + ")";
    }
}
