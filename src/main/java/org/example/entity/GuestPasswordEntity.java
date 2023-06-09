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
    @Column(name = "expired_date")
    private LocalDate expiredFrom;
    @Column(name = "given_address")
    private String givenAddress;

}
