
package humanresources;

public abstract class Staff {
    private String id;                                  // Mã nhân viên
    private String name;                                // Tên nhân viên
    private int age;                                    // Tuổi nhân viên
    private double coefficientsSalary;                  // Hệ số Lương
    private String startingDate;                        // Ngày vào làm
    private String departName;                          // Bộ phận làm việc
    private int holiday;                                // Số ngày nghỉ phép
    
    public Staff(String id, String name, int age, double coefficientsSalary, String startingDate, String departName, int holiday){
        this.id = id;
        this.name = name;
        this.age = age;
        this.coefficientsSalary = coefficientsSalary;
        this.startingDate = startingDate;
        this.departName = departName;
        this.holiday = holiday;
    }
    
    public Staff() {}
    
    // Để các class kế thừa triển khai hiển thị thông tin Nhân viên
    public abstract void displayInformation();
    
    // Để class HumanrResouurces kế thừa so sánh và sắp xếp lương của nhân viên
    public abstract double calculateSalary();
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public double getCoefficientsSalary() {
        return coefficientsSalary;
    }
    
    public void setCoefficientsSalary(double coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }
    
    public String getStartingDate() {
        return startingDate;
    }
    
    public void setStartingDate(String startingDate) {
            this.startingDate = startingDate;
    }

    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }
    

    public int getHoliday() {
        return holiday;
    }
    
    public void setHoliday(int holiday) {
        this.holiday = holiday;
    }
}
