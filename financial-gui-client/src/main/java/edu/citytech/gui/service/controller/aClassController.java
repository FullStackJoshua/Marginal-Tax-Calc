package edu.citytech.gui.service.controller;

import edu.citytech.gui.service.controller.model.Tax;
import edu.citytech.gui.service.controller.model.TaxRule;
import edu.citytech.gui.service.utlity.FormatUtility;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class aClassController implements Initializable {

    @FXML
    private AnchorPane booboo;

    @FXML
    private RadioButton rbSingle;

    @FXML
    private ToggleGroup code;

    @FXML
    private RadioButton rbMarried;

    @FXML
    private RadioButton rbMarriedFilingJointly;

    @FXML
    private RadioButton rbHeadOfHouseHold;

    @FXML
    private Text currentPlan;

    @FXML
    private TextField tfSalary;

    @FXML
    private Label lblTitle;

    @FXML
    private AnchorPane apTaxSummary;

    @FXML
    private VBox apTaxBrackets;

    @FXML
    private BarChart<String, Number> graph;

    @FXML
    private Button clac;

    @FXML
    private Label lblURL;

    @FXML
    private Text taxLiabilityText;

    @FXML
    private AnchorPane apTaxYear;

    @FXML
    private Label first;

    @FXML
    private Label second;

    @FXML
    private Label third;

    @FXML
    private Label fourth;

    @FXML
    private Label fifth;

    @FXML
    private Label sixth;

    @FXML
    private Label seventh;

    @FXML
    private RadioButton three;

    @FXML
    private ToggleGroup year;

    @FXML
    private RadioButton two;

    @FXML
    private RadioButton one;

    @FXML
    private Label A;

    @FXML
    private CategoryAxis xAxis;

    private XYChart.Series<String, Number> series;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupGraph();
    }

    @FXML
    void clac(ActionEvent event) {
        /*--------------CAlls fUNCTIONS-----------------*/
        String code = getCode();
        String codeDescription = getCodeDescription(code);
        int salary = Integer.parseInt(tfSalary.getText());
        int year = getYear();
        buildTitle(year);
        /*--------------Chnages lblURL-----------------*/

        String dynamicURL = "http://localhost:9215/marginalTax/taxPaid?code=" + code + "&salary=" + salary + "&year=" + year;
        lblURL.setText("URL: " + dynamicURL);
        /*--------------Formats------------------*/
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        currencyFormat.setMaximumFractionDigits(2);
        /*---------------calls from the other files-----------------*/
        Tax taxData = taxService.findTaxPaid(code, salary, year);

        float taxLiabilityValue = taxData.getTaxPaid();

        float effectiveTaxRate = taxData.getEffectiveTaxRate() * 100;
        /*------------chnages the text called currentPlan --------------------*/
        currentPlan.setText("Under the current plan, if a " + codeDescription + " taxpayer earned " + currencyFormat.format(salary)
                + " in taxable income, they would owe the following income taxes for " + year
                + " (due in April " + (year + 1) + "):");
        /*--------------chnages the text called taxLiabilityText------------------*/
        taxLiabilityText.setText("If you add up these amounts, the entire tax liability for this individual would be "
                + currencyFormat.format(taxLiabilityValue) + ", or an effective tax rate of " + effectiveTaxRate + "% = ("
                + currencyFormat.format(taxLiabilityValue) + " / " + salary + ").");



        /*--------------Graph------------------*/

        graph.getData().clear();
        for (int year2 = 2021; year2 <= 2023; year2++) {
            float taxPaid = calculateTaxAmount(salary, taxData.getTaxRules().get(year2 - 2021));
            XYChart.Series<String, Number> dataSeries = new XYChart.Series<>();
            dataSeries.setName(String.valueOf(year2));
            dataSeries.getData().add(new XYChart.Data<>("Tax Amount", taxPaid));
            graph.getData().add(dataSeries);
        }

        updateGraph(salary, taxData);
        updateTaxBrackets(salary, taxData);
    }
    /*---------------End of on action-----------------*/
    private void setupGraph() {
        xAxis.setLabel("Tax Year");
        graph.setAnimated(false);
        series = new XYChart.Series<>();
        graph.getData().add(series);
    }

    public void updateGraph(int salary, Tax taxData) {
        series.getData().clear();

        for (TaxRule taxRule : taxData.getTaxRules()) {
            String yearLabel = String.valueOf(taxRule.getYear());
            float taxAmount = calculateTaxAmount(salary, taxRule);
            series.getData().add(new XYChart.Data<>(yearLabel, taxAmount));
        }
    }
    /*---------------Tax Bracket-----------------*/
    public float calculateTaxAmount(int salary, TaxRule taxRule) {
        float bracketRange1 = taxRule.getRange1();
        float bracketRange2 = taxRule.getRange2();
        float taxRate = taxRule.getTaxRate();

        float bracketAmount = Math.min(bracketRange2, salary) - bracketRange1;
        float taxPaid = bracketAmount * taxRate;

        return taxPaid;
    }
    /*--------------------------------*/
    private String getCode() {
        if (rbSingle.isSelected()) {
            return "S";
        } else if (rbMarried.isSelected()) {
            return "M";
        } else if (rbMarriedFilingJointly.isSelected()) {
            return "MFJ";
        } else if (rbHeadOfHouseHold.isSelected()) {
            return "HH";
        } else {
            return "";
        }
    }

    private String getCodeDescription(String code) {
        if (code.equals("S")) {
            return "Single";
        } else if (code.equals("M")) {
            return "Married";
        } else if (code.equals("HH")) {
            return "Head of Household";
        } else if (code.equals("MFJ")) {
            return "Married Filing Jointly";
        } else {
            return "";
        }
    }
    public void buildTitle(int year) {
        String newTitle = "Marginal Tax Rate For Year " + year;
        lblTitle.setText(newTitle);
    }

    public int getYear() {
        if (one.isSelected()) {
            return 2021;
        } else if (two.isSelected()) {
            return 2022;
        } else if (three.isSelected()) {
            return 2023;
        } else {
            return 0;
        }
    }

    private void updateTaxBrackets(int salary, Tax taxData) {
        List<Label> taxLabels = Arrays.asList(first, second, third, fourth, fifth, sixth, seventh);
        List<TaxRule> taxRules = taxData.getTaxRules();

        for (int i = 0; i < taxLabels.size(); i++) {
            if (i < taxRules.size()) {
                TaxRule taxRule = taxRules.get(i);
                float bracketRange1 = taxRule.getRange1();
                float bracketRange2 = taxRule.getRange2();
                float taxRate = taxRule.getTaxRate();

                String formattedRange1 = FormatUtility.commaStyle(bracketRange1, 2);
                String formattedRange2 = FormatUtility.commaStyle(bracketRange2, 2);
                String formattedTaxRate = FormatUtility.toPercentage(taxRate, 2);

                String taxBracket = formattedTaxRate +" Bracket: (" + formattedRange1 + " - " + formattedRange2 + ") x " + formattedTaxRate;
                taxLabels.get(i).setText(taxBracket);
            } else {
                taxLabels.get(i).setText( "Bracket: Not applicable");
            }
        }
    }
}
