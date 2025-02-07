package org.example;

import org.example.Employee;

import java.util.Objects;

public class EmployeeBook {
    private Employee[] employees = new Employee[10];

    public boolean addNewEmployee(Employee newEmployee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = newEmployee;
                return true;
            }
        }
        return false;
    }

    public boolean removeEmployee(int id) {
        int employeeIndex = findEmployeeIndexByID(id);
        if (employeeIndex>=0) {
            employees[employeeIndex] = null;
            return true;
        }
        return false;
    }

    public int findEmployeeIndexByID(int id) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void printEmpoyeesWithSalaryBiggerThan(int number) {
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() > number) {
                System.out.println(employees[i]);
                count++;
            }
        }
        if (count == 0) {
            System.out.printf("Сотрудников с зарплатой больше %d нет %n", number);
        }
    }

    public void printEmpoyeesWithSalaryLowerThan(int number) {
        int count = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && employees[i].getSalary() < number) {
                System.out.println(employees[i]);
                count++;
            }
        }
        if (count == 0) {
            System.out.printf("Сотрудников с зарплатой меньше %d нет %n", number);
        }
    }

    public void printEmployeesNames(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (Objects.nonNull(employees[i])) {
                System.out.printf("%s %s %s %n", employees[i].getLastName(), employees[i].getFirstName(),
                        employees[i].getMiddleName());
            }
        }
    }

    public void printEmployeesNames() {
        printEmployeesNames(employees);
    }

    public double findAverageSalaryByDepartment(String department) {
        return findAverageSalary(findEmployeesByDepartment(department));
    }

    public Employee[] findEmployeesByDepartment(String department) {
        Employee[] byDepartment = new Employee[employees.length];
        int j = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (Objects.equals(employees[i].getDepartment(), department)) {
                byDepartment[j++] = employees[i];
            }
        }
        return byDepartment;
    }

    public Object findEmployeeWithMinSalarybyDepartment(String department) {
        Employee[] employeesByDepartment = findEmployeesByDepartment(department);
        return findEmployeeWithMinSalary(employeesByDepartment);
    }

    public Object findEmployeeWithMaxSalarybyDepartment(String department) {
        Employee[] employeesByDepartment = findEmployeesByDepartment(department);
        return findEmployeeWithMaxSalary(employeesByDepartment);
    }

    public void printEmployees(Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            System.out.println(employees[i]);
        }
    }

    public void printEmployees() {
        printEmployees(employees);
    }

    public int calculateSalarySum(Employee[] employees) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public int calculateSalarySum() {
        return calculateSalarySum(employees);
    }

    public Object findEmployeeWithMinSalary(Employee[] employees) {
        int minSalary = Integer.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.nonNull(employees[i]) && employees[i].getSalary() <= minSalary) {
                minSalary = employees[i].getSalary();
                employeeWithMinSalary = employees[i];
            }
        }
        return employeeWithMinSalary;
    }

    public Object findEmployeeWithMinSalary() {
        return findEmployeeWithMinSalary(employees);
    }

    public Object findEmployeeWithMaxSalary(Employee[] employees) {
        int maxSalary = Integer.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.nonNull(employees[i]) && employees[i].getSalary() >= maxSalary) {
                maxSalary = employees[i].getSalary();
                employeeWithMaxSalary = employees[i];
            }
        }
        return employeeWithMaxSalary;
    }

    public Object findEmployeeWithMaxSalary() {
        return findEmployeeWithMaxSalary(employees);
    }

    public double findAverageSalary(Employee[] employees) {
        double averageSalary = Math.round(((double) calculateSalarySum(employees) / findEmployeeCount()) * 100.0) / 100.0;
        return averageSalary;
    }

    public double findAverageSalary() {
        return findAverageSalary(employees);
    }

    public int findEmployeeCount() {
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null) {
                counter++;
            }
        }
        return counter;
    }

    public void indexSalary(Employee[] employees, double percent) {
        percent = Math.round(percent / 100.0 * 100.0) / 100.0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            employees[i].setSalary(
                    (int) (employees[i].getSalary() + employees[i].getSalary() * percent));
        }
    }

    public void indexSalary(double percent) {
        indexSalary(employees, percent);
    }

    public Object findEmployeeByID(int id) {
        int employeeIndex = findEmployeeIndexByID(id);
        if (employeeIndex > 0) {
            return employees[employeeIndex];
        }
        return null;
    }
}
