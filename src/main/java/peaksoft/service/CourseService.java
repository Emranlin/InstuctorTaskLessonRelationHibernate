package peaksoft.service;

import peaksoft.entity.Course;

import java.util.List;

public interface CourseService {
    String saveCourse(Course course);
    Course getCourseById(Long courseId);
    List<Course> getAllCourse();
    String deleteById(Long courseId);
    void updateCourse(Long courseId,Course course);
    Course getByCourseName(String name);
}
