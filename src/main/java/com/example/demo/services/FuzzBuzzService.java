package com.example.demo.services;

import org.springframework.stereotype.Service;

@Service
public class FuzzBuzzService {
    public String calculateFuzzBuzz(Integer input) {
        if (checkFuzzBuzz(input)) {
            return "FuzzBuzz";
        } else if (checkFuzz(input)) {
            return "Fuzz";
        } else if (checkBuzz(input)) {
            return "Buzz";
        }

        return input.toString();
    }

    private boolean checkFuzzBuzz(Integer input) {
        return input % 3 == 0 && input % 5 == 0;
    }

    private boolean checkFuzz(Integer input) {
        return input % 3 == 0;
    }

    private boolean checkBuzz(Integer input) {
        return input % 5 == 0;
    }
}

