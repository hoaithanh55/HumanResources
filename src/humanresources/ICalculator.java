package humanresources;

public interface ICalculator {
    // các giá trị lương của nhân viên
    public static int STAFF_BASE_SALARY = 3000000;                // Lương cơ bản của nhân viên
    public static int MANAGER_BASE_SALARY = 5000000;              // Lương cơ bản của quản lý
    public static int STAFF_OVERTIME_SALARY_PER_HOUR = 200000;    // Lương tăng ca mỗi một giờ của nhân viên
    public static int MANAGER_BUSINESS_SALARY = 8000000;          // Lương trách nhiệm của Business Leader
    public static int MANAGER_PROJECT_SALARY = 5000000;           // Lương trách nhiệm của Project Leader
    public static int MANAGER_TECHNICAL_SALARY = 6000000;         // Lương trách nhiệm của Technical Leader
    
    // Hàm tính lương để class Employee và Manager implement để tính lương phù hợp
    public double calculateSalary();

}
