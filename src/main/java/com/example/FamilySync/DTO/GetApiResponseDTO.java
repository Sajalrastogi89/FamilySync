package com.example.FamilySync.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetApiResponseDTO<T> {
    private String message;
    private Boolean status;
    private T responseObject;
}
