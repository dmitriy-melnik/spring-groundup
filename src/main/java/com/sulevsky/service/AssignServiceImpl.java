package com.sulevsky.service;

import com.sulevsky.model.Task;
import com.sulevsky.model.Worker;
import org.springframework.beans.factory.annotation.Autowired;

public class AssignServiceImpl implements AssignService {

    @Autowired
    private TaskService taskService;

    public AssignServiceImpl(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public Task assignTask(Worker worker, Task task) {
        task.setAssignee(worker);
        return taskService.saveTask(task);
    }
}
