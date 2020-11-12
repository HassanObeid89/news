package se.kthsda8.news.artiles;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {


    List<Article> findAllArticlesByTopics_id(Long topicId);

}
