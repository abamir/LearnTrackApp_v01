package com.airtribe.learntrack.utility;

import com.airtribe.learntrack.exceptions.InvalidInputException;

public class InputValidator {

    public static void validateNotEmpty(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new InvalidInputException(fieldName + " cannot be empty.");
        }
    }

    public static void validatePositiveNumber(int value, String fieldName) {
        if (value <= 0) {
            throw new InvalidInputException(fieldName + " must be a positive number.");
        }
    }

    public static void validateEmail(String email) {
        if (email == null || !email.contains("@") || !email.contains(".")) {
            throw new InvalidInputException("Invalid email format: " + email);
        }
    }
}
