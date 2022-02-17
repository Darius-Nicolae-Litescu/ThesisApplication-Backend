package darius.licenta.backend.dto.normal.employee.insert;

import java.io.Serializable;
import java.util.Objects;

public class InsertEmployeeDto implements Serializable {
    private final Long personId;
    private final Long positionId;
    private final Long userId;

    public InsertEmployeeDto(Long personId, Long positionId, Long userId) {
        this.personId = personId;
        this.positionId = positionId;
        this.userId = userId;
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

        InsertEmployeeDto that = (InsertEmployeeDto) o;

        if (!Objects.equals(personId, that.personId)) return false;
        if (!Objects.equals(positionId, that.positionId)) return false;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        int result = personId != null ? personId.hashCode() : 0;
        result = 31 * result + (positionId != null ? positionId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        return result;
    }

    public String toString() {
        return "InsertEmployeeDto(personId=" + this.getPersonId() + ", positionId=" + this.getPositionId() + ", userId=" + this.getUserId() + ")";
    }
}
