package darius.licenta.backend.service.attachment;

import darius.licenta.backend.domain.Attachment;
import darius.licenta.backend.domain.Employee;
import darius.licenta.backend.dto.attachment.AttachmentDto;
import darius.licenta.backend.dto.employee.EmployeeDto;
import darius.licenta.backend.payload.response.ApiResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface AttachmentService {
    ApiResponse<AttachmentDto> getByAttachmentId(Long id);
    Attachment insertAttachment(Attachment attachment);
    void deleteAttachment(Long id);
    List<Attachment> findAll(Sort sort);
    Page<Attachment> findAll(Pageable pageable);
    void delete(Attachment attachment);
    long count();
}
