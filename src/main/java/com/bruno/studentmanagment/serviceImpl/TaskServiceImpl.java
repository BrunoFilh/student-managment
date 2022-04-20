package com.bruno.studentmanagment.serviceImpl;

import com.bruno.studentmanagment.models.Task;
import com.bruno.studentmanagment.repositories.TaskRepo;
import com.bruno.studentmanagment.services.TaskServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.stream.Collectors;

import static com.bruno.studentmanagment.enumeration.TaskStatus.CLOSED;
import static com.bruno.studentmanagment.enumeration.TaskStatus.OPENED;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskServices {

    private final TaskRepo repository;

    @Override
    public Task createNewtask(Task task) {
        return repository.save(task);
    }

    @Override
    public Collection<Task> fetchAllOpenedTasks() {
        return repository.findAll().stream().filter(s -> s.getStatus() == OPENED)
                .collect(Collectors.toList());
    }

    @Override
    public Collection<Task> fetchAllClosedTasks() {
        return repository.findAll().stream().filter(s -> s.getStatus() == CLOSED)
                .collect(Collectors.toList());
    }

    @Override
    public Task getTaskById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    @Override
    public void closeTaskById(Long id) {
        repository.findById(id).ifPresentOrElse(
                s -> {
                    s.setClosedTime(LocalDate.now());
                    s.setStatus(CLOSED);
                    repository.save(s);
                }, () -> {
                      throw new IllegalStateException("Task with id " + id + " not found");
                }
        );
    }

}
