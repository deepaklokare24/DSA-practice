package com.mosh;

public class Employee {
    private int baseSalary;
    private int hourlyRate;

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        validateHourlyRate(hourlyRate);
        this.hourlyRate = hourlyRate;
    }

    private void validateHourlyRate(int hourlyRate) {
        if(hourlyRate <= 0){
            throw new IllegalArgumentException("Hourly rate should be greater than 0!");
        }
    }

    public int calculateWage(int extraHours){
        return baseSalary + (extraHours * hourlyRate);
    }
}
