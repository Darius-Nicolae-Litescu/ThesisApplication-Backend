package darius.licenta.backend.dto.storytask;

import java.io.Serializable;

public class UserDto implements Serializable {
    private long id;

    public UserDto(long id) {
        this.id = id;
    }

    public UserDto() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UserDto)) return false;
        final UserDto other = (UserDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UserDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        return result;
    }

    public String toString() {
        return "UserDto(id=" + this.getId() + ")";
    }
}
