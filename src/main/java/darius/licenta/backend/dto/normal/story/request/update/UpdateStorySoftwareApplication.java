package darius.licenta.backend.dto.normal.story.request.update;

import java.io.Serializable;
import java.util.Objects;

public class UpdateStorySoftwareApplication implements Serializable {
    private final Long id;
    private final SoftwareApplicationDto softwareApplication;

    public UpdateStorySoftwareApplication(Long id, SoftwareApplicationDto softwareApplication) {
        this.id = id;
        this.softwareApplication = softwareApplication;
    }

    public Long getId() {
        return this.id;
    }

    public SoftwareApplicationDto getSoftwareApplication() {
        return this.softwareApplication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateStorySoftwareApplication that = (UpdateStorySoftwareApplication) o;

        if (!Objects.equals(id, that.id)) return false;
        return Objects.equals(softwareApplication, that.softwareApplication);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (softwareApplication != null ? softwareApplication.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UpdateStorySoftwareApplication{" +
                "id=" + id +
                ", softwareApplication=" + softwareApplication +
                '}';
    }

    public static class SoftwareApplicationDto implements Serializable {
        private final Long id;

        public SoftwareApplicationDto(Long id) {
            this.id = id;
        }


        public Long getId() {
            return this.id;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            SoftwareApplicationDto that = (SoftwareApplicationDto) o;

            return Objects.equals(id, that.id);
        }

        @Override
        public int hashCode() {
            return id != null ? id.hashCode() : 0;
        }
    }
}
