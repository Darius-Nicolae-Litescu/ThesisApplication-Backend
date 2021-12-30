package darius.licenta.backend.service.attachment;

import darius.licenta.backend.domain.Attachment;
import darius.licenta.backend.dto.attachment.AttachmentDto;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.persistence.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public class AttachmentServiceImpl implements AttachmentService{

    private final AttachmentRepository attachmentRepository;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository)
    {
        this.attachmentRepository = attachmentRepository;
    }

    @Override
    public ApiResponse<AttachmentDto> getByAttachmentId(Long id) {
        return null;
    }

    @Override
    public Attachment insertAttachment(Attachment attachment) {
        return attachmentRepository.save(attachment);
    }

    @Override
    public void deleteAttachment(Long id) {

    }

    @Override
    public List<Attachment> findAll(Sort sort){
        return attachmentRepository.findAll(sort);
    }

    @Override
    public Page<Attachment> findAll(Pageable pageable){
        return attachmentRepository.findAll(pageable);
    }

    @Override
    public void delete(Attachment attachment) {
        attachmentRepository.delete(attachment);
    }

    @Override
    public long count() {
        return attachmentRepository.count();
    }
}
