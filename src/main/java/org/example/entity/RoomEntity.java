package org.example.entity;

import lombok.*;
import org.example.enums.RoomType;
import org.example.enums.Status;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="room")
public class RoomEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private Integer number;
    @Column(name = "floor_number")
    private Integer floorNumber;
    @Column(name = "room_type")
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    @Column
    private Double price;
    @Column
    private Float area;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "extra_amenities_id")
    private ExtraAmenitiesEntity extraAmenities;

}
