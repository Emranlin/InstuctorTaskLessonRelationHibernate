package peaksoft.repository;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConnection;
import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

import java.util.ArrayList;
import java.util.List;



public class LessonRepositoryImpl implements LessonRepository{
    private final EntityManager entityManager= HibernateConnection.getEntityManager();
    @Override
    public String saveLesson(Long lessonId,Task task) {
        List<Task> taskList = new ArrayList<>();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, lessonId);
        taskList.addAll(lesson.getTasks());
        taskList.add(task);
        lesson.setTasks(taskList);
        entityManager.persist(task);
        entityManager.merge(lesson);
        entityManager.getTransaction().commit();
        entityManager.close();


        return "Successful created";
    }

    @Override
    public void updateLesson(Long LessonId, Lesson lesson) {
        entityManager.getTransaction().begin();
        Lesson lesson1 = entityManager.find(Lesson.class, LessonId);
        lesson1.setName(lesson.getName());
        lesson1.setVideoLink(lesson.getVideoLink());
        lesson1.setCourse(lesson.getCourse());
        lesson1.setTasks(lesson.getTasks());


    }

    @Override
    public Lesson getLessonById(Long LessonId) {
        entityManager.getTransaction().begin();
        Lesson id = entityManager.createQuery("select  l from Lesson l", Lesson.class)
                .setParameter("id", LessonId)
                .getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();

        return id;
    }

    @Override
    public void getLessonsByCourseId(Long courseId) {
       List<Task>tasks=new ArrayList<>();
        entityManager.getTransaction().begin();
        Lesson lesson = entityManager.find(Lesson.class, courseId);
        tasks.addAll(lesson.getTasks());
        entityManager.getTransaction().commit();
        entityManager.close();
        System.out.println(tasks);

    }
}
