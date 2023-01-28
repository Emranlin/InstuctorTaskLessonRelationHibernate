package peaksoft.service;

import peaksoft.entity.Course;
import peaksoft.entity.Lesson;
import peaksoft.entity.Task;
import peaksoft.repository.LessonRepository;
import peaksoft.repository.LessonRepositoryImpl;

public class LessonServiceImpl implements LessonService{
    LessonRepository lessonRepository=new LessonRepositoryImpl();
    @Override
    public String saveLesson(Long LessonId, Task task) {
        return lessonRepository.saveLesson(LessonId,task);
    }

    @Override
    public void updateLesson(Long LessonId, Lesson lesson) {
        lessonRepository.updateLesson(LessonId,lesson);

    }

    @Override
    public Lesson getLessonById(Long LessonId) {
        return lessonRepository.getLessonById(LessonId);
    }

    @Override
    public void getLessonsByCourseId(Long courseId) {
        lessonRepository.getLessonsByCourseId(courseId);

    }
}
