

public class Customer {
    private int customerID;
    private String name, phoneNumber;
    Customer(int customerID){
        this.customerID = customerID;
    }
    public int getCustomerID(){
        return customerID;
    }
    public String getCustomerName(){
        return name;
    }
    public String getCustomerPhone(){
        return phoneNumber;
    }
    public void checkRegularCustomer(){

    }
}
