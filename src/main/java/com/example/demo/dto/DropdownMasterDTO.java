package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DropdownMasterDTO {
    private String categories;
    private String valText;
    private String labelText;
    private String priorityOrder;
}
