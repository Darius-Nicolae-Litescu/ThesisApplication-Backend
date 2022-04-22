package darius.licenta.backend.domain.sql;

import org.springframework.security.core.GrantedAuthority;

public enum UserRole implements GrantedAuthority {

    ADMIN(Rank.ADMIN),
    USER(Rank.USER),
    BOARD_ADMIN(Rank.BOARD_ADMIN);

    private final String authority;

    UserRole(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }

    public static class Rank {
        public static final String ADMIN = "ROLE_ADMIN";
        public static final String USER = "ROLE_USER";
        public static final String BOARD_ADMIN = "ROLE_BOARD_ADMIN";

        private Rank() {
        }

    }
}