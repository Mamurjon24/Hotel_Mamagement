package org.example.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "guest_password")
public class GuestPasswordEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "given_date")
    private LocalDate givenDate;
    @Column(name = "end_date")
    private LocalDate endDate;
    @Column(name = "given_from")
    private String givenFrom;
    @Column(name = "given_address")
    private String givenAddress;

}
