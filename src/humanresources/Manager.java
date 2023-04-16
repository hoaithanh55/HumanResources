
package humanresources;


public class Manager extends Staff implements ICalculator{
    
    private String position;            // chức danh
    
    public Manager(String id, String name, int age, double coefficientsSalary, String startingDate, String department, String position, int holiday) {
        super(id, name, age, coefficientsSalary, startingDate, department, holiday);
        this.position = position;
    }
    
    public Manager(){}
    
    public String getPosition() {
        return position;
    }
    
    public void setPosition(String position) {
        this.position = position;
    }
    
    // Phương thức tính lương của cấp quản lý.
    @Override
    public double calculateSalary() {
        //Lương trách nhiệm:
        int accountability_pay = 0;
        switch (position) {
            case "Business Leader":
                accountability_pay = MANAGER_BUSINESS_SALARY;
                break;
            case "Project Leader":
                accountability_pay = MANAGER_PROJECT_SALARY;
                break;
            case "Technical Leader":
                accountability_pay = MANAGER_TECHNICAL_SALARY;
                break;
            default:
                break;
        }
        //Tính lương
        double MANAGER_SALARY = getCoefficientsSalary() * MANAGER_BASE_SALARY + accountability_pay;
        return MANAGER_SALARY;
    }
    
    // in thông tin nhân viên là cấp quản lý ra màn hình
    @Override
    public void displayInformation() {
        System.out.printf("| %-14s | %-20s |   %-4d | %-13.1f |   %-13s |    %-13d |   %-20s |   %-23s | %-13.2f|\n",
                            getId(), getName(), getAge(), getCoefficientsSalary(), getStartingDate(), 
                            getHoliday(), getDepartName(), getPosition(), calculateSalary());
    }

    
    
}
