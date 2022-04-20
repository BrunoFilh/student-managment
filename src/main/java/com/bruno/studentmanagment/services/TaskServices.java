package com.bruno.studentmanagment.services;

import com.bruno.studentmanagment.models.Task;

import java.util.Collection;

public interface TaskServices {

    Task createNewtask(Task task);
    Collection<Task> fetchAllOpenedTasks();
    Collection<Task> fetchAllClosedTasks();
    Task getTaskById(Long id);
    void closeTaskById(Long id);


}
