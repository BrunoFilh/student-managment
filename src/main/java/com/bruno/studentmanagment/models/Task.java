package com.bruno.studentmanagment.models;

import com.bruno.studentmanagment.enumeration.Classes;
import com.bruno.studentmanagment.enumeration.TaskStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;

@Entity
@Table(name = "task")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Classes taskClass;
    @NotEmpty(message = "Description should not be empty")
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate createdTime;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate scheduledCloseTime;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate closedTime;
    @ManyToOne
    @JoinColumn(name = "assigned_by_id")
    private Teacher assignedBy;
    @ManyToOne
    @JoinColumn(name = "assigned_to_id")
    private Student assignedTo;
    private TaskStatus status;

}
