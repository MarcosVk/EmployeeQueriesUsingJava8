import java.util.*;
import java.util.stream.*;

public class Employee{
	int id;
	String name;
	int age;
	String gender;
	String department;
	int yearOfJoining;
	double salary;

	public Employee(int id,String name,int age,String gender,String department,int yearOfJoining,double salary){
	this.id=id;
	this.name=name;
	this.age=age;
	this.gender=gender;
	this.department=department;
	this.yearOfJoining=yearOfJoining;
	this.salary=salary;
	
}
public int getId(){
	return id;
}
public String getName(){
	return name;
}
public int getAge(){
	return age;
}
public String getGender(){
	return gender;
}
public String getDepartment(){
	return department;
}
public int getYearOfJoining(){
	return yearOfJoining;
}
public double getSalary(){
	return salary;
}
@Override
public String toString(){
	return "Id : "+id+
		", name : "+name+
		", age : "+age+
		", gender : "+gender+
		", department : "+department+
		", year of joining : "+yearOfJoining+
		", salary : "+salary;
}


public static void main(String args[]){

//List of Employees
List<Employee> employeeList=new ArrayList<>();

employeeList.add(new Employee(1,"Vicky",23,"Male","Dev",2022,23800.00));
employeeList.add(new Employee(2,"Dhanush",22,"Male","Sales And Marketing",2024,25000.00));
employeeList.add(new Employee(3,"Mithun",25,"Male","Account and Finance",2020,21000.00));
employeeList.add(new Employee(4,"Robin",21,"Female","HR",2024,28000.00));
employeeList.add(new Employee(5,"Easwar",24,"Male","Hardware",2024,38000.00));
employeeList.add(new Employee(6,"Brein",32,"Female","Product Development",2011,25000.00));
employeeList.add(new Employee(7,"Saravana",27,"Male","Civil",2019,29000.00));
employeeList.add(new Employee(8,"Karthi",28,"Male","HR",2019,30000.99));
employeeList.add(new Employee(9,"Ajay",25,"Female","Networking",2022,32000.00));
employeeList.add(new Employee(10,"Syndey",22,"Female","Product Development",2022,32000.00));
employeeList.add(new Employee(11,"Nima Roy",27,"Female","HR",2013,22700.00));
employeeList.add(new Employee(12,"Sam",27,"Male","Product Development",2018,27400.00));
employeeList.add(new Employee(13,"Jim",23,"Male","Product Development",2025,23400.00));
employeeList.add(new Employee(14,"Suji",20,"Female","Sales And Marketing",2025,22000.00));
employeeList.add(new Employee(15,"Shelly",23,"Female","Sales And Marketing",2024,25000.00));

//Get male and female employees
Map<String,Long> noOfMaleAndFemaleEmployees=employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
System.out.println(noOfMaleAndFemaleEmployees);
System.out.println("-----------------------------------------");

//Get all the departments
employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);
System.out.println("-----------------------------------------");

//Get average age of Employees
Map<String,Double> avgAgeOfEmployees=employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,Collectors.averagingInt(Employee::getAge)));
System.out.println(avgAgeOfEmployees);
System.out.println("-----------------------------------------");

//Get highest paid Employee
Optional<Employee> highestPaidEmployeeOptional=employeeList.stream().collect(Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary)));
Employee highestPaidEmployee=highestPaidEmployeeOptional.get();
System.out.println("Details of highest paid Employee");
System.out.println("-----------------------------------------");

System.out.println("Id : "+highestPaidEmployee.getId());
System.out.println("Name : "+highestPaidEmployee.getName());
System.out.println("Age : "+highestPaidEmployee.getAge());
System.out.println("Gender : "+highestPaidEmployee.getGender());
System.out.println("Department : "+highestPaidEmployee.getDepartment());
System.out.println("Year of Joining : "+highestPaidEmployee.getYearOfJoining());
System.out.println("Salary : "+highestPaidEmployee.getSalary());
System.out.println("-----------------------------------------");

//Get the names of all employees who joined after 2015
employeeList.stream().filter(e->e.getYearOfJoining() > 2015).map(Employee::getName).forEach(System.out::println);
System.out.println("-----------------------------------------");

//Get the number of employees in each department?
Map<String,Long> employeeCountByDepartment=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.counting()));

Set<Map.Entry<String,Long>> entrySet=employeeCountByDepartment.entrySet();

for(Map.Entry<String,Long> entry:entrySet){
System.out.println(entry.getKey()+" : "+entry.getValue());
}
System.out.println("-----------------------------------------");

//Get average salary of each department?
Map<String,Double> averageSalary=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment,Collectors.averagingDouble(Employee::getSalary)));
Set<Map.Entry<String,Double>> salaryEntrySet=averageSalary.entrySet();
for(Map.Entry<String,Double> entry:salaryEntrySet){
	System.out.println(entry.getKey()+" : "+entry.getValue());
}
System.out.println("-----------------------------------------");

//Get the details of youngest male employee in the product development department

Optional<Employee> youngestMaleEmployeeOptional=employeeList.stream().filter(e->e.getGender()=="Male" && e.getDepartment()=="Product Development").min(Comparator.comparingInt(Employee::getAge));
Employee youngestMaleEmployee=youngestMaleEmployeeOptional.get();
System.out.println("Details of youngest male employee in the product development department");
System.out.println("-----------------------------------------");

System.out.println("Id : "+youngestMaleEmployee.getId());
System.out.println("Name : "+youngestMaleEmployee.getName());
System.out.println("Age : "+youngestMaleEmployee.getAge());
System.out.println("Gender : "+youngestMaleEmployee.getGender());
System.out.println("Department : "+youngestMaleEmployee.getDepartment());
System.out.println("Year of Joining : "+youngestMaleEmployee.getYearOfJoining());
System.out.println("Salary : "+youngestMaleEmployee.getSalary());
System.out.println("-----------------------------------------");

//Get the most working experience in the organization
Optional<Employee> mostWorkingExpOptional=employeeList.stream().sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
Employee mostWorkingExp=mostWorkingExpOptional.get();
System.out.println("Details of most working experience employee in the organization");
System.out.println("-----------------------------------------");

System.out.println("Id : "+mostWorkingExp.getId());
System.out.println("Name : "+mostWorkingExp.getName());
System.out.println("Age : "+mostWorkingExp.getAge());
System.out.println("Gender : "+mostWorkingExp.getGender());
System.out.println("Department : "+mostWorkingExp.getDepartment());
System.out.println("Year of Joining : "+mostWorkingExp.getYearOfJoining());
System.out.println("Salary : "+mostWorkingExp.getSalary());
System.out.println("-----------------------------------------");

//Get male and female employees in the sales and marketing team

Map<String,Long> employeesInSalesAndMarketing=employeeList.stream().filter(e->e.getDepartment()=="Sales And Marketing").collect(Collectors.groupingBy(Employee::getGender,Collectors.counting()));
System.out.println(employeesInSalesAndMarketing);
System.out.println("-----------------------------------------");

//Get the average salary of male and female employees

Map<String,Double>averageSalaryOfMaleAndFemaleEmp=employeeList.stream().collect(Collectors.groupingBy(Employee::getGender,
Collectors.averagingDouble(Employee::getSalary)));
System.out.println(averageSalaryOfMaleAndFemaleEmp);
System.out.println("-----------------------------------------");

//Get the names of all employees in each department
Map<String,List<Employee>> namesOfAllEmployeeInEachDepartment=employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
Set<Map.Entry<String,List<Employee>>> entrySetNamesOfAllEmployee=namesOfAllEmployeeInEachDepartment.entrySet();

for(Map.Entry<String,List<Employee>> entry:entrySetNamesOfAllEmployee){
System.out.println("Employees in "+entry.getKey()+":");

List<Employee> empList=entry.getValue();

for(Employee emp:empList){
System.out.println(emp.getName());
}
System.out.println("-----------------------------------------");
}

//Get the average salary and total salary of the whole organization
DoubleSummaryStatistics averageAndTotalSalary=employeeList.stream().collect(Collectors.summarizingDouble(Employee::getSalary));
System.out.println("Average salary : "+averageAndTotalSalary.getAverage());
System.out.println("Total salary : "+averageAndTotalSalary.getSum());
System.out.println("-----------------------------------------");

//Get the employees who are younger or equal to 25 years from those employees who are older than 25 years.
Map<Boolean,List<Employee>> youngerEmployees=employeeList.stream().collect(Collectors.partitioningBy(e->e.getAge() < 25));

Set<Map.Entry<Boolean,List<Employee>>> youngerEmployeesEntrySet=youngerEmployees.entrySet();

for(Map.Entry<Boolean,List<Employee>> entry:youngerEmployeesEntrySet){
System.out.println("-----------------------------------------");
if(entry.getKey()){
 System.out.println("Employees younger than age 25 :");
}else{
 System.out.println("Employees older than age 25 :");
}
List<Employee> list=entry.getValue();

for(Employee e:list){
System.out.println(e.getName());
}
}
System.out.println("-----------------------------------------");

//Get the oldest employee in the organization
Optional<Employee> oldestEmployeeOptional=employeeList.stream().max(Comparator.comparingInt(Employee::getAge));
Employee oldestEmployee=oldestEmployeeOptional.get();

System.out.println("Details of oldest employee in the organization");
System.out.println("-----------------------------------------");

System.out.println("Name : "+oldestEmployee.getName());
System.out.println("Age : "+oldestEmployee.getAge());
System.out.println("Department : "+oldestEmployee.getDepartment());
System.out.println("-----------------------------------------");

}
}











