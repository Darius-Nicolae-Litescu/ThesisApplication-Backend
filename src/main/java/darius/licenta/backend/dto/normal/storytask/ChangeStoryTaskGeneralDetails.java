package darius.licenta.backend.dto.normal.storytask;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

public class ChangeStoryTaskGeneralDetails implements Serializable {
    private final Long id;
    private final int storyPoints;
    private final String assignedToUsername;
    private final String status;
    private final LocalDateTime finishedAt;

    public ChangeStoryTaskGeneralDetails(Long id, int storyPoints, String assignedToUsername, String status, LocalDateTime finishedAt) {
        this.id = id;
        this.storyPoints = storyPoints;
        this.assignedToUsername = assignedToUsername;
        this.status = status;
        this.finishedAt = finishedAt;
    }


    public Long getId() {
        return this.id;
    }

    public int getStoryPoints() {
        return this.storyPoints;
    }

    public String getAssignedToUsername() {
        return this.assignedToUsername;
    }

    public String getStatus() {
        return this.status;
    }

    public LocalDateTime getFinishedAt() {
        return this.finishedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChangeStoryTaskGeneralDetails that = (ChangeStoryTaskGeneralDetails) o;

        if (storyPoints != that.storyPoints) return false;
        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(assignedToUsername, that.assignedToUsername))
            return false;
        if (!Objects.equals(status, that.status)) return false;
        return Objects.equals(finishedAt, that.finishedAt);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + storyPoints;
        result = 31 * result + (assignedToUsername != null ? assignedToUsername.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (finishedAt != null ? finishedAt.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChangeStoryTaskGeneralDetails{" +
                "id=" + id +
                ", storyPoints=" + storyPoints +
                ", assignedToUsername='" + assignedToUsername + '\'' +
                ", status='" + status + '\'' +
                ", finishedAt=" + finishedAt +
                '}';
    }
}
