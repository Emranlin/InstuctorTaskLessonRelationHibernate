package peaksoft.repository;

import peaksoft.entity.Task;

public interface TaskRepository {
   String saveTask(Task task);
    void updateTask(Long taskId,Task task);
    void getAllTaskByLessonId(Long taskId);
   String deleteTaskById(Long lessonId);


}
