package se.kthsda8.news.comments;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;


@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comments")
    public List<Comment> getAll(@RequestParam(required = false) Long articleId) {

        if (articleId == null) {
            return commentService.getAll();
        }else{
            return commentService.getAllByArticleId(articleId);
        }


    }

    @GetMapping("/comments/{id}")
    public Comment getById(@PathVariable Long id) {
        return commentService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/comments")
    public Comment create(@RequestBody Comment newComment) {

        return commentService.create(newComment);
    }

    @DeleteMapping("/comments/{id}")
    public void deleteArticle(@PathVariable Long id) {
        commentService.delete(id);
    }


    @PutMapping("/comments")
    public Comment update( @RequestBody Comment updatedComment) {
        return commentService.update(updatedComment);
    }
}
