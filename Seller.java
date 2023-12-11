package Bookstore_Management;

public  class Seller extends Employee{
    final String position = "seller";
    Seller(int employeeID, String name, String password, String emailAddress, String startDate){
        super(employeeID, name, password, emailAddress, startDate);
    }
    
    @Override
    public String toString() {
        String tmp = super.toString() + this.position;

        return tmp;
    }
}
