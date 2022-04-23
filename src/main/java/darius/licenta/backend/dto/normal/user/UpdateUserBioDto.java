package darius.licenta.backend.dto.normal.user;

import java.io.Serializable;
import java.util.Objects;

public class UpdateUserBioDto implements Serializable {
    private final String bioDescription;

    public UpdateUserBioDto(String bioDescription) {
        this.bioDescription = bioDescription;
    }


    public String getBioDescription() {
        return this.bioDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateUserBioDto that = (UpdateUserBioDto) o;

        return Objects.equals(bioDescription, that.bioDescription);
    }

    @Override
    public int hashCode() {
        return bioDescription != null ? bioDescription.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "UpdateUserBioDto{" +
                "bioDescription='" + bioDescription + '\'' +
                '}';
    }
}
