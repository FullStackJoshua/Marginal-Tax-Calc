package edu.citytech.financial;

import edu.citytech.financial.functions.TaxRule;
import edu.citytech.financial.model.MarginalTaxRule;
import edu.citytech.financial.service.MarginalTaxCalculator;
import edu.citytech.financial.utility.EnvironmentVariableUtility;
import edu.citytech.financial.utility.ReadFileUtility;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class T3_ScratchPad {

    @Test
    @DisplayName("tax1")
    public void t1(){
        float taxPaid = MarginalTaxCalculator.calculate("S", 150_000,2022,System.out::println);
        System.out.println("taxPaid: " + taxPaid);
    }
    @Test
    @DisplayName("tax1")
    public void t2(){
        EnvironmentVariableUtility.getVariables(System.out::println);
    }
    @Test
    @DisplayName("tax1")
    public void t3(){
       String data =  EnvironmentVariableUtility.getVariable("MARGINAL_TAX_RULE");
        System.out.println(data);
    }

}