package org.example.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "guest")
public class GuestEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @Column
    private String surName;
    @Column
    private String phone;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest_password")
    private GuestPasswordEntity gusetPassword;



}
