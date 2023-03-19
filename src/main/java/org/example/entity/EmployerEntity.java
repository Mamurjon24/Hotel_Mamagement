package org.example.entity;

import lombok.*;
import org.example.enums.Employer_Type;
import org.example.enums.Status;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="employer_entity")
public class EmployerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String surName;
    private String phone;
    private LocalDate bithDate;
    private Status status;
    private Employer_Type employerType;
    private String employerWorkShift;

}
