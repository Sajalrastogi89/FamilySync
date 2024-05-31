package com.example.FamilySync.Entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Medical {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String date;
    private int sys;
    private int dys;
    private int heart;
    private int sugar;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
