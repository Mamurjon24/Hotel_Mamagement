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
@Table(name ="booking_entity")
public class BookingEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer guestId;
    private Integer roomId;
    private LocalDate startBromDay;
    private LocalDate finishBromDay;
    private Double amount;


}
