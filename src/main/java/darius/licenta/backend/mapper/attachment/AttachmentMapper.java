package darius.licenta.backend.mapper.attachment;

import darius.licenta.backend.domain.Attachment;
import darius.licenta.backend.dto.attachment.AttachmentDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AttachmentMapper {
    Attachment attachmentDtoToAttachment(AttachmentDto attachmentDto);

    AttachmentDto attachmentToAttachmentDto(Attachment attachment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateAttachmentFromAttachmentDto(AttachmentDto attachmentDto, @MappingTarget Attachment attachment);
}
