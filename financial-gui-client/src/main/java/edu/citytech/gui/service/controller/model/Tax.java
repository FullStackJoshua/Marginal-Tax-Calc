package edu.citytech.gui.service.controller.model;

import java.util.List;

public class Tax {
    private float effectiveTaxRate;
    private List<TaxRule> taxRules;
    private float taxPaid;

    public float getEffectiveTaxRate() {
        return effectiveTaxRate;
    }

    public List<TaxRule> getTaxRules() {
        return taxRules;
    }

    public float getTaxPaid() {
        return taxPaid;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "effectiveTaxRate=" + effectiveTaxRate +
                ", taxRules=" + taxRules +
                ", taxPaid=" + taxPaid +
                '}';
    }
}
