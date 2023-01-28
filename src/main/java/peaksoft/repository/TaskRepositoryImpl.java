package peaksoft.repository;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConnection;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepositoryImpl implements TaskRepository {
    private final EntityManager entityManager = HibernateConnection.getEntityManager();

    @Override
    public String saveTask(Task task) {
        entityManager.getTransaction().begin();
        entityManager.persist(task);
        entityManager.getTransaction().commit();
        entityManager.close();

        return "Successful saved";
    }

    @Override
    public void updateTask(Long taskId, Task task) {
        entityManager.getTransaction().begin();
        Task task1 = entityManager.find(Task.class, taskId);
        task1.setDeadLine(task.getDeadLine());
        task1.setTask(task.getTask());
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(task1);

    }

    @Override
    public void getAllTaskByLessonId(Long lessonId) {
        List<Task> tasks = new ArrayList<>();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        tasks.addAll(lesson.getTasks());
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(tasks);


    }

    @Override
    public String deleteTaskById(Long taskId) {
        entityManager.getTransaction().begin();
        Task task = entityManager.find(Task.class, taskId);
        List<Lesson> lessons = entityManager.createQuery("select l from Lesson l", Lesson.class).getResultList();
        Lesson lesson = null;
        for (Lesson lesson1 : lessons) {
            for (Task lessonTask : lesson1.getTasks()) {
                if (lessonTask.getId().equals(task.getId())) {
                    lesson = lesson1;
                    System.out.println(lessonTask);
                }
            }
        }
        lesson.getTasks().remove(task);
        entityManager.remove(task);
        entityManager.getTransaction().commit();
        entityManager.close();
        return task.getName() + "is  successfully deleted";
    }
}