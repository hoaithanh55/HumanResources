                                        
package humanresources;


public class Department {
    
    private String departmentID;                            // Mã bộ phận
    private String departmentName;                          // Tên bộ phận
    private int totalSfaff;                                 // Số lượng nhân viên hiện tại
    
    public Department(String departmentID, String departmentName, int totalSfaff) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
        this.totalSfaff = totalSfaff;
    }
    
    public Department(String departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }
    
    public String getDepartmentID() {
        return departmentID;
    }
    
    public void setDepartmentID(String departmentID) {
        this.departmentID = departmentID;
    }
    
    public String getDepartmentName() {
        return departmentName;
    }
    
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    
    public int getTotalSfaff() {
        return totalSfaff;
    }
    
    public void setTotalSfaff(int totalSfaff) {
        this.totalSfaff = totalSfaff;
    }
    
    // Phương thức hiển thị thông tin về bộ phận.
    @Override
    public String toString() {
        return String.format("|  %-10s  |       %-20s  |  %-25s  |", departmentID, departmentName, totalSfaff);
    }
}
