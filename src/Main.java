import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        // Creating a list of Employee objects
        List<Employee> employees = new ArrayList<>();

        // Adding dummy Employee data
        employees.add(new Employee("Alice", 25, "HR", 50000.0, Arrays.asList("Communication", "Recruitment"), "New York", "Female"));
        employees.add(new Employee("Bob", 30, "IT", 75000.0, Arrays.asList("Java", "Spring", "SQL"), "San Francisco", "Male"));
        employees.add(new Employee("Charlie", 35, "Finance", 60000.0, Arrays.asList("Accounting", "Excel"), "Chicago", "Male"));
        employees.add(new Employee("David", 28, "Marketing", 45000.0, Arrays.asList("SEO", "Content Creation"), "Los Angeles", "Male"));
        employees.add(new Employee("Eve", 22, "IT", 70000.0, Arrays.asList("Python", "Machine Learning"), "Seattle", "Female"));
        employees.add(new Employee("Frank", 40, "Admin", 40000.0, Arrays.asList("Management", "Organization"), "New York", "Male"));
        employees.add(new Employee("Grace", 29, "HR", 55000.0, Arrays.asList("Recruitment", "Training"), "Austin", "Female"));
        employees.add(new Employee("Hank", 33, "Production", 65000.0, Arrays.asList("Inventory Management", "Assembly Line"), "Houston", "Male"));
        employees.add(new Employee("Ivy", 27, "Sales", 47000.0, Arrays.asList("Salesforce", "Client Handling"), "Denver", "Female"));
        employees.add(new Employee("John", 31, "IT", 90000.0, Arrays.asList("Cloud Computing", "Docker", "Kubernetes"), "San Jose", "Male"));
        employees.add(new Employee("Karen", 26, "Finance", 58000.0, Arrays.asList("Auditing", "Taxation"), "Chicago", "Female"));
        employees.add(new Employee("Leo", 34, "Marketing", 48000.0, Arrays.asList("Brand Management", "Photography"), "Los Angeles", "Male"));
        employees.add(new Employee("Mona", 24, "Design", 55000.0, Arrays.asList("Graphic Design", "Adobe Creative Suite"), "Denver", "Female"));
        employees.add(new Employee("Nick", 37, "Operations", 64000.0, Arrays.asList("Logistics", "Team Management"), "Dallas", "Male"));
        employees.add(new Employee("Olivia", 23, "IT", 70000.0, Arrays.asList("Web Development", "ReactJS", "NodeJS"), "Seattle", "Female"));
        employees.add(new Employee("Peter", 32, "Production", 66000.0, Arrays.asList("Production", "Quality Control"), "Houston", "Male"));

        // get List of Employee name
        // map()
        List<String> listOfEmpNames = employees.stream().map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("List of Employee Names: " + listOfEmpNames);

        // get list of departments
        // map(), distinct()
        List<String> listOfDepartments = employees.stream().map(Employee::getDepartment)
                .distinct()
                .collect(Collectors.toList());
        System.out.println("List of Deprtments: " + listOfDepartments);

        // get list of employess with age less than 30
        // filter(), toMa()
        Map<String, Integer> employeesAgeLessThan30 = employees.stream()
                .filter(e -> e.getAge() < 30)
                .collect(Collectors.toMap(Employee::getName, Employee::getAge));
        System.out.println("Employees with age less than 30: " + employeesAgeLessThan30);

        // calculate average age of employees
        double averageAge = employees.stream().mapToInt(Employee::getAge)
                .average().orElseThrow(() -> new RuntimeException("No employees found"));
        System.out.println("Average Age of Employees: " + averageAge);

        // find 3rd highest salary
        Double thirdHighestSalary = employees.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(2)
                .findFirst()
                .get();
        System.out.println("3rd highest salary: " + thirdHighestSalary);

        // list employess whose salary in between 55000 to 75000
        List<String> employeeSalaryRange = employees.stream()
                .filter(e -> e.getSalary() >= 55000 && e.getSalary() <= 75000)
                .map(e -> e.getName() + " : " + e.getSalary())
                .collect(Collectors.toList());
        System.out.println("Employees whose salary in between 55000 to 75000: " + employeeSalaryRange);

        // group employess based on department
        Map<String, List<String>> groupByDepartment = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Group Employees based on Department: " + groupByDepartment);

        // group emloyees based on salary and return map with salary as key and list of employee name as value
        Map<Double, List<String>> groupBySalary = employees.stream()
                .collect(Collectors.groupingBy(Employee::getSalary, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("Group Employees based on Salary: " + groupBySalary);

        // find List of all employees name with third-highest salary
        Map.Entry<Double, List<String>> collect = groupBySalary.entrySet().stream()
                .sorted(Map.Entry.<Double, List<String>>comparingByKey().reversed())
                .skip(2)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No third-highest salary found"));
        System.out.println("List of all employees name with third-highest salary: " + collect);

        // Another way to find List of employees with third-Highest salary
        List<String> collect1 = employees.stream()
                .filter(e -> Objects.equals(e.getSalary(), thirdHighestSalary))
                .map(Employee::getName)
                .collect(Collectors.toList());
        System.out.println("List of employees with third-Highest salary: " + collect1);

    }
}

