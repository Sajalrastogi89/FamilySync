package com.example.FamilySync.Models;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name="documents")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dId;

    private String file;
    private String fileName;

    @ManyToOne
    @JoinColumn(name = "folder_id")
    private Folder folder;
}

