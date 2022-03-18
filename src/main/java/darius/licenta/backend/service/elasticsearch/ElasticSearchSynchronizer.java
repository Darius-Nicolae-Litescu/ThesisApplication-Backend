package darius.licenta.backend.service.elasticsearch;

import darius.licenta.backend.domain.sql.*;
import darius.licenta.backend.mapper.elasticsearch.comment.ElasticSearchCommentMapper;
import darius.licenta.backend.mapper.elasticsearch.softwareapplication.ElasticSearchSoftwareApplicationMapper;
import darius.licenta.backend.mapper.elasticsearch.story.ElasticSearchStoryMapper;
import darius.licenta.backend.mapper.elasticsearch.storytask.ElasticSearchStoryTaskMapper;
import darius.licenta.backend.mapper.elasticsearch.user.ElasticSearchUserMapper;
import darius.licenta.backend.persistence.elasticsearch.*;
import darius.licenta.backend.persistence.jpa.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ElasticSearchSynchronizer {
    Logger logger = LoggerFactory.getLogger(ElasticSearchSynchronizer.class);

    private final CommentRepository commentRepository;
    private final CommentElasticSearchRepository commentElasticSearchRepository;
    private final SoftwareApplicationRepository softwareApplicationRepository;
    private final SoftwareApplicationElasticSearchRepository softwareApplicationElasticSearchRepository;
    private final StoryRepository storyRepository;
    private final StoryElasticSearchRepository storyElasticSearchRepository;
    private final StoryTaskElasticSearchRepository storyTaskElasticSearchRepository;
    private final StoryTaskRepository storyTaskRepository;
    private final UserElasticSearchRepository userElasticSearchRepository;
    private final UserRepository userRepository;
    private final ElasticSearchUserMapper elasticSearchUserMapper;
    private final ElasticSearchStoryMapper elasticSearchStoryMapper;
    private final ElasticSearchStoryTaskMapper elasticSearchStoryTaskMapper;
    private final ElasticSearchCommentMapper elasticSearchCommentMapper;
    private final ElasticSearchSoftwareApplicationMapper elasticSearchSoftwareApplicationMapper;

    @Autowired
    public ElasticSearchSynchronizer(CommentRepository commentRepository, CommentElasticSearchRepository commentElasticSearchRepository, SoftwareApplicationRepository softwareApplicationRepository, SoftwareApplicationElasticSearchRepository softwareApplicationElasticSearchRepository, StoryRepository storyRepository, StoryElasticSearchRepository storyElasticSearchRepository, StoryTaskElasticSearchRepository storyTaskElasticSearchRepository, StoryTaskRepository storyTaskRepository, UserElasticSearchRepository userElasticSearchRepository, UserRepository userRepository, ElasticSearchUserMapper elasticSearchUserMapper, ElasticSearchStoryMapper elasticSearchStoryMapper, ElasticSearchStoryTaskMapper elasticSearchStoryTaskMapper, ElasticSearchCommentMapper elasticSearchCommentMapper, ElasticSearchSoftwareApplicationMapper elasticSearchSoftwareApplicationMapper) {
        this.commentRepository = commentRepository;
        this.commentElasticSearchRepository = commentElasticSearchRepository;
        this.softwareApplicationRepository = softwareApplicationRepository;
        this.softwareApplicationElasticSearchRepository = softwareApplicationElasticSearchRepository;
        this.storyRepository = storyRepository;
        this.storyElasticSearchRepository = storyElasticSearchRepository;
        this.storyTaskElasticSearchRepository = storyTaskElasticSearchRepository;
        this.storyTaskRepository = storyTaskRepository;
        this.userElasticSearchRepository = userElasticSearchRepository;
        this.userRepository = userRepository;
        this.elasticSearchUserMapper = elasticSearchUserMapper;
        this.elasticSearchStoryMapper = elasticSearchStoryMapper;
        this.elasticSearchStoryTaskMapper = elasticSearchStoryTaskMapper;
        this.elasticSearchCommentMapper = elasticSearchCommentMapper;
        this.elasticSearchSoftwareApplicationMapper = elasticSearchSoftwareApplicationMapper;
    }


    @Scheduled(cron = "0 */1 * * * *")

    @Transactional
    public void sync() {
        logger.info("Syncing start: {}", LocalDateTime.now());
        logger.info("Syncing users: {}", LocalDateTime.now());
        syncUsers();
        logger.info("Syncing software applications: {}", LocalDateTime.now());
        syncSoftwareApplication();
        logger.info("Syncing story: {}", LocalDateTime.now());
        syncStories();
        logger.info("Syncing story tasks: {}", LocalDateTime.now());
        syncStoryTasks();
        logger.info("Syncing comments: {}", LocalDateTime.now());
        syncComments();
        logger.info("Syncing finished:  {}", LocalDateTime.now());
    }

    private void syncStories() {
        Specification<Story> storySpecification = (root, criteriaQuery, criteriaBuilder) ->
                getModificationDatePredicate(criteriaBuilder, root);
        List<Story> stories;
        if (storyElasticSearchRepository.count() == 0) {
            stories = storyRepository.findAll();
        } else {
            stories = storyRepository.findAll(storySpecification);
        }
        for (Story story : stories) {
            logger.info("Syncing Story: {}", story.getId());
            storyElasticSearchRepository.save(elasticSearchStoryMapper.storyToElasticSearchStoryDto(story));
        }
    }

    private void syncStoryTasks() {
        Specification<StoryTask> storyTaskSpecification = (root, criteriaQuery, criteriaBuilder) ->
                getModificationDatePredicate(criteriaBuilder, root);
        List<StoryTask> storyTaskList;
        if (storyTaskRepository.count() == 0) {
            storyTaskList = storyTaskRepository.findAll();
        } else {
            storyTaskList = storyTaskRepository.findAll(storyTaskSpecification);
        }
        for (StoryTask storyTask : storyTaskList) {
            logger.info("Syncing Story Task: {}", storyTask.getId());
            storyTaskElasticSearchRepository.save(elasticSearchStoryTaskMapper.storyTaskToElasticSearchStoryTaskDto(storyTask));
        }
    }

    private void syncComments() {
        Specification<Comment> commentSpecification = (root, criteriaQuery, criteriaBuilder) ->
                getModificationDatePredicate(criteriaBuilder, root);
        List<Comment> commentList;
        if (commentRepository.count() == 0) {
            commentList = commentRepository.findAll();
        } else {
            commentList = commentRepository.findAll(commentSpecification);
        }
        for (Comment comment : commentList) {
            logger.info("Syncing Comment: {}", comment.getId());
            commentElasticSearchRepository.save(elasticSearchCommentMapper.commentToElasticSearchCommentDto(comment));
        }
    }

    private void syncSoftwareApplication() {
        Specification<SoftwareApplication> softwareApplicationSpecification = (root, criteriaQuery, criteriaBuilder) ->
                getModificationDatePredicate(criteriaBuilder, root);
        List<SoftwareApplication> softwareApplicationList;
        if (softwareApplicationRepository.count() == 0) {
            softwareApplicationList = softwareApplicationRepository.findAll();
        } else {
            softwareApplicationList = softwareApplicationRepository.findAll(softwareApplicationSpecification);
        }
        for (SoftwareApplication softwareApplication : softwareApplicationList) {
            logger.info("Syncing Software Application: {}", softwareApplication.getId());
            softwareApplicationElasticSearchRepository.save(elasticSearchSoftwareApplicationMapper.softwareApplicationToElasticSearchSoftwareApplicationDto(softwareApplication));
        }
    }

    private void syncUsers() {
        Specification<User> userSpecification = (root, criteriaQuery, criteriaBuilder) ->
                getModificationDatePredicate(criteriaBuilder, root);
        List<User> userList;
        if (userElasticSearchRepository.count() == 0) {
            userList = userRepository.findAll();
        } else {
            userList = userRepository.findAll(userSpecification);
        }
        for (User user : userList) {
            logger.info("Syncing User: {}", user.getId());
            userElasticSearchRepository.save(elasticSearchUserMapper.userToElasticSearchUserDto(user));
        }
    }

    private static Predicate getModificationDatePredicate(CriteriaBuilder cb, Root<?> root) {
        Expression<Timestamp> currentTime;
        currentTime = cb.currentTimestamp();
        Expression<Timestamp> currentTimeMinus = cb.literal(
                new Timestamp(System.currentTimeMillis() -
                        (ElasticSearchConstants.MILLISECONDS_INTERVAL)));
        return cb.between(root.<Date>get(ElasticSearchConstants.MODIFICATION_DATE),
                currentTimeMinus,
                currentTime
        );
    }

}