package darius.licenta.backend.dto.normal.story.request.update;

import java.io.Serializable;
import java.util.Objects;

public class UpdateStoryPriority implements Serializable {
    private final Long id;
    private final PriorityDto priority;

    public UpdateStoryPriority(Long id, PriorityDto priority) {
        this.id = id;
        this.priority = priority;
    }

    public Long getId() {
        return this.id;
    }

    public PriorityDto getPriority() {
        return this.priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateStoryPriority that = (UpdateStoryPriority) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(priority, that.priority);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (priority != null ? priority.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UpdateStoryPriority{" +
                "id=" + id +
                ", priority=" + priority +
                '}';
    }

    public static class PriorityDto implements Serializable {
        private final Long id;

        public PriorityDto(Long id) {
            this.id = id;
        }


        public Long getId() {
            return this.id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            PriorityDto that = (PriorityDto) o;

            return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }

        @Override
        public String toString() {
            return "PriorityDto{" +
                    "id=" + id +
                    '}';
        }
    }
}
