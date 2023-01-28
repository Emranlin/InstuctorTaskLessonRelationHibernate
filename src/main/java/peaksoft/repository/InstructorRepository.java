package peaksoft.repository;

import peaksoft.entity.Course;
import peaksoft.entity.Instructor;

public interface InstructorRepository {
    String saveInstructor(Instructor instructor);
    void updateInstructor(Long InstructorId,Instructor instructor);
    void  getInstructorById(Long InstructorId);
   String getInstructorsByCourseId(Long InstructorId);
   String deleteInstructorById(Long courseId);
   void assignInstructorToCourse(Long instructorId,Long courseId);


}
