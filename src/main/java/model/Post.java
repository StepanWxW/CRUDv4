package model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;

@Entity
@Table (name = "posts", schema = "crud",catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Post  {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long post_id;
    private String post;

    private Timestamp created;

    private Timestamp updated;

    @Column(name = "poststatus")
    @Enumerated(EnumType.STRING)
    private PostStatus postStatus;

    public Post(String post, PostStatus postStatus) {
        this.post = post;
        this.postStatus = postStatus;
    }

    public Post(Long post_id, String post, PostStatus postStatus) {
        this.post_id = post_id;
        this.post = post;
        this.postStatus = postStatus;
    }
}
