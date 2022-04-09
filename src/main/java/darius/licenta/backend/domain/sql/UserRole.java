package darius.licenta.backend.domain.sql;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {

    MODERATOR(Rank.MODERATOR),
    ADMIN(Rank.ADMIN),
    USER(Rank.USER);

    private final String authority;

    UserRole(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public static class Rank {
        public static final String MODERATOR = "ROLE_MODERATOR";
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String USER = "ROLE_USER";
        private Rank(){
        };
    }
}