package com.example.demo.controllers;

import com.example.demo.services.FuzzBuzzService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fuzzbuzz")
@RequiredArgsConstructor
@Slf4j
public class FuzzBuzzController {
    private final FuzzBuzzService fuzzBuzzServices;

    @GetMapping("/{input}")
    public String getFuzzBuzz(@PathVariable("input") String input) {
        try {
            log.info("================" + input);
            Integer num = new Integer(input.toString());

            if (!input.matches("\\d*.?\\d*")) {
                return "Invalid integer";
            }
            if (checkLessZeroOrMoreTenThousand(num)) {
                return "Invalid number";
            }

            return fuzzBuzzServices.calculateFuzzBuzz(num);
        } catch (NumberFormatException e) {
            return "Invalid integer";
        }
    }

    private boolean checkLessZeroOrMoreTenThousand(Integer num) {
        return num <= 0 || num >= 10000;
    }

}
