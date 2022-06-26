package com.example.demo.data.mybatis.mappers;

import com.example.demo.data.mybatis.models.DropdownModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProvinceDropdownMapper {
    List<DropdownModel> findAllProvinces(@Param("activeFlag") final String activeFlag);

    List<DropdownModel> findAllProvincesIn(@Param("activeFlag") final String activeFlag, @Param("valTexts") final List<String> valTexts);

}
