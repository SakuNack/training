package com.example.demo.controllers;

import com.example.demo.data.mybatis.models.DropdownModel;
import com.example.demo.dto.DropdownMasterDTO;
import com.example.demo.services.DropdownMasterService;
import com.example.demo.services.DropdownService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DropdownMasterController {
    private final DropdownMasterService service;
    private final ModelMapper modelMapper;


    @PostMapping(value = "/master/dropdowns/notx", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addDropdownsNoTx(@RequestBody final List<DropdownMasterDTO> inputDTOs) {
        List<DropdownModel> ddmList = inputDTOs.stream().map(dto ->modelMapper.map(dto,DropdownModel.class)).collect(Collectors.toList());
        try {
            service.addDropdownMastersWithNoTx(ddmList);
            return "INFO";
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return "ERR";
        }
    }

    @PostMapping(value = "/master/dropdowns/withtx", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addDropdownsWithTx(@RequestBody final List<DropdownMasterDTO> inputDTOs) {
        List<DropdownModel> ddmList = inputDTOs.stream().map(this::convertDTOToModel).collect(Collectors.toList());
        try {
            service.addDropdownMastersWithTx(ddmList);
            return "INFO";
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            return "ERR";
        }
    }


    private DropdownModel convertDTOToModel(DropdownMasterDTO dto) {
        return new DropdownModel(
                dto.getCategories(),
                dto.getValText(),
                dto.getLabelText(),
                new Integer(dto.getPriorityOrder()),
                "Y");

    }


}
