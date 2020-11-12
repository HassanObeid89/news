package se.kthsda8.news.artiles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.kthsda8.news.artiles.Article;
import se.kthsda8.news.artiles.ArticleRepository;


import java.util.List;
import java.util.Optional;


@Service
public class ArticleService {
        @Autowired
        private ArticleRepository repository;

        public List<Article> getAll() {

            return repository.findAll();
        }

        public Optional<Article> getById(Long id) {
            return repository.findById(id);

        }

    public Article create(Article newArticle) {

            return repository.save(newArticle);
    }

    public void delete(Long id) {

            repository.deleteById(id);
    }


    public Article update(Article updatedArticle) {

            return repository.save(updatedArticle);
    }


    public List<Article> getAllArticledByTopicId(Long topicId) {
            return repository.findAllArticlesByTopics_id(topicId);
    }
}
