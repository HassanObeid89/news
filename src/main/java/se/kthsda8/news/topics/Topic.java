package se.kthsda8.news.topics;

import se.kthsda8.news.artiles.Article;

import javax.persistence.*;
import java.util.List;

@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "topics")
    private List<Article> articles;

    public Topic() {
    }

    public Topic(Long id, String name) {
        this.id = id;
        this.name = name;

    }

    public Long getTopic_id() {
        return id;
    }

    public void setTopic_id(Long topic_id) {
        this.id = topic_id;
    }

    public String getTopic_name() {
        return name;
    }

    public void setTopic_name(String topic_name) {
        this.name = topic_name;
    }


}
