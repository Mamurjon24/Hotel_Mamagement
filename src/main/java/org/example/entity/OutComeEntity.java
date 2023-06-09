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
@Table(name ="out_come")
public class OutComeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String reason;
    @Column(name = "pay_date")
    private LocalDate payDate;
    @Column
    private Double amount;


}
