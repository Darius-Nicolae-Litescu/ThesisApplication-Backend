package darius.licenta.backend.service.attachment;

import darius.licenta.backend.domain.Attachment;
import darius.licenta.backend.domain.Employee;
import darius.licenta.backend.dto.attachment.AttachmentDto;
import darius.licenta.backend.dto.employee.EmployeeDto;
import darius.licenta.backend.dto.story.StoryDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface AttachmentService {
    ApiResponse<AttachmentDto> getByAttachmentId(Long id);
    ApiResponse<AttachmentDto> insertAttachment(AttachmentDto attachmentDto);

    ApiResponse<PaginatedResponse<AttachmentDto>> getAllByUsername(String username, int page, int size);

    ApiResponse<PaginatedResponse<AttachmentDto>> findAll(int page, int size);

    ApiResponse<Long> countAll();
    ApiResponse<AttachmentDto> deleteAttachment(Long id);
}
