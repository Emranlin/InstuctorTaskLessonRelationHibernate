package peaksoft.service;

import peaksoft.entity.Task;
import peaksoft.repository.TaskRepository;
import peaksoft.repository.TaskRepositoryImpl;

public class TaskServiceImpl implements TaskService{
    TaskRepository taskRepository=new TaskRepositoryImpl();
    @Override
    public String saveTask(Task task) {
        return taskRepository.saveTask(task);
    }

    @Override
    public void updateTask(Long taskId, Task task) {
        taskRepository.updateTask(taskId,task);

    }

    @Override
    public void getAllTaskByLessonId(Long taskId) {
         taskRepository.getAllTaskByLessonId(taskId);
    }

    @Override
    public String deleteTaskById(Long taskId) {
        return taskRepository.deleteTaskById(taskId);

    }
}
