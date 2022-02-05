package darius.licenta.backend.dto.story;

import java.io.Serializable;
import java.util.Set;

public class UpdateStoryPriority implements Serializable {
    private final long id;
    private final Set<PriorityDto1> priority;

    public UpdateStoryPriority(long id, Set<PriorityDto1> priority) {
        this.id = id;
        this.priority = priority;
    }

    public long getId() {
        return this.id;
    }

    public Set<PriorityDto1> getPriority() {
        return this.priority;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UpdateStoryPriority)) return false;
        final UpdateStoryPriority other = (UpdateStoryPriority) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$priority = this.getPriority();
        final Object other$priority = other.getPriority();
        if (this$priority == null ? other$priority != null : !this$priority.equals(other$priority)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UpdateStoryPriority;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $priority = this.getPriority();
        result = result * PRIME + ($priority == null ? 43 : $priority.hashCode());
        return result;
    }

    public String toString() {
        return "UpdateStoryPriority(id=" + this.getId() + ", priority=" + this.getPriority() + ")";
    }

    public static class PriorityDto1 implements Serializable {
        private final long id;

        public PriorityDto1(long id) {
            this.id = id;
        }

        public long getId() {
            return this.id;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof PriorityDto1)) return false;
            final PriorityDto1 other = (PriorityDto1) o;
            if (!other.canEqual((Object) this)) return false;
            if (this.getId() != other.getId()) return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof PriorityDto1;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final long $id = this.getId();
            result = result * PRIME + (int) ($id >>> 32 ^ $id);
            return result;
        }

        public String toString() {
            return "UpdateStoryPriority.PriorityDto1(id=" + this.getId() + ")";
        }
    }
}
