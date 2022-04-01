package darius.licenta.backend.mapper.elasticsearch.comment;

import darius.licenta.backend.domain.sql.Comment;
import darius.licenta.backend.domain.elasticsearch.ElasticSearchCommentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ElasticSearchCommentMapper {

    @Mapping(source = "postedByUsername", target = "postedBy.username")
    @Mapping(source = "postedByEmail", target = "postedBy.email")
    Comment elasticSearchCommentDtoToComment(ElasticSearchCommentDto elasticSearchCommentDto);

    @InheritInverseConfiguration(name = "elasticSearchCommentDtoToComment")
    ElasticSearchCommentDto commentToElasticSearchCommentDto(Comment comment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCommentFromElasticSearchCommentDto(ElasticSearchCommentDto elasticSearchCommentDto, @MappingTarget Comment comment);
}
