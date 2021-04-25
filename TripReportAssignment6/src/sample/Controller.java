package sample;

import ConnectionMySql.ConnectionClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

import java.awt.*;
import java.awt.Button;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Date;
import java.util.ResourceBundle;

public class Controller {


    @FXML
    public TextField truckNo;
    @FXML
    public TextField driverNo;
    @FXML
    public TextField coDriverNo;
    @FXML
    public TextField tripNo;
    @FXML
    public DatePicker dateDep;
    @FXML
    public DatePicker dateRet;
    @FXML
    public TextField typeMerchandise;
    @FXML
    public TextField stateCode;
    @FXML
    public TextField mileageBefore;
    @FXML
    public TextField mileageAfter;
    @FXML
    public TextField gallonsPurchased;

    @FXML
    public Button submitReportButton;

    @FXML
    private Button detailReportButton;

    @FXML
    private Button summaryReportButton;

    @FXML
    private Button exceptionReportButton;

    @FXML
    private Label result;


    @FXML
    private TableView<TripReport> tableReport;
    @FXML
    private TableColumn<TripReport, String> truckNoCol;
    @FXML
    private TableColumn<TripReport, String> driverNoCol;
    @FXML
    private TableColumn<TripReport, String> coDriverNoCol;
    @FXML
    private TableColumn<TripReport, String> tripNoCol;
    @FXML
    private TableColumn<TripReport, Date> dateDepartedCol;
    @FXML
    private TableColumn<TripReport, Date> dateReturnedCol;
    @FXML
    private TableColumn<TripReport, String> typeMerchCol;
    @FXML
    private TableColumn<TripReport, String> stateCodeCol;
    @FXML
    private TableColumn<TripReport, Integer> mileageBeforeCol;
    @FXML
    private TableColumn<TripReport, Integer> mileageAfterCol;
    @FXML
    private TableColumn<TripReport, Integer> gallonsCol;


    private boolean inserted;

    public void submitReport(ActionEvent actionEvent)throws SQLException{
     insertRecord();
    }




    public ObservableList<TripReport> getTripReports(){
        ObservableList<TripReport> reportList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM TRIP_REPORT";
        Statement st;
        ResultSet rs;

        try{
            st= conn.createStatement();
            rs = st.executeQuery(query);
            TripReport tr;
            while(rs.next()){
                tr = new TripReport(rs.getString("TRIP_NUMBER"), rs.getString("TRUCK_NUMBER"), rs.getString("DRIVER_NUMBER"), rs.getString("CO_DRIVER_NUMBER"),
                        rs.getDate("DATE_DEPARTED"), rs.getDate("DATE_RETURNED"), rs.getString("TYPE_MERCH"),
                        rs.getString("STATE_CODE"), rs.getInt("MILEAGE_BEFORE"), rs.getInt("MILEAGE_AFTER"), rs.getInt("GALLONS_PURCHASE"));
                reportList.add(tr);

            }

        } catch (Exception throwables) {
            System.out.println(throwables.getMessage());
        }



    return reportList;
    }

    public ObservableList<TripReport> getSummaryReports(){
        ObservableList<TripReport> reportList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM TRIP_REPORT ORDER BY TRIP_NUMBER";
        Statement st;
        ResultSet rs;

        try{
            st= conn.createStatement();
            rs = st.executeQuery(query);
            TripReport tr;
            while(rs.next()){
                tr = new TripReport(rs.getString("TRIP_NUMBER"), rs.getString("TRUCK_NUMBER"), rs.getString("DRIVER_NUMBER"), rs.getString("CO_DRIVER_NUMBER"),
                        rs.getDate("DATE_DEPARTED"), rs.getDate("DATE_RETURNED"), rs.getString("TYPE_MERCH"),
                        rs.getString("STATE_CODE"), rs.getInt("MILEAGE_BEFORE"), rs.getInt("MILEAGE_AFTER"), rs.getInt("GALLONS_PURCHASE"));
                reportList.add(tr);

            }

        } catch (Exception throwables) {
            System.out.println(throwables.getMessage());
        }



        return reportList;
    }

    public ObservableList<TripReport> getExceptionReports(){
        ObservableList<TripReport> reportList = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String query = "SELECT * FROM TRIP_REPORT WHERE GALLONS_PURCHASE < 10";
        Statement st;
        ResultSet rs;

        try{
            st= conn.createStatement();
            rs = st.executeQuery(query);
            TripReport tr;
            while(rs.next()){
                tr = new TripReport(rs.getString("TRIP_NUMBER"), rs.getString("TRUCK_NUMBER"), rs.getString("DRIVER_NUMBER"), rs.getString("CO_DRIVER_NUMBER"),
                        rs.getDate("DATE_DEPARTED"), rs.getDate("DATE_RETURNED"), rs.getString("TYPE_MERCH"),
                        rs.getString("STATE_CODE"), rs.getInt("MILEAGE_BEFORE"), rs.getInt("MILEAGE_AFTER"), rs.getInt("GALLONS_PURCHASE"));
                reportList.add(tr);

            }

        } catch (Exception throwables) {
            System.out.println(throwables.getMessage());
        }



        return reportList;
    }

    public void showDetailReports(){
        ObservableList<TripReport> reportList = getTripReports();

        tripNoCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("tripNo"));
        truckNoCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("truckNo"));
        driverNoCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("driverNo"));
        coDriverNoCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("coDriverNo"));
        dateDepartedCol.setCellValueFactory(new PropertyValueFactory<TripReport, Date>("dateDep"));
        dateReturnedCol.setCellValueFactory(new PropertyValueFactory<TripReport, Date>("dateRet"));
        typeMerchCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("typeMerchandise"));
        stateCodeCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("stateCode"));
        mileageBeforeCol.setCellValueFactory(new PropertyValueFactory<TripReport, Integer>("mileageBefore"));
        mileageAfterCol.setCellValueFactory(new PropertyValueFactory<TripReport, Integer>("mileageAfter"));
        gallonsCol.setCellValueFactory(new PropertyValueFactory<TripReport, Integer>("gallonsPurchased"));

        tableReport.setItems(reportList);
    }

    public void showSummaryReports(){
        ObservableList<TripReport> reportList = getSummaryReports();

        tripNoCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("tripNo"));
        truckNoCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("truckNo"));
        driverNoCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("driverNo"));
        coDriverNoCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("coDriverNo"));
        dateDepartedCol.setCellValueFactory(new PropertyValueFactory<TripReport, Date>("dateDep"));
        dateReturnedCol.setCellValueFactory(new PropertyValueFactory<TripReport, Date>("dateRet"));
        typeMerchCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("typeMerchandise"));
        stateCodeCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("stateCode"));
        mileageBeforeCol.setCellValueFactory(new PropertyValueFactory<TripReport, Integer>("mileageBefore"));
        mileageAfterCol.setCellValueFactory(new PropertyValueFactory<TripReport, Integer>("mileageAfter"));
        gallonsCol.setCellValueFactory(new PropertyValueFactory<TripReport, Integer>("gallonsPurchased"));

        tableReport.setItems(reportList);
    }

    public void showExceptionReports(){
        ObservableList<TripReport> reportList = getExceptionReports();

        tripNoCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("tripNo"));
        truckNoCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("truckNo"));
        driverNoCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("driverNo"));
        coDriverNoCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("coDriverNo"));
        dateDepartedCol.setCellValueFactory(new PropertyValueFactory<TripReport, Date>("dateDep"));
        dateReturnedCol.setCellValueFactory(new PropertyValueFactory<TripReport, Date>("dateRet"));
        typeMerchCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("typeMerchandise"));
        stateCodeCol.setCellValueFactory(new PropertyValueFactory<TripReport, String>("stateCode"));
        mileageBeforeCol.setCellValueFactory(new PropertyValueFactory<TripReport, Integer>("mileageBefore"));
        mileageAfterCol.setCellValueFactory(new PropertyValueFactory<TripReport, Integer>("mileageAfter"));
        gallonsCol.setCellValueFactory(new PropertyValueFactory<TripReport, Integer>("gallonsPurchased"));

        tableReport.setItems(reportList);
    }

    private void insertRecord() throws SQLException{
            String query = "INSERT INTO TRIP_REPORT VALUES('" +
                    tripNo.getText() + "', '" + truckNo.getText() + "', '" + driverNo.getText() + "', '" + coDriverNo.getText() + "', '" +
                    dateDep.getValue() + "', '" + dateRet.getValue() + "', '" + typeMerchandise.getText() + "', '" + stateCode.getText() +
                    "', " + mileageBefore.getText() + ", " + mileageAfter.getText() + ", " + gallonsPurchased.getText() + ")";
            executeQuery(query);

            Connection conn = getConnection();
            Statement st = conn.createStatement();

            result.setText("Success!");
    }

    private void executeQuery(String query){
        Connection conn = getConnection();
        Statement st;

        try{
            st = conn.createStatement();
            st.executeUpdate(query);


        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public Connection getConnection() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/classassignmentdb", "root", "root");
            return connection;
        } catch (SQLException e) {
            System.out.println("Error");
            e.printStackTrace();
            return null;
        }
    }


}
