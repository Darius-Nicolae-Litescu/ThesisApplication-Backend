package darius.licenta.backend.domain.sql;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = Picture.TABLE_NAME)
public class Picture {
    public static final String TABLE_NAME = "picture";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 256)
    private String name;

    @Column(name = "content_type", nullable = false, length = 1024)
    private String contentType;

    @Column(name = "content", nullable = false)
    @Lob
    private byte[] content;

    @CreationTimestamp
    @Column(name = "uploaded_at", nullable = false)
    private LocalDateTime postedAt;

    @OneToOne(mappedBy = "profilePicture")
    private User uploadedBy;

    public Picture() {
    }

    public Picture(String name, String contentType, byte[] content, User uploadedBy) {
        this.name = name;
        this.contentType = contentType;
        this.content = content;
        this.uploadedBy = uploadedBy;
    }

    public Picture(Long id, String name, String contentType, byte[] content, LocalDateTime postedAt, User uploadedBy) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
        this.content = content;
        this.postedAt = postedAt;
        this.uploadedBy = uploadedBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Picture that = (Picture) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(contentType, that.contentType)) return false;
        return Objects.equals(postedAt, that.postedAt);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public User getUploadedBy() {
        return uploadedBy;
    }

    public void setUploadedBy(User uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (contentType != null ? contentType.hashCode() : 0);
        result = 31 * result + (postedAt != null ? postedAt.hashCode() : 0);
        return result;
    }
}