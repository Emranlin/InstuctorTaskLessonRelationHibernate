package peaksoft.service;

import peaksoft.entity.Course;
import peaksoft.repository.CourseRepository;
import peaksoft.repository.CourseRepositoryImpl;

import java.util.List;

public class CourseServiceImpl implements CourseService{
    CourseRepository courseRepository=new CourseRepositoryImpl();
    @Override
    public String saveCourse(Course course) {
        return courseRepository.saveCourse(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.getCourseById(courseId);
    }

    @Override
    public List<Course> getAllCourse() {
        return courseRepository.getAllCourse();
    }

    @Override
    public String deleteById(Long courseId) {
        return courseRepository.deleteById(courseId);
    }

    @Override
    public void updateCourse(Long courseId, Course course) {
        courseRepository.updateCourse(courseId,course);
    }

    @Override
    public Course getByCourseName(String name) {
        return courseRepository.getByCourseName(name);
    }
}
