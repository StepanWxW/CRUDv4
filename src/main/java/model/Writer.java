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
}
