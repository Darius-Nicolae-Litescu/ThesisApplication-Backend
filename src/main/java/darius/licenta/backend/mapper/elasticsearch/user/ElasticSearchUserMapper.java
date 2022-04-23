package darius.licenta.backend.mapper.elasticsearch.user;

import darius.licenta.backend.domain.elasticsearch.ElasticSearchUserDto;
import darius.licenta.backend.domain.sql.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElasticSearchUserMapper {
    User elasticSearchUserDtoToUser(ElasticSearchUserDto elasticSearchUserDto);

    ElasticSearchUserDto userToElasticSearchUserDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateUserFromElasticSearchUserDto(ElasticSearchUserDto elasticSearchUserDto, @MappingTarget User user);
}
