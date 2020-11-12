package se.kthsda8.news.topics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getAll(@RequestParam(required = false) Long articleId) {

        if (articleId == null) {
            return topicService.getAll();
        }else{
            return topicService.getAllByArticleId(articleId);
        }


    }

    @GetMapping("/topics/{id}")
    public Topic getById(@PathVariable Long id) {
        return topicService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/topics")
    public Topic create(@RequestBody Topic newTopic) {

        return topicService.create(newTopic);
    }

    @DeleteMapping("/topics/{id}")
    public void deleteArticle(@PathVariable Long id) {

        topicService.delete(id);
    }

    @PutMapping("/topics")
    public Topic update( @RequestBody Topic updatedTopic) {

        return topicService.update(updatedTopic);
    }
}
