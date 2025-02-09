package org.example;

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
        if (employeeIndex >= 0) {
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

    public void printEmployeesNamesByDep(String department) {
        for (int i = 0; i < employees.length; i++) {
            if (Objects.nonNull(employees[i]) && employees[i].getDepartment().equals(department)) {
                System.out.printf("%s %s %s %n", employees[i].getLastName(), employees[i].getFirstName(),
                        employees[i].getMiddleName());
            }
        }
    }

    public void printEmployeesNames() {
        for (int i = 0; i < employees.length; i++) {
            if (Objects.nonNull(employees[i])) {
                System.out.printf("%s %s %s %n", employees[i].getLastName(), employees[i].getFirstName(),
                        employees[i].getMiddleName());
            }
        }
    }

    public double findAverageSalaryByDepartment(String department) {
        return Math.round(((double) calculateSalarySumByDep(department) / findEmployeeCountByDep(department)) * 100.0) / 100.0;
    }

    public Object findEmployeeWithMinSalarybyDepartment(String department) {
        int minSalary = Integer.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.nonNull(employees[i]) &&
                    employees[i].getDepartment().equals(department) &&
                    employees[i].getSalary() <= minSalary) {
                minSalary = employees[i].getSalary();
                employeeWithMinSalary = employees[i];
            }
        }
        return employeeWithMinSalary;
    }

    public Object findEmployeeWithMaxSalarybyDepartment(String department) {
        int maxSalary = Integer.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.nonNull(employees[i]) &&
                    employees[i].getDepartment().equals(department) &&
                    employees[i].getSalary() >= maxSalary) {
                maxSalary = employees[i].getSalary();
                employeeWithMaxSalary = employees[i];
            }
        }
        return employeeWithMaxSalary;
    }

    public Object findEmployeeWithMinSalary() {
        int minSalary = Integer.MAX_VALUE;
        Employee employeeWithMinSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.nonNull(employees[i]) &&
                    employees[i].getSalary() <= minSalary) {
                minSalary = employees[i].getSalary();
                employeeWithMinSalary = employees[i];
            }
        }
        return employeeWithMinSalary;
    }

    public Object findEmployeeWithMaxSalary() {
        int maxSalary = Integer.MIN_VALUE;
        Employee employeeWithMaxSalary = null;
        for (int i = 0; i < employees.length; i++) {
            if (Objects.nonNull(employees[i]) &&
                   employees[i].getSalary() >= maxSalary) {
                maxSalary = employees[i].getSalary();
                employeeWithMaxSalary = employees[i];
            }
        }
        return employeeWithMaxSalary;
    }

    public void printEmployees() {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            System.out.println(employees[i]);
        }
    }

    public void printEmployeesByDep(String department) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getDepartment().equals(department)) {
                System.out.println(employees[i]);
            }
        }
    }

    public int calculateSalarySum() {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            sum += employees[i].getSalary();
        }
        return sum;
    }

    public int calculateSalarySumByDep(String department) {
        int sum = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getDepartment().equals(department)) {
                sum += employees[i].getSalary();
            }
        }
        return sum;
    }

    public double findAverageSalary() {
        return Math.round(((double) calculateSalarySum() / findEmployeeCount()) * 100.0) / 100.0;
    }

    public int findEmployeeCountByDep(String department) {
        int counter = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] != null && Objects.equals(employees[i].getDepartment(), department)) {
                counter++;
            }
        }
        return counter;
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

    public void indexSalary(String department, double percent) {
        percent = Math.round(percent / 100.0 * 100.0) / 100.0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            if (employees[i].getDepartment().equals(department)) {
                employees[i].setSalary(
                        (int) (employees[i].getSalary() + employees[i].getSalary() * percent));
            }
        }
    }

    public void indexSalary(double percent) {
        percent = Math.round(percent / 100.0 * 100.0) / 100.0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) continue;
            employees[i].setSalary(
                    (int) (employees[i].getSalary() + employees[i].getSalary() * percent));
        }
    }

    public Object findEmployeeByID(int id) {
        int employeeIndex = findEmployeeIndexByID(id);
        if (employeeIndex > 0) {
            return employees[employeeIndex];
        }
        return null;
    }
}
