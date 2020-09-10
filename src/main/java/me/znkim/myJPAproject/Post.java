package me.znkim.myJPAproject;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;

    private String title;

    @OneToMany(mappedBy = "post", cascade = CascadeType.PERSIST)
    private Set<Comment> commnets = new HashSet<>();

    /* Add Comment*/
    public  void addComment(Comment comment) {
        this.getCommnets().add(comment);
        comment.setPost(this);
    }

    /* Remove Comment*/
    public  void removeComment(Comment comment) {
        this.getCommnets().remove(comment);
        comment.setComment(null);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Comment> getCommnets() {
        return commnets;
    }

    public void setCommnets(Set<Comment> commnets) {
        this.commnets = commnets;
    }
}
