package edu.citytech.financial;

import edu.citytech.marginaltax.checker.GradeMarginalTax;
import edu.citytech.marginaltax.checker.MarginalTaxCalculator;

public class T2_Test {
    public static void main(String[] args) {
        GradeMarginalTax.calculate(MarginalTaxCalculator::calculate, "/data/Joshua.Lim.answer.ser");
    }
}
