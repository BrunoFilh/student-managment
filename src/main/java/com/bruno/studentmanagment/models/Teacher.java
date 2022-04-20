package com.bruno.studentmanagment.models;

import com.bruno.studentmanagment.enumeration.Classes;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ta_fid", referencedColumnName = "id")
    private Address address;
    private String email;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "st")
    @ToString.Exclude
    private List<Student> studentsList;
}
