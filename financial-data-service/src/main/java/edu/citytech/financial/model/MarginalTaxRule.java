package edu.citytech.financial.model;

public record MarginalTaxRule(int rule,double taxRate,String code,
                           double range1, double range2, int year ){
        public double calculateTaxPaid(){
            double taxPaid = (range2 - range1) * taxRate;
            return taxPaid;
        }

        @Override
        public String toString() {
            return "MarginalTaxRule{" +
                    "rule =" + rule +
                    ", year=" + year +
                    ", taxRate=" + taxRate +
                    ", code='" + code + '\'' +
                    ", range1=" + range1 +
                    ", range2=" + range2 +
                    ", calculateTaxPaid=" + calculateTaxPaid() +
                    '}';
        }
    }