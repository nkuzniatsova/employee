package src.main.java;


import java.util.ArrayList;

public class EmployeesAdmin {

	private ArrayList<Employee> employees = null;

	public EmployeesAdmin() {
		employees = new ArrayList<Employee>();
	}

	public boolean addEgineer(int id, double monthlySalary) {          
                Engineer e = new Engineer(id, monthlySalary);                
                return addEmployee(e);
	}
	
	public ArrayList<Employee> getEmployees() {
            return employees;
        }

	/* setter is niet nodig
        public void setEmployees(ArrayList<Employee> employees) {
            this.employees = employees;
        } */

        public boolean addSalesman(int id, double monthlySalary, double commission) {          
          Salesman s = new Salesman(id, monthlySalary, commission);                
          return addEmployee(s);
        }
	
	public boolean addManager(int id, double monthlySalary, double bonus) {          
          Manager m = new Manager(id, monthlySalary, bonus);                
          return addEmployee(m);
        }
	
	public boolean addEmployee(Employee employee) {
	  boolean res = true;
	  if (this.contains(employee)) {
            res = false;
          } else {
            employees.add(employee);
          }	  
	  return res;
	}
	
	public boolean contains(Employee e) {
		boolean res = false;
		int n = employees.size();
		int i = 0;
		while (!res && i < n) {
			if (e.equals(employees.get(i))) {
				res = true;
			}
			i++;
		}
		return res;
	}

	public double calcTotalPayAmount() {
		double res = 0.0;
		for (Employee e : employees) {
			res = res + e.payAmount();
		}
		return res;
	}

	public String toString() {
		String res = "";
		for (Employee e : employees) {
			res = res + e.toString();
		}
		return res;
	}

	public int getHighestId() {
		int res = -1;
		for (Employee e : employees) {
			if (e.getId() > res) {
				res = e.getId();
			}
		}
		return res;
	}

	/**public boolean setManager(int employee,  int manager) {
		return employees.get(employee).setManager(employees.get(manager));
	} */
	
	//New version setManager, use employee id's as parameters instead of position in the ArrayList
	public boolean setManager(int employeeId,  int managerId) {
          return getEmployeeById(employeeId).setManager(getEmployeeById(managerId));
        }
	
	public Employee getEmployeeById(int id) {
	  Employee result = null;
	  for (Employee e : employees) {
            if (e.getId() == id) {
                    result = e;
            }	  
	  }
	  return result;
	}
	
}
