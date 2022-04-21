package darius.licenta.backend.dto.normal.attachment;

import java.time.LocalDateTime;
import java.util.Objects;

public class AttachmentResponseDto {
    private Long id;
    private LocalDateTime postedAt;
    private String name;
    private String url;
    private String contentType;
    private long size;

    public AttachmentResponseDto() {
    }

    public Long getId() {
        return this.id;
    }

    public LocalDateTime getPostedAt() {
        return this.postedAt;
    }

    public String getName() {
        return this.name;
    }

    public String getUrl() {
        return this.url;
    }

    public String getContentType() {
        return this.contentType;
    }

    public long getSize() {
        return this.size;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AttachmentResponseDto that = (AttachmentResponseDto) o;

        if (size != that.size) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(postedAt, that.postedAt)) return false;
        if (!Objects.equals(name, that.name)) return false;
        if (!Objects.equals(url, that.url)) return false;
        return Objects.equals(contentType, that.contentType);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (postedAt != null ? postedAt.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + (int) (size ^ (size >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "AttachmentResponseDto{" +
                "id=" + id +
                ", postedAt=" + postedAt +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", contentType='" + contentType + '\'' +
                ", size=" + size +
                '}';
    }
}
