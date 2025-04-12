import java.util.List;
public class Employee {
    String name;
    Integer age;
    String department;
    Double salary;
    List<String> skills;
    String city;
    String gender;
    public Employee(String name, Integer age, String department, Double salary, List<String> skills, String city, String gender) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
        this.skills = skills;
        this.city = city;
        this.gender = gender;
    }

    public Double getSalary() {
        return salary;
    }

    public Integer getAge() {
        return age;
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getCity() {
        return city;
    }
    public String getGender() {
        return gender;
    }
    public String getName() {
        return name;
    }
    public String getDepartment() {
        return department;
    }

}
