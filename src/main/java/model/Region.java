package model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table (name = "regions", schema = "crud",catalog = "postgres")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Region {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long region_id;
    private String name;

    public Region(String name) {
        this.name = name;
    }
}
