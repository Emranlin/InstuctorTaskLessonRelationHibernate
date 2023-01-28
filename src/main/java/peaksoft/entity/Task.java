package peaksoft.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name = "dead_line")
    private LocalDate deadLine;
    private String task;

    public Task(LocalDate deadLine,String name, String task) {
        this.deadLine = deadLine;
        this.name= name;
        this.task = task;
    }

    public Task(String name, int deadLine) {
    }
}
