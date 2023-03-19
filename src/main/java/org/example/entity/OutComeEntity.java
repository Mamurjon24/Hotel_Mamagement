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
@Table(name ="outCome_entity")
public class OutComeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDate payDate;
    private Double forElectricity;
    private Double forGas;
    private Double forInternet;
    private Double forUtilityBills;
    private Double forSalary;

}
