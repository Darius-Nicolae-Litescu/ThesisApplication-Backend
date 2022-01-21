package darius.licenta.backend.service.attachment;

import darius.licenta.backend.domain.Attachment;
import darius.licenta.backend.dto.attachment.AttachmentDto;
import darius.licenta.backend.mapper.attachment.AttachmentMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.persistence.AttachmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AttachmentServiceImpl implements AttachmentService {

    private final AttachmentRepository attachmentRepository;
    private final AttachmentMapper attachmentMapper;

    public AttachmentServiceImpl(AttachmentRepository attachmentRepository, AttachmentMapper attachmentMapper) {
        this.attachmentRepository = attachmentRepository;
        this.attachmentMapper = attachmentMapper;
    }


    @Override
    public ApiResponse<AttachmentDto> getByAttachmentId(Long id) {
        Optional<Attachment> attachment = attachmentRepository.findById(id);
        if (attachment.isPresent()) {
            AttachmentDto attachmentDto = attachmentMapper.attachmentToAttachmentDto(attachment.get());
            return new ApiResponse<>(attachmentDto, HttpStatus.OK);
        }
        return new ApiResponse<>(null, HttpStatus.NOT_FOUND);
    }

    @Override
    public ApiResponse<AttachmentDto> insertAttachment(AttachmentDto attachmentDto) {
        Attachment attachment = attachmentMapper.attachmentDtoToAttachment(attachmentDto);

        attachmentRepository.save(attachment);

        AttachmentDto attachmentDtoResponse = attachmentMapper.attachmentToAttachmentDto(attachment);
        return new ApiResponse<>(attachmentDtoResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PaginatedResponse<AttachmentDto>> getAllByUsername(String username, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Attachment> filteredAttachments = attachmentRepository.findByUploadedBy_Username(username, pageable);
        if (filteredAttachments.getNumberOfElements() == 0) {
            PaginatedResponse<AttachmentDto> paginatedResponse = new PaginatedResponse<>(filteredAttachments.getNumber(), filteredAttachments.getSize(), filteredAttachments.getNumberOfElements(),
                    new ArrayList<>(), filteredAttachments.getTotalElements(), filteredAttachments.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        List<AttachmentDto> filteredAttachmentsDtos = new ArrayList<>();

        filteredAttachments.getContent().forEach(attachment -> filteredAttachmentsDtos.add(attachmentMapper.attachmentToAttachmentDto(attachment)));

        PaginatedResponse<AttachmentDto> paginatedResponse = new PaginatedResponse<>(filteredAttachments.getNumber(), filteredAttachments.getSize(), filteredAttachments.getNumberOfElements(),
                filteredAttachmentsDtos, filteredAttachments.getTotalElements(), filteredAttachments.getTotalPages());
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<PaginatedResponse<AttachmentDto>> findAll(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Attachment> filteredAttachments = attachmentRepository.findAll(pageable);
        if (filteredAttachments.getNumberOfElements() == 0) {
            PaginatedResponse<AttachmentDto> paginatedResponse = new PaginatedResponse<>(filteredAttachments.getNumber(), filteredAttachments.getSize(), filteredAttachments.getNumberOfElements(),
                    new ArrayList<>(), filteredAttachments.getTotalElements(), filteredAttachments.getTotalPages());
            return new ApiResponse<>(paginatedResponse, HttpStatus.NOT_FOUND);
        }
        List<AttachmentDto> filteredAttachmentsDtos = new ArrayList<>();

        filteredAttachments.getContent().forEach(attachment -> filteredAttachmentsDtos.add(attachmentMapper.attachmentToAttachmentDto(attachment)));

        PaginatedResponse<AttachmentDto> paginatedResponse = new PaginatedResponse<>(filteredAttachments.getNumber(), filteredAttachments.getSize(), filteredAttachments.getNumberOfElements(),
                filteredAttachmentsDtos, filteredAttachments.getTotalElements(), filteredAttachments.getTotalPages());
        return new ApiResponse<>(paginatedResponse, HttpStatus.OK);
    }

    @Override
    public ApiResponse<AttachmentDto> deleteAttachment(Long id) {
        Optional<Attachment> attachment = attachmentRepository.findById(id);
        if (attachment.isPresent()) {
            attachmentRepository.delete(attachment.get());
            AttachmentDto attachmentDto = attachmentMapper.attachmentToAttachmentDto(attachment.get());
            return new ApiResponse<>(attachmentDto, HttpStatus.OK);
        } else {
            return new ApiResponse<>("Could not find any attachment with id " + id, null, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ApiResponse<Long> countAll() {
        Long attachmentNumber = attachmentRepository.count();
        return new ApiResponse<>(attachmentNumber, HttpStatus.OK);
    }
}
