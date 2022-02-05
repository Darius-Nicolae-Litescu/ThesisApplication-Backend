package darius.licenta.backend.dto.story;

import java.io.Serializable;

public class UpdateStorySoftwareApplication implements Serializable {
    private final long id;
    private final SoftwareApplicationDto softwareApplication;

    public UpdateStorySoftwareApplication(long id, SoftwareApplicationDto softwareApplication) {
        this.id = id;
        this.softwareApplication = softwareApplication;
    }

    public long getId() {
        return this.id;
    }

    public SoftwareApplicationDto getSoftwareApplication() {
        return this.softwareApplication;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof UpdateStorySoftwareApplication)) return false;
        final UpdateStorySoftwareApplication other = (UpdateStorySoftwareApplication) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$softwareApplication = this.getSoftwareApplication();
        final Object other$softwareApplication = other.getSoftwareApplication();
        if (this$softwareApplication == null ? other$softwareApplication != null : !this$softwareApplication.equals(other$softwareApplication))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof UpdateStorySoftwareApplication;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $softwareApplication = this.getSoftwareApplication();
        result = result * PRIME + ($softwareApplication == null ? 43 : $softwareApplication.hashCode());
        return result;
    }

    public String toString() {
        return "UpdateStorySoftwareApplication(id=" + this.getId() + ", softwareApplication=" + this.getSoftwareApplication() + ")";
    }

    public static class SoftwareApplicationDto implements Serializable {
        private final long id;

        public SoftwareApplicationDto(long id) {
            this.id = id;
        }

        public long getId() {
            return this.id;
        }

        public boolean equals(final Object o) {
            if (o == this) return true;
            if (!(o instanceof SoftwareApplicationDto))
                return false;
            final SoftwareApplicationDto other = (SoftwareApplicationDto) o;
            if (!other.canEqual((Object) this)) return false;
            if (this.getId() != other.getId()) return false;
            return true;
        }

        protected boolean canEqual(final Object other) {
            return other instanceof SoftwareApplicationDto;
        }

        public int hashCode() {
            final int PRIME = 59;
            int result = 1;
            final long $id = this.getId();
            result = result * PRIME + (int) ($id >>> 32 ^ $id);
            return result;
        }

        public String toString() {
            return "UpdateStorySoftwareApplication.SoftwareApplicationDto(id=" + this.getId() + ")";
        }
    }
}
