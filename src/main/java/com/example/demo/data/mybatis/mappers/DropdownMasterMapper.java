package com.example.demo.data.mybatis.mappers;

import com.example.demo.data.mybatis.models.DropdownModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DropdownMasterMapper {
    List<DropdownModel> findAllActive() ;
    void insert(DropdownModel model);
}
