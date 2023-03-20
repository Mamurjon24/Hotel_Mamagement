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
@Table(name ="complain")
public class ComplainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employer_id")
    private EmployerEntity employer;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guest")
    private GuestEntity guest;
    @Column(name = "text")
    private String complainText;
    @Column(name = "complain_status")
    @Enumerated(EnumType.STRING)
    private ComplainStatus complainStatus;



}
