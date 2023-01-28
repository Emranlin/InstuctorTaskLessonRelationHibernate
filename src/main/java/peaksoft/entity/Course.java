package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.type.descriptor.java.LocalDateJavaType;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column(name = "course_name")
    private String courseName;
    private int duration;
    @Column(name = "create_at")

    private LocalDate createAt;
    @Column(name = "image_link")
    private  String imageLink;
    private String description;
    @ManyToMany()
    List<Instructor> instructors;
    @OneToMany(mappedBy = "course",cascade = {CascadeType.MERGE,
            CascadeType.PERSIST,
            CascadeType.REFRESH,CascadeType.DETACH})
    List<Lesson>lessons;

    public Course(String courseName, int duration, LocalDate createAt, String imageLink, String description) {
        this.courseName = courseName;
        this.duration = duration;
        this.createAt = createAt;
        this.imageLink = imageLink;
        this.description = description;

    }
}
