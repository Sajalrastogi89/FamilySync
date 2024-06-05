package com.example.FamilySync.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T> {
    private String Message;
    private Boolean Status;
    private T responseObject;
}
