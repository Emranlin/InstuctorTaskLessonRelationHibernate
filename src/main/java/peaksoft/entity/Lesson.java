package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "Lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="video_link")
    private String videoLink;
    @ManyToOne
    private Course course;
    @OneToMany
    private List<Task> tasks;

    public Lesson(String name, String videoLink) {
        this.name = name;
        this.videoLink = videoLink;
    }
}
