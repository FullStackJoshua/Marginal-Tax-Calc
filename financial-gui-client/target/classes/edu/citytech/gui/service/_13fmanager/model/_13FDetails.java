package edu.citytech.gui.service._13fmanager.model;

import edu.citytech.gui.service.utlity.FormatUtility;

import java.util.Date;

public class _13FDetails {
    private String id;
    private String stock;
    private String manager;
    private Date reportDate;
    private double value;
    private float valueInBillions;
    private double share;

    public String getId() {
        return id;
    }

    public String getStock() {
        return stock;
    }

    public String getManager() {
        return manager;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public String getFormattedReport(){
        return FormatUtility.formatDate(this.getReportDate(),"yyyy-MM");
    }

    public double getValue() {
        return value;
    }

    public float getValueInBillions() {
        return valueInBillions;
    }

    public double getShare() {
        return share;
    }

    public String getFormattedValueInBillions() {
       return FormatUtility.commaStyle(getValueInBillions(), 2);
    }

    public double getShareInBillions() {
        return share/ 1_000_000_000;
    }

    public String getFormattedShareInBillions() {
        return FormatUtility.commaStyle(this.getShareInBillions(), 2);
    }

    @Override
    public String toString() {
        return "_13FDetails{" +
                "id='" + id + '\'' +
                ", stock='" + stock + '\'' +
                ", manager='" + manager + '\'' +
                ", reportDate=" + reportDate +
                ", value=" + value +
                ", valueInBillions=" + valueInBillions +
                ", share=" + share +
                '}';
    }
}