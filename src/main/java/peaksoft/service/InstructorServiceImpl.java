package peaksoft.service;

import peaksoft.entity.Course;
import peaksoft.entity.Instructor;
import peaksoft.repository.InstructorRepository;
import peaksoft.repository.InstructorRepositoryImpl;

public class InstructorServiceImpl implements InstructorService{
    InstructorRepository instructorRepository=new InstructorRepositoryImpl();
    @Override
    public String saveInstructor(Instructor instructor) {
        return instructorRepository.saveInstructor(instructor);
    }

    @Override
    public void updateInstructor(Long InstructorId, Instructor instructor) {
            instructorRepository.updateInstructor(InstructorId,instructor);
    }

    @Override
    public void getInstructorById(Long InstructorId) {
          instructorRepository.getInstructorById(InstructorId);
    }

    @Override
    public String getInstructorsByCourseId(Long InstructorId) {
        return instructorRepository.getInstructorsByCourseId(InstructorId);
    }

    @Override
    public String deleteInstructorById(Long InstructorId) {
        return instructorRepository.deleteInstructorById(InstructorId);
    }

    @Override
    public void assignInstructorToCourse(Long instructorId, Course course) {
        instructorRepository.assignInstructorToCourse(instructorId,course);

    }
}
