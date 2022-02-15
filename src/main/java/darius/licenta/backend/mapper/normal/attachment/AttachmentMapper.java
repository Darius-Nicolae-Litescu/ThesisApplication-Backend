package darius.licenta.backend.mapper.normal.attachment;

import darius.licenta.backend.domain.sql.Attachment;
import darius.licenta.backend.dto.normal.attachment.AttachmentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AttachmentMapper {
    Attachment attachmentDtoToAttachment(AttachmentDto attachmentDto);

    AttachmentDto attachmentToAttachmentDto(Attachment attachment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAttachmentFromAttachmentDto(AttachmentDto attachmentDto, @MappingTarget Attachment attachment);
}
