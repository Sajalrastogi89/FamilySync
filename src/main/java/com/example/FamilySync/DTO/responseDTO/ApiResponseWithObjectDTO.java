package com.example.FamilySync.DTO.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponseWithObjectDTO<T> {
    private String message;
    private Boolean status;
    private T responseObject;
}
