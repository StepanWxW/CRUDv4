package model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table (name = "writers", schema = "crud",catalog = "postgres")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Writer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long writer_id;
    private String firstName;
    private String lastName;
    @OneToMany
    private List<Post> post;
    @OneToOne
    private Region region;

    public Writer(String firstName, String lastName, List<Post> post, Region region) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.post = post;
        this.region = region;
    }
}
