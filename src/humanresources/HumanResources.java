package humanresources;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class HumanResources {

    // ArrayList để quản lý toàn bộ nhân viên trong công ty
    static ArrayList<Staff> staffList = new ArrayList<>();

    //ArrayList để quản lý danh sách các bộ phận;
    static ArrayList<Department> departmentList = new ArrayList<>();

    // Nhận dữ liệu từ bàn phím;
    static Scanner sc = new Scanner(System.in);

    // Hàm main xử lý luồng chính của chương trình
    public static void main(String[] args) {
        testStaff();
        arrDepartment();
        menuInterface();
    }

    // Tạo giao diện và gán chức năng tương tác với chương trình
    public static void menuInterface() {
        boolean cont = true;
        int ans;
        do {
            System.out.println("+------------------------------------------------------------------+");
            System.out.println("|                            MENU                                  |");
            System.out.println("+------------------------------------------------------------------+");
            System.out.println("|   1. Hiển thị danh sách nhân viên hiện có trong công ty.         |");
            System.out.println("|   2. Hiển thị các bộ phận trong công ty.                         |");
            System.out.println("|   3. Hiển thị các nhân viên theo từng bộ phân.                   |");
            System.out.println("|   4. Thêm nhân viên mới vào công ty.                             |");
            System.out.println("|   5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.    |");
            System.out.println("|   6. HIển thị bảng lương của nhân viên toàn công ty.             |");
            System.out.println("|   7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.     |");
            System.out.println("|   0. Thoát chương trình.                                         |");
            System.out.println("+------------------------------------------------------------------+");
            System.out.print("Lựa chọn của bạn : ");
            ans = sc.nextInt();

            switch (ans) {
                // Hiển thị danh sách nhân viên hiện có trong công ty.
                case 1:
                    System.out.println();
                    showStaffList();
                    System.out.println();
                    break;

                // Hiển thị các bộ phận trong công ty.
                case 2:
                    System.out.println();
                    showDepartList();
                    System.out.println();
                    break;

                // Hiển thị các nhân viên theo từng bộ phân. 
                case 3:
                    System.out.println();
                    employeePerDepartment();
                    System.out.println();
                    break;

                // Thêm nhân viên mới vào công ty. 
                case 4:
                    System.out.println();
                    addNewStaff();
                    System.out.println();
                    break;

                // Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên. 
                case 5:
                    System.out.println();
                    findStaff();
                    System.out.println();
                    break;

                // HIển thị bảng lương của nhân viên toàn công ty. 
                case 6:
                    System.out.println();
                    decreaseSalaryStaff();
                    System.out.println();
                    break;

                // Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.
                case 7:
                    System.out.println();
                    ascendingSalaryStaff();
                    System.out.println();
                    break;

                case 0:
                    System.out.println("Chương trình kết thúc. Tạm biệt !");
                    cont = false;
                    break;
                //Thoát chương trình.
                default:
                    System.out.println("Bạn đã nhập sai mời bạn thử lại !");
                    cont = false;
            }

        } while (cont);

    }

    // Mảng danh sách nhân viên.
    static void staffList() {
        for (Staff i : staffList) {
            i.displayInformation();
        }
    }

    // Mảng các bộ phận trong công ty
    static void departmentList() {
        for (Department depart : departmentList) {
            System.out.println(depart);
        }
    }

    // Hiển thị danh sách nhân viên
    public static void showStaffList() {
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.printf("|  %-10s  |  %-18s  |   %-4s |  %-11s  |   %-11s  |  %-6s  |     %-17s  |  %-23s  |    %-10s|\n", "Mã nhân viên", "Tên nhân viên", "Tuổi", "HS Lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
        staffList();
        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
    }

    // Hiển thị các bộ phận trong công ty.
    public static void showDepartList() {
        System.out.println("+--------------------------------------------------------------------------+");
        System.out.printf("|  %-10s  |       %-20s  | %-25s |\n", "Mã bộ phận", "Tên Bộ phận", "Số lượng nhân viên hiện tại");
        System.out.println("+--------------------------------------------------------------------------+");
        infoDepartment();
        System.out.println("+--------------------------------------------------------------------------+");
    }

    // thêm danh sách các bộ phận
    public static void arrDepartment() {
        Department department1 = new Department("HC", "Hành chính nhân sự");
        Department department2 = new Department("IT", "Công nghệ thông tin");
        Department department3 = new Department("MKT", "Marketing");

        departmentList.add(department1);
        departmentList.add(department2);
        departmentList.add(department3);
    }

    // Hiên thị Các bộ phận trong công ty.
    public static void infoDepartment() {
        for (Department depart : departmentList) {
            for (Staff staff : staffList) {
                if (staff.getDepartName().equals(depart.getDepartmentName())) {
                    depart.setTotalSfaff(depart.getTotalSfaff() + 1);
                }
            }
            System.out.println(depart.toString());
        }
    }

    // Hiển thị các nhân viên theo từng bộ phận
    public static void employeePerDepartment() {
        for (Department depart : departmentList) {
            System.out.println(depart.getDepartmentName());
            System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.printf("|  %-10s  |  %-18s  |   %-4s |  %-11s  |   %-11s  |  %-6s  |     %-17s  |  %-23s  |    %-10s|\n", "Mã nhân viên", "Tên nhân viên", "Tuổi", "HS Lương", "Ngày vào làm", "Ngày nghỉ phép", "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
            System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            for (Staff staff : staffList) {
                if (staff.getDepartName().equals(depart.getDepartmentName())) {
                    staff.displayInformation();
                }
            }

            System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            System.out.println();
        }
    }

    //Thêm nhân viên mới vào công ty.
    public static void addNewStaff() {
        System.out.println("1. Thêm nhân viên thông thường.");
        System.out.println("2. Thêm nhân viên là cấp quản lý (có thêm chức vụ).");
        System.out.print("Bạn chọn : ");
        int choiceStaff = sc.nextInt();
        sc.nextLine();

        System.out.print("Nhập mã nhân viên: ");
        String id = sc.nextLine();

        System.out.print("Nhập tên nhân viên: ");
        String name = sc.nextLine();

        System.out.print("Nhập tuổi nhân viên: ");
        int age = sc.nextInt();

        System.out.print("Nhập hệ só lương của nhân viên: ");
        double CoefficientsSalary = sc.nextDouble();
        sc.nextLine();

        System.out.print("Nhập ngày vào làm của nhân viên: ");
        String dateStar = sc.nextLine();

        System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
        int holiday = sc.nextInt();

        System.out.println("1. HC - Hành chính nhân sự");
        System.out.println("2. IT - Công nghệ thông tin");
        System.out.println("3. MKT - Marketing");
        System.out.print("Bạn chọn bộ phận: ");
        int choiceDepart = sc.nextInt();

        switch (choiceStaff) {
            // Thêm nhân viên thông thường (Employee).
            case 1:
                Employee newEmployee = new Employee();
                newEmployee.setId(id);
                newEmployee.setName(name);
                newEmployee.setAge(age);
                newEmployee.setCoefficientsSalary(CoefficientsSalary);
                newEmployee.setStartingDate(dateStar);
                newEmployee.setHoliday(holiday);
                switch (choiceDepart) {
                    case 1:
                        newEmployee.setDepartName("Hành chính nhân sự");
                        break;
                    case 2:
                        newEmployee.setDepartName("Công nghệ thông tin");
                        break;
                    case 3:
                        newEmployee.setDepartName("Marketing");
                        break;
                    default:
                        break;
                }
                System.out.print("Nhập số giờ làm thêm: ");
                newEmployee.setSAFF_OVERTIME(sc.nextInt());
                staffList.add(newEmployee);
                break;

//            // Thêm nhân viên là quản lý có chức vự (Manager).
            case 2:
                Manager newManager = new Manager();
                newManager.setId(id);
                newManager.setName(name);
                newManager.setAge(age);
                newManager.setCoefficientsSalary(CoefficientsSalary);
                newManager.setStartingDate(dateStar);
                newManager.setHoliday(holiday);
                switch (choiceDepart) {
                    case 1:
                        newManager.setDepartName("Hành chính nhân sự");
                        break;
                    case 2:
                        newManager.setDepartName("Công nghệ thông tin");
                        break;
                    case 3:
                        newManager.setDepartName("Marketing");
                        break;
                    default:
                        break;
                }
                System.out.println("1. Business Leader");
                System.out.println("2. Project Leader");
                System.out.println("3. Technical Leader");
                System.out.print("Nhập chức danh: ");
                int positionManager = sc.nextInt();
                switch (positionManager) {
                    case 1:
                        newManager.setPosition("Business Leader");
                        break;
                    case 2:
                        newManager.setPosition("Project Leader");
                        break;
                    case 3:
                        newManager.setPosition("Technical Leader");
                        break;
                    default:
                        break;
                }
                staffList.add(newManager);
                break;

//                System.out.print("Nhập mã nhân viên: ");
//                newManager.setId(sc.nextLine());
//
//                System.out.print("Nhập tên nhân viên: ");
//                newManager.setName(sc.nextLine());
//
//                System.out.print("Nhập tuổi nhân viên: ");
//                newManager.setAge(sc.nextInt());
//
//                System.out.print("Nhập hệ só lương của nhân viên: ");
//                newManager.setCoefficientsSalary(sc.nextDouble());
//
//                sc.nextLine();
//
//                System.out.print("Nhập ngày vào làm của nhân viên: ");
//                newManager.setStartingDate(sc.nextLine());
//
//                System.out.print("Nhập số ngày nghỉ phép của nhân viên: ");
//                newManager.setHoliday(sc.nextInt());
//
//                System.out.println("1. HC - Hành chính nhân sự");
//                System.out.println("2. IT - Công nghệ thông tin");
//                System.out.println("3. MKT - Marketing");
//                System.out.print("Bạn chọn bộ phận: ");
//                int departManager = sc.nextInt();
//                switch (departManager) {
//                    case 1:
//                        newManager.setDepartName("Hành chính nhân sự");
//                        break;
//                    case 2:
//                        newManager.setDepartName("Công nghệ thông tin");
//                        break;
//                    case 3:
//                        newManager.setDepartName("Marketing");
//                        break;
//                    default:
//                        break;
//                }
//
//                System.out.println("1. Business Leader");
//                System.out.println("2. Project Leader");
//                System.out.println("3. Technical Leader");
//                System.out.print("Nhập chức danh: ");
//                int positionManager = sc.nextInt();
//                switch (positionManager) {
//                    case 1:
//                        newManager.setPosition("Business Leader");
//                        break;
//                    case 2:
//                        newManager.setPosition("Project Leader");
//                        break;
//                    case 3:
//                        newManager.setPosition("Technical Leader");
//                        break;
//                    default:
//                        break;
//                }
//                staffList.add(newManager);
//                break;
        }
    }

    // Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.
    public static void findStaff() {
        System.out.println("1. Tìm nhân viên bằng tên.");
        System.out.println("2. Tìm nhân viên bằng mã nhân viên.");
        System.out.print("Lựa chọn của bạn: ");
        int option = sc.nextInt();
        sc.nextLine();
        System.out.println();
        switch (option) {
            case 1:
                System.out.println("Nhập tên nhân viên cần tìm: ");
                String staffName = sc.nextLine();
                findStaffByName(staffName);
                break;
            case 2:
                System.out.println("Nhập mã nhân viên cần tìm: ");
                String staffID = sc.nextLine();
                findStaffByID(staffID);
                break;
        }
    }

    //Tìm kiếm nhân viên theo tên
    public static void findStaffByName(String staffName) {
        for (Staff staff : staffList) {
            // Tìm kiếm chuỗi ký tự tên nhân viên nhập vào trong staff.getName
            if (staff.getName().toLowerCase().contains(staffName.toLowerCase())) {
                System.out.println(
                        "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf(
                        "|  %-10s  |  %-18s  |   %-4s |  %-11s  |   %-11s  |  %-6s  |     %-17s  |  %-23s  |    %-10s|\n",
                        "Mã nhân viên", "Tên nhân viên", "Tuổi", "HS Lương", "Ngày vào làm", "Ngày nghỉ phép",
                        "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
                System.out.println(
                        "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                staff.displayInformation();
                System.out.println(
                        "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            }
        }
    }

    // Tìm kiếm nhân viên theo ID
    public static void findStaffByID(String staffID) {
        for (Staff staff : staffList) {
            // Tìm kiếm chuỗi ký tự ID trong staff.getID
            if (staff.getId().toLowerCase().contains(staffID.toLowerCase())) {
                System.out.println(
                        "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                System.out.printf(
                        "|  %-10s  |  %-18s  |   %-4s |  %-11s  |   %-11s  |  %-6s  |     %-17s  |  %-23s  |    %-10s|\n",
                        "Mã nhân viên", "Tên nhân viên", "Tuổi", "HS Lương", "Ngày vào làm", "Ngày nghỉ phép",
                        "Bộ phận", "Số giờ làm thêm/Chức vụ", "Lương");
                System.out.println(
                        "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
                staff.displayInformation();
                System.out.println(
                        "+-------------------------------------------------------------------------------------------------------------------------------------------------------------------------+");
            }
        }
    }

    //Hiển thị bảng lương của nhân viên theo thứ tự tăng dầnH
    public static void ascendingSalaryStaff() {
        Collections.sort(staffList, new Comparator<Staff>() {
            @Override
            // sắp xếp các phần tử staff
            public int compare(Staff staff1, Staff staff2) {
                if (staff1.calculateSalary() < staff2.calculateSalary()) {
                    return -1;
                } else if (staff1.calculateSalary() > staff2.calculateSalary()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        showStaffList();

    }

    //Hiển thị bảng lương của nhân viên toàn công ty theo thứ tự giảm dần
    public static void decreaseSalaryStaff() {
        Collections.sort(staffList, new Comparator<Staff>() {
            @Override
            // sắp xếp các phần tử staff
            public int compare(Staff staff1, Staff staff2) {
                if (staff1.calculateSalary() > staff2.calculateSalary()) {
                    return -1;
                } else if (staff1.calculateSalary() < staff2.calculateSalary()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        });
        showStaffList();
    }

    // Test Staff
    public static void testStaff() {
        Employee newEmployee1 = new Employee("E001", "Phong Tuyết Hoa", 28, 3.2, "10/10/2010", "Hành chính nhân sự", 10, 4);
        Employee newEmployee2 = new Employee("E002", "Trần Thị B", 24, 2.2, "09/10/2019", "Hành chính nhân sự", 7, 3);
        Employee newEmployee3 = new Employee("MKT001", "Ngô Văn Quế", 23, 2.1, "2/2/2020", "Marketing", 3, 5);

        Manager newManager1 = new Manager("M001", "Nguyễn Văn An", 25, 2.5, "11/11/2010", "Công nghệ thông tin", "Business Leader", 5);
        Manager newManager2 = new Manager("M002", "Tạ Văn Lục", 32, 4.5, "01/11/2010", "Công nghệ thông tin", "Technical Leader", 1);

        staffList.add(newEmployee1);
        staffList.add(newEmployee2);
        staffList.add(newEmployee3);
        staffList.add(newManager1);
        staffList.add(newManager2);
    }

}
