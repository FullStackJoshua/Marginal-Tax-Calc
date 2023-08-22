package edu.citytech.gui.service.controller.model;

public class TaxRule {
    private int rule;
    private float taxRate;
    private String code;
    private float range1;
    private float range2;
    private int year;

    public int getRule() {
        return rule;
    }

    public float getTaxRate() {
        return taxRate;
    }

    public float getRange1() {
        return range1;
    }

    public float getRange2() {
        return range2;
    }

    public String getCode() {
        return code;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "TaxRule{" +
                "rule=" + rule +
                ", taxRate=" + taxRate +
                ", code='" + code + '\'' +
                ", range1=" + range1 +
                ", range2=" + range2 +
                ", year=" + year +
                '}';
    }
}
