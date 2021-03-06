package se.kthsda8.news.topics;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {


    List<Topic> findAllTopicsByArticles_id(Long articleId);

}
