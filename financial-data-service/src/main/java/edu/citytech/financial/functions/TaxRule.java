package edu.citytech.financial.functions;

import edu.citytech.financial.model.MarginalTaxRule;

public class TaxRule {
    public static MarginalTaxRule getTaxRule(String row){
        String[] columns = row.split(",");
        int rule = Integer.parseInt(columns[0]);
        float taxRate = Float.parseFloat(columns[1]);
        String code = columns[2];
        float range1 = Float.parseFloat(columns[3]);
        float range2 = Float.parseFloat(columns[4]);
        int year =  Integer.parseInt(columns[5]);

        return  new MarginalTaxRule(rule,taxRate,code,range1,range2,year);
    }
}
