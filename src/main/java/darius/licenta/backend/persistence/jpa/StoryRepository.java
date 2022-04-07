package darius.licenta.backend.persistence.jpa;

import darius.licenta.backend.domain.sql.Story;
import darius.licenta.backend.service.statistics.StoryCommentsAggregationResult;
import darius.licenta.backend.service.statistics.StoryStatusAggregationResult;
import darius.licenta.backend.service.statistics.StoryTaskUserCommentsAggregationResult;
import darius.licenta.backend.service.statistics.StoryUserCommentsAggregationResult;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface StoryRepository extends JpaRepository<Story, Long>, JpaSpecificationExecutor<Story> {
    List<Story> findByCreatedBy_IdOrderByModificationDateAsc(Long id, Pageable pageable);

    Page<Story> findByPriority_Id(long id, Pageable pageable);

    Page<Story> findByCategories_Id(long id, Pageable pageable);

    Page<Story> findByDescriptionLike(String description, Pageable pageable);

    Page<Story> findBySoftwareApplication_Id(long id, Pageable pageable);

    @Query("SELECT new darius.licenta.backend.service.statistics.StoryStatusAggregationResult(COUNT(DISTINCT s.id)," +
            " COUNT(CASE WHEN st.finishedAt IS NOT NULL THEN 1 END)) " +
            "FROM Story s LEFT JOIN StoryTask st on s.id = st.story.id AND DATE(st.createdAt) > :sqlDate")
    StoryStatusAggregationResult countFinishedStoriesAfterDate(@Param("sqlDate") java.sql.Date sqlDate);

    @Query("SELECT new darius.licenta.backend.service.statistics.StoryUserCommentsAggregationResult(s.id, COUNT(s.id), u.username)" +
            " FROM Story as s INNER JOIN Comment as c on s.id = c.story.id " +
            "INNER JOIN User as u on c.postedBy.id = u.id GROUP BY u.username, u.id, s.id")
    List<StoryUserCommentsAggregationResult> countStoryUserComments();

    @Query("SELECT new darius.licenta.backend.service.statistics.StoryTaskUserCommentsAggregationResult(st.id, COUNT(st.id), u.username)" +
            " FROM StoryTask as st INNER JOIN Comment as c on st.id = c.storyTask.id " +
            "INNER JOIN User as u on c.postedBy.id = u.id GROUP BY u.username, u.id, st.id")
    List<StoryTaskUserCommentsAggregationResult> countStoryTaskUserComments();

    /*
    SELECT s.id, COUNT(s.id) FROM story as s INNER JOIN comment as c on s.id = c.story_id INNER JOIN user as u on c.posted_by_id = u.id  GROUP BY s.id

     */
    @Query("SELECT new darius.licenta.backend.service.statistics.StoryCommentsAggregationResult(s.id, COUNT(s.id)) " +
            "FROM Story as s INNER JOIN Comment as c on s.id = c.story.id GROUP BY s.id")
    List<StoryCommentsAggregationResult> countStoryComments();
}