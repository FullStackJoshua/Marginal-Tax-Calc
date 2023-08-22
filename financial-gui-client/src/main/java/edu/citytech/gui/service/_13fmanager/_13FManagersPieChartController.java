package edu.citytech.gui.service._13fmanager;

import edu.citytech.gui.service._13fmanager.model._13FDetails;
import edu.citytech.gui.service.utlity.FormatUtility;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Supplier;

public class _13FManagersPieChartController implements Initializable {

    @FXML
    private Slider slLimit;

    @FXML
    private TextField txtLimit;

    @FXML
    private PieChart pieChart;

    @FXML
    private TextField txtStockInput;
    @FXML
    private Button btnSearch;
    @FXML
    private Label lblTitle;

    @FXML
    private ToggleGroup tgDisplayGroup;

    @FXML
    private TableView<_13FDetails> tvReport;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setupSlider();
        int limit = Integer.parseInt(this.txtLimit.getText());
        var total = this.retrieveData("AAPL", limit);
        buildTitle(txtStockInput.getText(), total);
    }
    static final String title = "For $stock stock total in billions: $amount ";
    public  void buildTitle(String symbol, double amount){
      String sAmount = FormatUtility.commaStyle(amount,2);
      String newTitle =   title.replace("$stock", symbol).replace("$amount", sAmount + "");
      lblTitle.setText(newTitle);
    }

    public double retrieveData(String symbol, int limit){
        pieChart.getData().clear();

        System.out.println(tgDisplayGroup.getSelectedToggle().getUserData());

        var list =  _13FManagerService.find13FManagers(symbol, limit);

        tvReport.getItems().clear();
        var oResult = tvReport.getItems();
        oResult.addAll(list);

        list.forEach(System.out::println);

        String mode = tgDisplayGroup.getSelectedToggle().getUserData().toString();
        list.stream().limit(10).forEach( e -> {
            Supplier<String> supplier = mode.equals("id") ? e::getId: e::getManager;
            PieChart.Data slice1 = new PieChart.Data(supplier.get(),e.getValueInBillions());
            pieChart.getData().add(slice1);
        });

        var total = list.stream().mapToDouble(_13FDetails::getValueInBillions).sum();

         updatePercentage();

        return total;
    }

    private void updatePercentage() {
        var total = pieChart.getData().stream()
                .mapToDouble(PieChart.Data::getPieValue)
                .sum();
        for(var data : pieChart.getData()){
            String name = data.getName();
            double number = data.getPieValue() / total;
            String percentage = FormatUtility.toPercentage(number, 2);
            data.setName("(number)".replace("number", percentage + "" ) + " " + name);

        }

    }


    private void setupSlider() {
        slLimit.setValue(10);
        txtLimit.setText("10");


        slLimit.valueProperty().addListener(e-> {
            var db = (DoubleProperty)e;
            txtLimit.setText( (int)db.getValue().doubleValue() + " " );


            System.out.println("Lim, Joshua " + db.getValue());
        });
    }
    @FXML
    void onSearch(ActionEvent event) {

        int limit = Integer.parseInt(txtLimit.getText());
        var total = retrieveData(txtStockInput.getText(), limit );


        buildTitle(txtStockInput.getText(), 444);
    }
}
