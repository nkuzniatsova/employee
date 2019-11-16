package src.main.java;

abstract class Employee {
	
	private int id = 0;
	private double monthlySalary = 0.0;
	private Employee manager = null;

	public Employee(int id, double monthlySalary) {
		this.id = id;
		this.setMonthlySalary(monthlySalary);
	}

	public int getId() {
		return id;
	}

	public abstract double payAmount();

	public Employee getManager() {
		return manager;
	}
	
	public boolean setManager(Employee manager) {
		if (manager instanceof Manager) {
			this.manager = manager;
			return true;
		} else {
			return false;
		}
	}

	public int hashCode() {
		return id;
	}

	public boolean equals(Object obj) {
		boolean res = false;
		if (!(obj instanceof Employee)) {
			res = false;
		} else {
			int id2 = ((Employee) obj).getId();
			res = id == id2;
		}
		return res;
	}

	public abstract String toString();

        public double getMonthlySalary() {
          return monthlySalary;
        }
      
        public void setMonthlySalary(double monthlySalary) {
          this.monthlySalary = monthlySalary;
        }

}
