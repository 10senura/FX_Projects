package DataBase;

import Model.Customer;

import java.util.ArrayList;
import java.util.List;

public class DBConection {


    private static DBConection Instance;

    private List<Customer> CustomerList;
    private DBConection() {
        CustomerList=new ArrayList<>();
    }
    public List<Customer> getConnection(){
        return CustomerList;
    }
    public static DBConection getInstance() {
       return Instance==null ? Instance = new DBConection() : Instance;
    }
}
