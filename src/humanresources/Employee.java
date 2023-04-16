
package humanresources;


public class Employee extends Staff implements ICalculator{
    private double STAFF_OVERTIME;                 // số giờ làm thêm của nhân viên
    
    public Employee(String id, String name,int age, double coefficientsSalary, String startingDate, String department, int holiday, double STAFF_OVERTIME) {
        super(id, name, age, coefficientsSalary, startingDate, department, holiday);
        this.STAFF_OVERTIME = STAFF_OVERTIME;
    }
    
    public Employee(){}
    public double getSTAFF_OVERTIME() {
        return STAFF_OVERTIME;
    }
    
    public void setSAFF_OVERTIME(int STAFF_OVERTIME) {
        this.STAFF_OVERTIME = STAFF_OVERTIME;
    }

    @Override
    public double calculateSalary() {
        // trả về lương nhân viên
        double STAFF_SALARY = getCoefficientsSalary() * STAFF_BASE_SALARY + STAFF_OVERTIME * STAFF_OVERTIME_SALARY_PER_HOUR;
        return STAFF_SALARY;
    }

    @Override
    public void displayInformation() {
        // Hiển thị thông tin ra màn hình
        System.out.printf("| %-14s | %-20s |   %-4d | %-13.1f |   %-13s |    %-13d |   %-20s |   %-23s | %-13.2f|\n", 
                getId(), getName(), getAge(), getCoefficientsSalary(), getStartingDate(), 
                getHoliday(), getDepartName(), getSTAFF_OVERTIME(), calculateSalary());
    }
}                                   
