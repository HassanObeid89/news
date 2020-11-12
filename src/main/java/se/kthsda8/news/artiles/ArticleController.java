package se.kthsda8.news.artiles;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/articles")
    public List<Article> getAll(@RequestParam(required = false) Long topicId) {

        if (topicId == null) {
            return articleService.getAll();
        }else{
            return articleService.getAllArticledByTopicId(topicId);
        }
    }

    @GetMapping("/articles/{id}")
    public Article getById(@PathVariable Long id) {
        return articleService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/articles")
    public Article create(@RequestBody Article newArticle) {

        return articleService.create(newArticle);
    }

    // method to delete the article
    @DeleteMapping("/articles/{id}")
    public void deleteArticle(@PathVariable Long id) {

        articleService.delete(id);
    }

    //method to update the article
    @PutMapping("/articles")
    public Article update( @RequestBody Article updatedArticle) {

        return articleService.update(updatedArticle);
    }
}
