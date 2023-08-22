package edu.citytech.gui.service.controller;

import com.jbbwebsolutions.http.utility.JSONGet;
import edu.citytech.gui.service.controller.model.Tax;

public class taxService {
    private static final String URL = "http://localhost:9215/marginalTax/taxPaid?code=$code&salary=$salary&year=$year";

    public static Tax findTaxPaid(String code, int salary, int year) {
        String dynamicURL = URL.replace("$code", code)
                .replace("$salary", String.valueOf(salary))
                .replace("$year", String.valueOf(year));

        return JSONGet.submitGet(dynamicURL, Tax.class);
    }
}
