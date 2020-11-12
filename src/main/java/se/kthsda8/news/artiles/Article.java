package se.kthsda8.news.artiles;

import se.kthsda8.news.topics.Topic;

import javax.persistence.*;
import java.util.List;


@Entity

public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String body;

    private String authorName;

    private String title;

    @ManyToMany()
    private List<Topic> topics;


    public Article() {
    }

    public Article(Long id, String body, String authorName, String title) {
        this.id = id;
        this.body = body;
        this.authorName = authorName;
        this.title = title;


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }
}
