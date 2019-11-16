package src.main.java;
public class Manager extends Employee {
  double bonus = 0.0; 

  public Manager(int id, double monthlySalary, double bonus) {
      super(id, monthlySalary);
      this.bonus = bonus;
    }

    public double payAmount() {
      
      return getMonthlySalary() + bonus;   
    }
    
    public String toString() {
      String s =      "Manager, " + "id: " + getId() + ", " + "monthly salary: "
                              + getMonthlySalary() + ", " + "bonus: "
                                  + getBonus();
      if (getManager()!=null) {
              s = s + ", " + "manager: " + getManager().getId();
      }
      s = s + ".\n";
      return s;
    }

    public double getBonus() {
      return bonus;
    }

    public void setBonus(double bonus) {
      this.bonus = bonus;
    }
}
