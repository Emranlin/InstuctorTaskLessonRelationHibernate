package peaksoft.service;

import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

public interface LessonService {
    String saveLesson(Long LessonId, Task task);
    void updateLesson(Long LessonId,Lesson lesson);
    Lesson getLessonById(Long LessonId);
    void getLessonsByCourseId(Long courseId);
}
