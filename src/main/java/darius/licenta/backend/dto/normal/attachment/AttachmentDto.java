package darius.licenta.backend.dto.normal.attachment;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;

public class AttachmentDto implements Serializable {
    private final String id;
    private final String name;
    private final String contentType;
    private final byte[] content;
    private final LocalDateTime postedAt;
    private final String uploadedByUsername;

    public AttachmentDto(String id, String name, String contentType, byte[] content, LocalDateTime postedAt, String uploadedByUsername) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
        this.content = content;
        this.postedAt = postedAt;
        this.uploadedByUsername = uploadedByUsername;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getContentType() {
        return this.contentType;
    }

    public byte[] getContent() {
        return this.content;
    }

    public LocalDateTime getPostedAt() {
        return this.postedAt;
    }

    public String getUploadedByUsername() {
        return this.uploadedByUsername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttachmentDto that = (AttachmentDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(contentType, that.contentType)) return false;
        if (!Arrays.equals(content, that.content)) return false;
        if (!Objects.equals(postedAt, that.postedAt)) return false;
        return Objects.equals(uploadedByUsername, that.uploadedByUsername);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(content);
        result = 31 * result + (postedAt != null ? postedAt.hashCode() : 0);
        result = 31 * result + (uploadedByUsername != null ? uploadedByUsername.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "AttachmentDto{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                ", content=" + Arrays.toString(content) +
                ", postedAt=" + postedAt +
                ", uploadedByUsername='" + uploadedByUsername + '\'' +
                '}';
    }
}
