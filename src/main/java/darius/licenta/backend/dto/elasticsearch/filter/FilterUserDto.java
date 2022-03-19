package darius.licenta.backend.dto.elasticsearch.filter;

import lombok.Data;

@Data
public class FilterUserDto {
    private final String username;
    private final String email;
}
