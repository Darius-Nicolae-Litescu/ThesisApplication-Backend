package darius.licenta.backend.dto.normal.story.request.update;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

public class ChangeStoryGeneralDetails implements Serializable {
    private final Long id;
    private final Set<Long> categoryIds;
    private final Long priorityId;

    public ChangeStoryGeneralDetails(Long id, Set<Long> categoryIds, Long priorityId) {
        this.id = id;
        this.categoryIds = categoryIds;
        this.priorityId = priorityId;
    }


    public Long getId() {
        return this.id;
    }

    public Set<Long> getCategoryIds() {
        return this.categoryIds;
    }

    public Long getPriorityId() {
        return this.priorityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ChangeStoryGeneralDetails that = (ChangeStoryGeneralDetails) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(categoryIds, that.categoryIds)) return false;
        return Objects.equals(priorityId, that.priorityId);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (categoryIds != null ? categoryIds.hashCode() : 0);
        result = 31 * result + (priorityId != null ? priorityId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ChangeStoryGeneralDetails{" +
                "id=" + id +
                ", categoryIds=" + categoryIds +
                ", priorityId=" + priorityId +
                '}';
    }
}
