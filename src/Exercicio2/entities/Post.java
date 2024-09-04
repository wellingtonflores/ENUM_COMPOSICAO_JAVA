package Exercicio2.entities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Post {

    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private LocalDateTime moment;
    private String title;
    private String content;
    private Integer likes;

    private final List<Comment> comments = new ArrayList<>();

    public Post() {

    }

    public Post(LocalDateTime moment, Integer likes, String content, String title) {
        this.moment = moment;
        this.likes = likes;
        this.content = content;
        this.title = title;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(Comment comment) {
        comments.remove(comment);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(title).append(System.lineSeparator());
        sb.append(likes).append(" Likes - ");
        sb.append(dtf.format(moment)).append(System.lineSeparator());
        sb.append(content).append(System.lineSeparator());
        sb.append("Comments:").append(System.lineSeparator());
        for (Comment c : comments) {
            sb.append(c.getText()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
