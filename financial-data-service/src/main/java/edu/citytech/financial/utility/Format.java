package edu.citytech.financial.utility;

import java.text.DecimalFormat;

public class Format {

    public static String format(Number inputNnumber) {
        String number = inputNnumber.toString();
        double amount = Double.parseDouble(number);
        DecimalFormat formatter = new DecimalFormat("###,###.00");
        return (formatter.format(amount));
    }
}
