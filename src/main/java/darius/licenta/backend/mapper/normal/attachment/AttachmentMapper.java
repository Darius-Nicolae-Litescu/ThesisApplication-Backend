package darius.licenta.backend.mapper.normal.attachment;

import darius.licenta.backend.domain.sql.Attachment;
import darius.licenta.backend.dto.normal.attachment.AttachmentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AttachmentMapper {

    @Mapping(source = "uploadedByUsername", target = "uploadedBy.username")
    Attachment attachmentDtoToAttachment(AttachmentDto attachmentDto);

    @Mapping(source = "uploadedBy.username", target = "uploadedByUsername")
    AttachmentDto attachmentToAttachmentDto(Attachment attachment);

    @Mapping(source = "uploadedByUsername", target = "uploadedBy.username")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAttachmentFromAttachmentDto(AttachmentDto attachmentDto, @MappingTarget Attachment attachment);
}
