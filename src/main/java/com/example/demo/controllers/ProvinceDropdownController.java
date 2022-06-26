package com.example.demo.controllers;

import com.example.demo.data.mybatis.models.DropdownModel;
import com.example.demo.dto.DropdownDTO;
import com.example.demo.services.DropdownService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ProvinceDropdownController {
    private final DropdownService dropdownService;
    @GetMapping("/dropdown/provinces")
    public List<DropdownDTO> getAllProvinces() {
        return dropdownService.getAllProvinces().stream().map(this::convertModelToDto).collect(Collectors.toList());
    }

    @GetMapping("/dropdown/active/provinces")
    public List<DropdownDTO> getActiveProvinces() {
        return dropdownService.getAllActiveProvinces().stream().map(this::convertModelToDto).collect(Collectors.toList());
    }
    @GetMapping("/dropdown/active/provinces/in/{provinceList}")
    public List<DropdownDTO> getActiveProvincesIn(@PathVariable("provinceList") final String provinceCodes) {
        List<String>provinceCdList = Arrays.asList(StringUtils.split(provinceCodes, ","));
        return dropdownService.getActiveProvincesIn(provinceCdList).stream().map(this::convertModelToDto).collect(Collectors.toList());
    }

    private  DropdownDTO convertModelToDto(DropdownModel model){
        return new DropdownDTO(model.getValText(),model.getLabelText());
    }
}
