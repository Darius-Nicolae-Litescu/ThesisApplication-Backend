package darius.licenta.backend.controller;

import darius.licenta.backend.domain.sql.Attachment;
import darius.licenta.backend.dto.normal.attachment.AttachmentDto;
import darius.licenta.backend.service.attachment.AttachmentService;
import darius.licenta.backend.service.attachment.CommentAttachmentOperationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/attachment")
@CrossOrigin(origins = "http://localhost:3000")
public class AttachmentController {

    private final CommentAttachmentOperationsService commentAttachmentOperationsService;

    @Autowired
    public AttachmentController(CommentAttachmentOperationsService commentAttachmentOperationsService) {
        this.commentAttachmentOperationsService = commentAttachmentOperationsService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        Attachment attachment = commentAttachmentOperationsService.getAttachmentById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + attachment.getName())
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .body(attachment.getContent());
    }

}