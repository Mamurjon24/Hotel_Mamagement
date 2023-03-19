package org.example.entity;

import lombok.*;
import org.example.enums.RoomType;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="room_entity")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer number;
    private Integer floorNumber;
    private RoomType roomType;
    private Double prise;
    private Float area;

}
