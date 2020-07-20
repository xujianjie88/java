package com.xjj.java.designpattern.principle.demeter.improve;

import java.util.ArrayList;
import java.util.List;

public class DemeterTest {

    public static void main(String[] args) {

        SchoolManager schoolManager = new SchoolManager();
        schoolManager.printAllEmployee(new CollegeManager());
    }
}


//学校总部员工类
class Employee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

//学院员工类
class CollegeEmployee {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

class CollegeManager {
    List<CollegeEmployee> getAllEmployee() {
        ArrayList<CollegeEmployee> collegeEmployees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CollegeEmployee collegeEmployee = new CollegeEmployee();
            collegeEmployee.setId("学院员工id=" + i);
            collegeEmployees.add(collegeEmployee);
        }
        return collegeEmployees;
    }

    public void printEmployee(){
        List<CollegeEmployee> allEmployee = getAllEmployee();
        System.out.println("==================分公司员工==========");
        for(CollegeEmployee collegeEmployee:allEmployee){
            System.out.println(collegeEmployee.getId());
        }
    }
}

//分析  SchoolManager类的直接朋友有那些，Employee,CollegeManager
//CollegeEmployee 不是直接朋友，而是陌生类，这样违背了迪米特法则
class SchoolManager {
    List<Employee> getAllEmployee() {
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Employee employee = new Employee();
            employee.setId("学院员工id=" + i);
            employees.add(employee);
        }
        return employees;
    }


    void printAllEmployee(CollegeManager collegeManager){
        //将输出学院员工方法，封装到CollegeManager
        collegeManager.printEmployee();
        List<Employee> allEmployee1 = this.getAllEmployee();
        System.out.println("==================分公司员工==========");
        for(Employee e:allEmployee1){
            System.out.println(e.getId());
        }
    }


}