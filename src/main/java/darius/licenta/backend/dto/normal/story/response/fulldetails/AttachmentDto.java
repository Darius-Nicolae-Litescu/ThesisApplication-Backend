package darius.licenta.backend.dto.normal.story.response.fulldetails;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class AttachmentDto implements Serializable {
    private final Long id;
    private final LocalDateTime postedAt;

    public AttachmentDto(Long id, LocalDateTime postedAt) {
        this.id = id;
        this.postedAt = postedAt;
    }


    public Long getId() {
        return this.id;
    }

    public LocalDateTime getPostedAt() {
        return this.postedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttachmentDto that = (AttachmentDto) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(postedAt, that.postedAt);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (postedAt != null ? postedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AttachmentDto{" +
                "id=" + id +
                ", postedAt=" + postedAt +
                '}';
    }
}
