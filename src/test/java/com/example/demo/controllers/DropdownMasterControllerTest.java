package com.example.demo.controllers;

import com.example.demo.data.mybatis.mappers.DropdownMasterMapper;
import com.example.demo.dto.DropdownMasterDTO;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DropdownMasterControllerTest {
    @Autowired
    TestRestTemplate restTemplate;
    @Autowired
    DropdownMasterMapper ddMaper;
    @Test
    @DisplayName("Test Case 1: No Transaction Control insert one duplicate of 02-Nontaburi data and add new 04-Prathumtani")
    @SneakyThrows
    @Sql(value = "ProvinceDropdownControllerTest/data_before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "ProvinceDropdownControllerTest/data_after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testCase1() {
        List<DropdownMasterDTO> dropdownMasterDTOList = Arrays.asList(new DropdownMasterDTO(
                        "PROVINCE", "04", "Prathumtani", "4"
                ),
                new DropdownMasterDTO(
                        "PROVINCE", "02", "Nontaburi", "2"
                ));
        HttpEntity<List<DropdownMasterDTO>> requestObj = new HttpEntity<>(dropdownMasterDTOList, null);
        ResponseEntity<String> response = restTemplate.exchange("/master/dropdowns/notx", HttpMethod.POST, requestObj, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("ERR",response.getBody());
        assertEquals(4,ddMaper.findAllActive().size());
    }

    @Test
    @DisplayName("Test Case 2: Transaction Control insert one duplicate of 02-Nontaburi data and add new 04-Prathumtani")
    @SneakyThrows
    @Sql(value = "ProvinceDropdownControllerTest/data_before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "ProvinceDropdownControllerTest/data_after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testCase2() {
        List<DropdownMasterDTO> dropdownMasterDTOList = Arrays.asList(new DropdownMasterDTO(
                        "PROVINCE", "04", "Prathumtani", "4"
                ),
                new DropdownMasterDTO(
                        "PROVINCE", "02", "Nontaburi", "2"
                ));
        HttpEntity<List<DropdownMasterDTO>> requestObj = new HttpEntity<>(dropdownMasterDTOList, null);
        ResponseEntity<String> response = restTemplate.exchange("/master/dropdowns/withtx", HttpMethod.POST, requestObj, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("ERR",response.getBody());
        assertEquals(3,ddMaper.findAllActive().size());
    }

    @Test
    @DisplayName("Test Case 3: Transaction Control insert one duplicate of 05-Chachoengsao data and add new 04-Prathumtani")
    @SneakyThrows
    @Sql(value = "ProvinceDropdownControllerTest/data_before.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    @Sql(value = "ProvinceDropdownControllerTest/data_after.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
    void testCase3() {
        List<DropdownMasterDTO> dropdownMasterDTOList = Arrays.asList(new DropdownMasterDTO(
                        "PROVINCE", "04", "Prathumtani", "4"
                ),
                new DropdownMasterDTO(
                        "PROVINCE", "05", "Chachoengsao", "5"
                ));
        HttpEntity<List<DropdownMasterDTO>> requestObj = new HttpEntity<>(dropdownMasterDTOList, null);
        ResponseEntity<String> response = restTemplate.exchange("/master/dropdowns/withtx", HttpMethod.POST, requestObj, String.class);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals("INFO",response.getBody());
        assertEquals(5,ddMaper.findAllActive().size());
    }

}