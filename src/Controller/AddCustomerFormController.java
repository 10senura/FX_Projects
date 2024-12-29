package Controller;

import DataBase.DBConection;
import Model.Customer;
import com.sun.org.apache.xpath.internal.objects.XObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.print.attribute.standard.JobImpressionsSupported;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class AddCustomerFormController {

    public TableView tblAddCustomer;
    public TableColumn clmName;
    public TableColumn clmAge;
    public TableColumn clmAddress;
    public TableColumn clmSalary;

    public Label lblHello;
    public TextField txtName;
    public TextField txtAge;
    public TextField txtAddress;
    public TextField txtSalary;

    public void btnAddCustomerForm(ActionEvent actionEvent) {
         String name= txtName.getText();
         String age=txtAge.getText();
         String address=txtAddress.getText();
         double salary=Double.parseDouble(txtSalary.getText());

        DBConection.getInstance().getConnection().add(new Customer(name,age,address,salary));
        System.out.println(DBConection.getInstance().getConnection());
        lodetable();
    }
    private void lodetable(){
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
        clmName.setCellValueFactory(new PropertyValueFactory<>("name"));
        clmAge.setCellValueFactory(new PropertyValueFactory<>("age"));
        clmAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        clmSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));

        DBConection.getInstance().getConnection().forEach(Obj->{
            customerObservableList.add(Obj);
        });

        tblAddCustomer.setItems(customerObservableList);

    }

    public void btnViewCustomerForm(ActionEvent actionEvent) throws IOException {
        Stage stage= new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../View/ViewCustomerForm.fxml"))));
        stage.show();
    }

    public void btnViewCustomerOnAction(ActionEvent actionEvent) {
         lodetable();
    }
}
