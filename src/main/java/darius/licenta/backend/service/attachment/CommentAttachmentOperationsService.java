package darius.licenta.backend.service.attachment;

import darius.licenta.backend.domain.sql.*;
import org.springframework.web.multipart.MultipartFile;

public interface CommentAttachmentOperationsService {

    Attachment insertCommentAttachment(MultipartFile attachment, String uploadedByUsername, User user, Comment comment, StoryTask storyTask);

    Attachment insertCommentAttachment(MultipartFile attachment, String uploadedByUsername, User user, Comment comment, Story story);

    Attachment getAttachmentById(Long id);

    Attachment deleteCommentAttachment(Long id);

}
