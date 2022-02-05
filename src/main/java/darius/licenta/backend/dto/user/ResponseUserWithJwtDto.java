package darius.licenta.backend.dto.user;

import darius.licenta.backend.domain.UserRole;

import java.io.Serializable;
import java.util.List;

public class ResponseUserWithJwtDto implements Serializable {
    private final Long id;
    private final String username;
    private final String email;
    private final String jwtToken;
    private final List<UserRole> roles;

    public ResponseUserWithJwtDto(ResponseUserDto responseUserDto, String jwtToken, List<UserRole> roles)
    {
        this.id = responseUserDto.getId();
        this.username = responseUserDto.getUsername();;
        this.email = responseUserDto.getEmail();
        this.jwtToken = jwtToken;
        this.roles = roles;
    }

    public Long getId() {
        return this.id;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public String getUsername() {
        return this.username;
    }

    public String getEmail() {
        return this.email;
    }

    public String getJwtToken() {
        return this.jwtToken;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ResponseUserWithJwtDto)) return false;
        final ResponseUserWithJwtDto other = (ResponseUserWithJwtDto) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$username = this.getUsername();
        final Object other$username = other.getUsername();
        if (this$username == null ? other$username != null : !this$username.equals(other$username)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$jwtToken = this.getJwtToken();
        final Object other$jwtToken = other.getJwtToken();
        if (this$jwtToken == null ? other$jwtToken != null : !this$jwtToken.equals(other$jwtToken)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ResponseUserWithJwtDto;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final long $id = this.getId();
        result = result * PRIME + (int) ($id >>> 32 ^ $id);
        final Object $username = this.getUsername();
        result = result * PRIME + ($username == null ? 43 : $username.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $jwtToken = this.getJwtToken();
        result = result * PRIME + ($jwtToken == null ? 43 : $jwtToken.hashCode());
        return result;
    }

    public String toString() {
        return "ResponseUserWithDto(id=" + this.getId() + ", username=" + this.getUsername() + ", email=" + this.getEmail() + ", jwtToken=" + this.getJwtToken() + ")";
    }
}
