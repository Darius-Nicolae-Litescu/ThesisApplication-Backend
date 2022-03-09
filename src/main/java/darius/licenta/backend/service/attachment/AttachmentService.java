package darius.licenta.backend.service.attachment;

import darius.licenta.backend.dto.normal.attachment.AttachmentDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import org.springframework.web.multipart.MultipartFile;

public interface AttachmentService {
    ApiResponse<AttachmentDto> getByAttachmentId(Long id);

    ApiResponse<AttachmentDto> insertAttachment(MultipartFile attachment, String uploadedByUsername);

    ApiResponse<PaginatedResponse<AttachmentDto>> getAllByUsername(String username, int page, int size);

    ApiResponse<PaginatedResponse<AttachmentDto>> findAll(int page, int size);

    ApiResponse<Long> countAll();

    ApiResponse<AttachmentDto> deleteAttachment(Long id);
}
