package com.fazenda.streetMusicConcert.util;

public class ValidationResult {

    public enum ValidationStatus {OK, ERROR};

    private ValidationStatus validationStatus;
    private String validationMessage;

    public ValidationResult(ValidationStatus validationStatus, String validationMessage) {
        this.validationStatus = validationStatus;
        this.validationMessage = validationMessage;
    }

    public ValidationStatus getValidationStatus() {
        return validationStatus;
    }

    public String getValidationMessage() {
        return validationMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ValidationResult that = (ValidationResult) o;

        if (validationStatus != that.validationStatus) return false;
        return validationMessage.equals(that.validationMessage);

    }

    @Override
    public int hashCode() {
        int result = validationStatus.hashCode();
        result = 31 * result + validationMessage.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ValidationResult{" +
                "validationStatus=" + validationStatus +
                ", validationMessage='" + validationMessage + '\'' +
                '}';
    }
}