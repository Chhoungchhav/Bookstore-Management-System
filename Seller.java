

public  class Seller extends Employee{
    final String position = "seller";
    final double salary = 200;
    Seller(int employeeID, String name, String password, String emailAddress, String startDate){
        super(employeeID, name, password, emailAddress, startDate);
    }
    
    @Override
    public double getSalary() {
        return super.getSalary() * this.salary;
    }

    @Override
    public String toString() {
        String tmp = super.toString() + ", position: " + this.position;

        return tmp;
    }
}
