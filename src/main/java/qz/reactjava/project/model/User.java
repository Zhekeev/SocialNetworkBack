package qz.reactjava.project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "users")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String status;
    @OneToOne
    private Location location;
    private Boolean followed;
    private String photoUrl;
}
