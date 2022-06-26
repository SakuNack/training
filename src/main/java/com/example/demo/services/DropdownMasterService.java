package com.example.demo.services;

import com.example.demo.data.mybatis.mappers.DropdownMasterMapper;
import com.example.demo.data.mybatis.models.DropdownModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class DropdownMasterService {
    private final DropdownMasterMapper mapper;
    public void  addDropdownMastersWithNoTx(List<DropdownModel> models){
        models.forEach(mapper::insert);

    }
  @Transactional(rollbackFor = Exception.class)
    public void  addDropdownMastersWithTx(List<DropdownModel> models){
        models.forEach(mapper::insert);

    }
}
