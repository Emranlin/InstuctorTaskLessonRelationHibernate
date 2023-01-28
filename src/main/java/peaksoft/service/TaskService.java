package peaksoft.service;

import peaksoft.entity.Task;

public interface TaskService {
    String saveTask(Task task);
    void updateTask(Long taskId,Task task);
    void getAllTaskByLessonId(Long taskId);
    String deleteTaskById(Long taskId);
}
