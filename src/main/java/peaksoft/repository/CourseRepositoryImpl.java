package peaksoft.repository;

import jakarta.persistence.EntityManager;
import org.hibernate.HibernateException;
import peaksoft.config.HibernateConnection;
import peaksoft.entity.Course;

import java.util.List;

public class CourseRepositoryImpl implements CourseRepository{
    private final EntityManager entityManager=HibernateConnection.getEntityManager();
    @Override
    public String saveCourse(Course course) {
        entityManager.getTransaction().begin();
        entityManager.persist(course);
        entityManager.getTransaction().commit();
        entityManager.close();

        return course.getCourseName()+" is successful saved";
    }

    @Override
    public Course getCourseById(Long courseId) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        entityManager.getTransaction().commit();
        entityManager.close();

        return course;
    }

    @Override
    public List<Course> getAllCourse() {
        entityManager.getTransaction().begin();
        List<Course> courseList = entityManager.createQuery("select c from Course c order by duration", Course.class).getResultList();
        entityManager.getTransaction().commit();
        entityManager.close();
        return courseList;
    }

    @Override
    public String deleteById(Long courseId) {
            Course course = entityManager.find(Course.class, courseId);
            course.getLessons().stream().forEach(c -> entityManager.remove(c));
            course.setLessons(null);
            course.getInstructors().stream().forEach(c -> c.setCourses(null));
            course.setInstructors(null);
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            entityManager.close();
            return " successfully deleted...";

    }
    @Override
    public void updateCourse(Long courseId, Course course) {
        entityManager.getTransaction().begin();
        Course course1 = entityManager.find(Course.class, courseId);
        course1.setCourseName(course.getCourseName());
        course1.setDuration(course.getDuration());
        course1.setCreateAt(course.getCreateAt());
        course1.setImageLink(course.getImageLink());
        course1.setDescription(course.getDescription());
        course1.setInstructors(course.getInstructors());
        entityManager.getTransaction().commit();
        entityManager.close();


    }

    @Override
    public Course getByCourseName(String name) {
        entityManager.getTransaction().begin();
        Object courseName = entityManager.createNativeQuery("select c from Course c where c.name=:name")
                .setParameter("courseName", name)
                .getSingleResult();

        return (Course) courseName;
    }
}
