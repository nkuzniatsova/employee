package src.main.java;
public class Salesman extends Employee {

  double commission = 0.0; 

  public Salesman(int id, double monthlySalary, double commission) {
      super(id, monthlySalary);
      this.commission = commission;
    }

    public double payAmount() {
      
      return getMonthlySalary() + commission;   
    }
    
    public String toString() {
      String s =      "Salesman, " + "id: " + getId() + ", " + "monthly salary: "
                              + getMonthlySalary() + ", " + "commission: "
                                  + getCommission();
      if (getManager()!=null) {
              s = s + ", " + "manager: " + getManager().getId();
      }
      s = s + ".\n";
      return s;
    }
    
    public double getCommission() {
      return commission;
    }

    public void setCommission(double commission) {
      this.commission = commission;
    }
    
}
