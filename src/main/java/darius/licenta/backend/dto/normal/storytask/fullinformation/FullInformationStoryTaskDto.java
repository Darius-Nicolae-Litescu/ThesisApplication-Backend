package darius.licenta.backend.dto.normal.storytask.fullinformation;

import com.fasterxml.jackson.annotation.JsonIgnore;
import darius.licenta.backend.dto.normal.attachment.AttachmentResponseDto;
import darius.licenta.backend.dto.normal.story.response.fulldetails.AttachmentDto;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Blob;
import java.time.LocalDateTime;
import java.util.*;

@Data
public class FullInformationStoryTaskDto implements Serializable {
    private final long id;
    private final String title;
    private final String description;
    private final int storyPoints;
    private final long createdById;
    private final String createdByUsername;
    private final String createdByEmail;
    private final LocalDateTime createdAt;
    private final long assignedToId;
    private final String assignedToUsername;
    private final String assignedToEmail;
    private final String status;
    private final LocalDateTime finishedAt;
    private List<StoryCommentDto> storyComments;
    private final Set<AttachmentDto> commentAttachments;
    private final long storyId;
    private final String storyDescription;

    @Data
    public static class StoryCommentDto implements Serializable {
        private final Long id;
        private final String content;
        private final PostedByUserDto postedBy;
        private final LocalDateTime postedAt;
        private final Date modificationDate;
        @JsonIgnore
        private final Set<AttachmentDto> commentAttachments;
        private List<AttachmentResponseDto> attachmentResponseDto;

    }

    @Data
    public static class AttachmentDto implements Serializable {
        private final Long id;
        private final LocalDateTime postedAt;
    }
}
