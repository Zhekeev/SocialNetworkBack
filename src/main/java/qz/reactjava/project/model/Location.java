package qz.reactjava.project.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "location")
@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String country;
}
