import java.util.*;
import java.util.stream.*;

public class EmployeeMain{

public static void main(String args[]){

EmployeeQueriesUsingStream employeeQueries=new EmployeeQueriesUsingStream();

//Get male and female employees
employeeQueries.maleAndFemaleCount();

//Get all the departments
employeeQueries.getAllDepartments();

//Get average age of Employees
employeeQueries.getAverageAge();

//Get highest paid Employee
employeeQueries.getHighestPaidEmployee();

//Get the names of all employees who joined after 2015
employeeQueries.getEmployeesJoinedAfter2015();

//Get the number of employees in each department
employeeQueries.getNoOfEmployeesInEachDept();

//Get average salary of each department
employeeQueries.getAvgSalaryOfEachDept();

//Get the details of youngest male employee in the product development department
employeeQueries.getYoungestMaleEmployee();

//Get the most working experience in the organization
employeeQueries.getMostExpInOrg();

//Get male and female employees in the sales and marketing team
employeeQueries.getMandFInSalesAndMarketing();

//Get the average salary of male and female employees
employeeQueries.getAvgSalaryOfMAndFEmp();

//Get the names of all employees in each department
employeeQueries.getAllNamesOfEmpInEachDept();

//Get the average salary and total salary of the whole organization
employeeQueries.getAvgAndTotalSalary();

//Get the employees who are younger or equal to 25 years from those employees who are older than 25 years.
employeeQueries.getEmpYoungerAndOlderThan25();

//Get the oldest employee in the organization
employeeQueries.getOldestEmpInOrg();

}
}











