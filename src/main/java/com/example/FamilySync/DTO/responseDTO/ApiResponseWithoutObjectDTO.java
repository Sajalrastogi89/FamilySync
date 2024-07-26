package com.example.FamilySync.DTO.responseDTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter@Setter@AllArgsConstructor
@NoArgsConstructor
public class ApiResponseWithoutObjectDTO {
    private String message;
    private boolean status;
}
