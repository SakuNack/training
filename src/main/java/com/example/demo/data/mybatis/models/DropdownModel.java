package com.example.demo.data.mybatis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DropdownModel {
    private String categories;
    private String valText;
    private String labelText;
    private Integer priorityOrder;
    @Builder.Default
    private String activeFlag = "Y";
}
