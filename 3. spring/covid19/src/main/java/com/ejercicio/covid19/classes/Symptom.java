package com.ejercicio.covid19.classes;

public class Symptom {
    private String code;
    private String name;
    private String severityLevel;

    public Symptom() {
    }

    public Symptom(String code, String name, String severityLevel) {
        this.code = code;
        this.name = name;
        this.severityLevel = severityLevel;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getSeverityLevel() {
        return severityLevel;
    }


    @Override
    public String toString() {
        return "Symptom{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", severityLevel='" + severityLevel + '\'' +
                '}';
    }
}
