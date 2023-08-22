package edu.citytech.financial.model;

import java.text.DecimalFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static edu.citytech.financial.utility.Format.*;

@Entity
@Table(name = "S13FManagers", schema = "finance")
public class _13FManagers {

	@Id
	@Column(name = "id")
	private String id;

	@Column(name = "stock")
	private String stock;

	@Column(name = "manager")
	private String manager;

	@Column(name = "report_date")
	private Date reportDate;

	@Column(name = "value")
	private double value;
	
    @Column(name = "value_in_billions ")
	private double valueInBillions;

	@Column(name = "share")
	private double share;

	
	public _13FManagers() {
		super();
	}

	public _13FManagers(String id, String stock, String manager, Date reportDate, double value, double share) {
		super();
		this.id = id;
		this.stock = stock;
		this.manager = manager;
		this.reportDate = reportDate;
		this.value = value;
		this.share = share;	
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getManager() {
		return manager;
	}

	public void setManager(String manager) {
		this.manager = manager;
	}

	public Date getReportDate() {
		return reportDate;
	}

	public void setReportDate(Date reportDate) {
		this.reportDate = reportDate;
	}

	public double getValue() {
		return value;
	}

	public double getShare() {
		return share;
	}

	public double getValueInBillions() {
		return valueInBillions;
	}

	public void setValueInBillions(double valueInBillions) {
		this.valueInBillions = valueInBillions;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public void setShare(double share) {
		this.share = share;
	}

	public static String format(Number inputNnumber) {
		String number = inputNnumber.toString();
		double amount = Double.parseDouble(number);
		DecimalFormat formatter = new DecimalFormat("###,###.00");
		return (formatter.format(amount));
	}
	public String simplePrint() {
		return "_13FManagers [id=" + id + ", stock="
				+ stock + ", manager=" + manager
				+ ", valueInBillions=" + format(valueInBillions) + ", share=" + format(share/1_000_000_000);
	}

}