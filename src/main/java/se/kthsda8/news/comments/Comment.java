package se.kthsda8.news.comments;

import se.kthsda8.news.artiles.Article;

import javax.persistence.*;


@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "TEXT")
    private String body;
    private String authorName;

    @ManyToOne
    private Article article;

    public Comment() {
    }

    public Comment(Long id, String body, String authorName, Article article) {
        this.id = id;
        this.body = body;
        this.authorName = authorName;
        this.article = article;
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

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
