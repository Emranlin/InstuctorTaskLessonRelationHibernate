package peaksoft.repository;

import jakarta.persistence.EntityManager;
import peaksoft.config.HibernateConnection;
import peaksoft.entity.Course;
import peaksoft.entity.Instructor;

import java.util.ArrayList;
import java.util.List;

public class InstructorRepositoryImpl implements InstructorRepository{
    private  final EntityManager entityManager= HibernateConnection.getEntityManager();
    @Override
    public String saveInstructor(Instructor instructor) {
        entityManager.getTransaction().begin();
        entityManager.persist(instructor);
        entityManager.getTransaction().commit();
        entityManager.close();

        return instructor.getFirstName()+" is successful find";
    }

    @Override
    public void updateInstructor(Long InstructorId, Instructor instructor) {
        entityManager.getTransaction().begin();
        Instructor instructor1 = entityManager.find(Instructor.class, InstructorId);
        instructor1.setFirstName(instructor.getFirstName());
        instructor1.setLastName(instructor.getLastName());
        instructor1.setEmail(instructor.getEmail());
        instructor1.setPhoneNumber(instructor.getPhoneNumber());
        instructor1.setCourses(instructor.getCourses());
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public void getInstructorById(Long InstructorId) {
        entityManager.getTransaction().begin();
        entityManager.find(Instructor.class,InstructorId);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Override
    public String getInstructorsByCourseId(Long courseId) {
        entityManager.getTransaction().begin();
         entityManager.createNativeQuery("select i from Instructors i join Course c on courrse.id=instructor.id where c.id:courseId")
                .setParameter("id", courseId).getSingleResult();
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successful find";
    }

    @Override
    public String deleteInstructorById(Long InstructorId) {
        entityManager.getTransaction().begin();
        Instructor singleResult = entityManager.createQuery("select i from Instructor i ", Instructor.class)
                .setParameter("id", InstructorId).getSingleResult();
        entityManager.remove(singleResult);
        entityManager.getTransaction().commit();
        entityManager.close();
        return "Successful deleted";
    }

    @Override
    public void assignInstructorToCourse(Long instructorId,Long courseId) {
        entityManager.getTransaction().begin();
        Course course = entityManager.find(Course.class, courseId);
        Instructor instructor = entityManager.find(Instructor.class, instructorId);
        List<Course> courses = new ArrayList<>(instructor.getCourses());
        List<Instructor> instructors = new ArrayList<>(course.getInstructors());
        instructors.add(instructor);
        courses.add(course);
        instructor.setCourses(courses);
        course.setInstructors(instructors);
        entityManager.merge(course);
        entityManager.getTransaction().commit();
        entityManager.close();

    }
}
