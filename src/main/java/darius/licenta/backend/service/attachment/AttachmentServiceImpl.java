package darius.licenta.backend.service.attachment;

import darius.licenta.backend.domain.sql.*;
import darius.licenta.backend.dto.normal.attachment.AttachmentDto;
import darius.licenta.backend.exception.UserNotFoundException;
import darius.licenta.backend.mapper.normal.attachment.AttachmentMapper;
import darius.licenta.backend.payload.response.ApiResponse;
import darius.licenta.backend.payload.response.PaginatedResponse;
import darius.licenta.backend.persistence.jpa.AttachmentRepository;
import darius.licenta.backend.persistence.jpa.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class AttachmentServiceImpl implements AttachmentService, CommentAttachmentOperationsService {

    public static final String USER_COULD_NOT_BE_FOUND = " user could not be found";

    private final AttachmentRepository attachmentRepository;
    private final UserRepository userRepository;
    private final AttachmentMapper attachmentMapper;

    @Autowired
    public AttachmentServiceImpl(AttachmentRepository attachmentRepository, UserRepository userRepository, AttachmentMapper attachmentMapper) {
        this.attachmentRepository = attachmentRepository;
        this.userRepository = userRepository;
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
    public ApiResponse<AttachmentDto> insertAttachment(MultipartFile multipartFile, String uploadedByUsername) {
        Attachment attachment = null;
        try {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            Optional<User> user = userRepository.findByUsername(uploadedByUsername);
            if (user.isPresent()) {
                attachment = new Attachment(fileName, multipartFile.getContentType(), multipartFile.getBytes(), user.get());
                attachmentRepository.save(attachment);
            } else {
                throw new UserNotFoundException(uploadedByUsername + USER_COULD_NOT_BE_FOUND);
            }
        } catch (Exception exception) {
            return new ApiResponse<>("Exception: " + exception.getMessage() + " file could not be uploaded", null, HttpStatus.BAD_REQUEST);
        }
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

    @Override
    public Attachment insertCommentAttachment(MultipartFile multipartFile, String uploadedByUsername, User user, Comment comment, StoryTask storyTask) {
        Attachment attachment = null;
        try {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            if (user != null) {
                attachment = new Attachment(fileName, multipartFile.getContentType(), multipartFile.getBytes(), user);
                attachment.setStoryTask(storyTask);
                attachment.setComment(comment);
                attachment = attachmentRepository.save(attachment);
            } else {
                throw new UserNotFoundException(uploadedByUsername + USER_COULD_NOT_BE_FOUND);
            }
        } catch (Exception exception) {
            return null;
        }
        return attachment;
    }

    @Override
    public Attachment insertCommentAttachment(MultipartFile multipartFile, String uploadedByUsername, User user, Comment comment, Story story) {
        Attachment attachment = null;
        try {
            String fileName = StringUtils.cleanPath(Objects.requireNonNull(multipartFile.getOriginalFilename()));
            if (user != null) {
                attachment = new Attachment(fileName, multipartFile.getContentType(), multipartFile.getBytes(), user);
                attachment.setStory(story);
                attachment.setComment(comment);
                attachment = attachmentRepository.save(attachment);
            } else {
                throw new UserNotFoundException(uploadedByUsername + USER_COULD_NOT_BE_FOUND);
            }
        } catch (Exception exception) {
            return null;
        }
        return attachment;
    }

    @Override
    public Attachment getAttachmentById(Long id) {
        Optional<Attachment> attachment = attachmentRepository.findById(id);
        return attachment.orElse(null);
    }

    @Override
    public Attachment deleteCommentAttachment(Long id) {
        Optional<Attachment> attachment = attachmentRepository.findById(id);
        if (attachment.isPresent()) {
            attachmentRepository.delete(attachment.get());
            return attachment.get();
        } else {
            return null;
        }
    }
}
