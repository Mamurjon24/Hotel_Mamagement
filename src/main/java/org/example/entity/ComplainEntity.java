package org.example.entity;
import lombok.*;
import org.example.enums.ComplainStatus;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name ="complain_entity")
public class ComplainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer employarId;
    private Integer guestId;
    private String complainText;
    private ComplainStatus complainStatus;



}
