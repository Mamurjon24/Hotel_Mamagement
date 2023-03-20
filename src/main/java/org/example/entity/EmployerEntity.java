package org.example.entity;

import lombok.*;
import org.example.enums.Status;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="employer")
public class EmployerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column(name = "surname")
    private String surName;
    @Column
    private String phone;
    @Column(name = "birth_date")
    private LocalDate bithDate;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_type_id")
    private EmployerTypeEntity employerType;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_worktable_id")
    private EmployerWorkTable employerWorkTable;

}
