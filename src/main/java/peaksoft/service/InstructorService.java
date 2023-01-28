package peaksoft.service;

import peaksoft.entity.Course;
import peaksoft.entity.Instructor;

public interface InstructorService {
    String saveInstructor(Instructor instructor);
    void updateInstructor(Long InstructorId,Instructor instructor);
    void  getInstructorById(Long InstructorId);
    String getInstructorsByCourseId(Long InstructorId);
    String deleteInstructorById(Long InstructorId);
    void assignInstructorToCourse(Long instructorId, Course course);
}
