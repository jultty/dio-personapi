package one.digitalinnovation.refsapi.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.ISBN;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column
    private String subtitle;

    @Column(nullable = false)
    private String authorship;

    @Column
    private String organizer;

    @Column
    private String url;

    @Column(nullable = false)
    private String language;

    @Column
    private int volume;

    @Column
    private String edition;

    @Column
    private String location;

    @Column
    private LocalDate date;

    @Column
    @ISBN
    private String isbn;

    @Column
    private int pages;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Quote> quotes = new ArrayList<>();

}
