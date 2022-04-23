package darius.licenta.backend.dto.normal.employee.update;

import java.io.Serializable;
import java.util.Objects;

public class UpdateEmployeeDto implements Serializable {
    private final Long id;
    private final Long personId;
    private final Long positionId;
    private final Long userId;

    public UpdateEmployeeDto(Long id, Long personId, Long positionId, Long userId) {
        this.id = id;
        this.personId = personId;
        this.positionId = positionId;
        this.userId = userId;
    }

    public Long getId() {
        return this.id;
    }

    public Long getPersonId() {
        return this.personId;
    }

    public Long getPositionId() {
        return this.positionId;
    }

    public Long getUserId() {
        return this.userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UpdateEmployeeDto that = (UpdateEmployeeDto) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(personId, that.personId)) return false;
        if (!Objects.equals(positionId, that.positionId)) return false;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (personId != null ? personId.hashCode() : 0);
        result = 31 * result + (positionId != null ? positionId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UpdateEmployeeDto{" +
                "id=" + id +
                ", personId=" + personId +
                ", positionId=" + positionId +
                ", userId=" + userId +
                '}';
    }
}
