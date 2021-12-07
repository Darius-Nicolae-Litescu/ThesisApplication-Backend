package darius.licenta.backend.dto.storytask;

import java.io.Serializable;

public class AttachmentDto implements Serializable {
    private long id;

    public AttachmentDto(long id) {
        this.id = id;
    }

    public AttachmentDto() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof AttachmentDto)) return false;
        final AttachmentDto other = (AttachmentDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof AttachmentDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        return result;
    }

    public String toString() {
        return "AttachmentDto(id=" + this.getId() + ")";
    }
}
