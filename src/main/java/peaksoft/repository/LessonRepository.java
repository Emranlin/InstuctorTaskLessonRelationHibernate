package peaksoft.repository;

import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;

public interface LessonRepository {
   String saveLesson(Long LessonId, Task task);
   void updateLesson(Long LessonId,Lesson lesson);
   Lesson getLessonById(Long LessonId);
   void getLessonsByCourseId(Long courseId);
}
