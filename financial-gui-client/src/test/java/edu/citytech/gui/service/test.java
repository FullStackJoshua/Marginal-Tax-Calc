package edu.citytech.gui.service;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.gui.service.controller.model.tax;
import edu.citytech.gui.service.controller.model.TaxRule;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class test {

    private String URL = "http://localhost:9215/marginalTax/taxPaid?code=S&salary=15000&year=2021";

    @Test
    @DisplayName("Output All Data")
    void t2_outputAllData() {
        var results = JSONGet.submitGet(URL, tax.class);

        if (results != null && results.getTaxRules() != null) {
            List<TaxRule> taxRules = results.getTaxRules();

            for (var taxRule : taxRules) {
                System.out.println("Rule: " + taxRule.getRule());
                System.out.println("Tax Rate: " + taxRule.getTaxRate());
                System.out.println("Code: " + taxRule.getCode());
                System.out.println("Range 1: " + taxRule.getRange1());
                System.out.println("Range 2: " + taxRule.getRange2());
                System.out.println("Year: " + taxRule.getYear());
                System.out.println("-----------------------");
            }

            int actual = taxRules.size();
            int expected = 2;

            assertEquals(expected, actual);
        } else {
            System.out.println("No results found.");
        }
    }
}
