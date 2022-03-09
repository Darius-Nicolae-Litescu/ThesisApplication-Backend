package darius.licenta.backend.service.attachment;

import darius.licenta.backend.domain.sql.Attachment;
import darius.licenta.backend.domain.sql.Story;
import darius.licenta.backend.domain.sql.StoryTask;
import darius.licenta.backend.domain.sql.User;
import darius.licenta.backend.dto.normal.attachment.AttachmentDto;
import darius.licenta.backend.payload.response.ApiResponse;
import org.springframework.web.multipart.MultipartFile;

public interface CommentAttachmentOperationsService {

    Attachment insertCommentAttachment(MultipartFile attachment, String uploadedByUsername, User user, StoryTask storyTask);

    Attachment insertCommentAttachment(MultipartFile attachment, String uploadedByUsername, User user, Story story);

    Attachment getAttachmentById(Long id);

    Attachment deleteCommentAttachment(Long id);

}
