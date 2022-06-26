package com.example.demo.services;

import com.example.demo.data.mybatis.mappers.ProvinceDropdownMapper;
import com.example.demo.data.mybatis.models.DropdownModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DropdownService {
    private final ProvinceDropdownMapper provinceDropdownMapper;
    @Transactional(readOnly = true)
    public List<DropdownModel> getAllProvinces() {
        return provinceDropdownMapper.findAllProvinces(null);
    }

    public List<DropdownModel> getAllActiveProvinces() {
        return provinceDropdownMapper.findAllProvinces("Y");
    }

    public List<DropdownModel> getActiveProvincesIn(final List<String> provincesCds) {
        return provinceDropdownMapper.findAllProvincesIn("Y",provincesCds);
    }

}
