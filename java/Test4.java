import java.util.ArrayList; 
import java.util.Scanner;

public class Test4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> empList = new ArrayList<>();
        int opt = 0;
        while(opt != 2){
            System.out.println("1.Add Emp \n2.Exit\n");
            opt = sc.nextInt();
            switch (opt) {
                case 1:
                    int id, age;
                    String name, phno;
                    id = sc.nextInt();
                    name = sc.next();
                    phno = sc.next();
                    age = sc.nextInt();
                    empList.add(new Employee(id, name, phno, age));
                    break;
                case 2:
                    break;
                default:
                    System.out.println("Please enter valid option");
            }
        }
        System.out.println("Enter the Emp id to display: ");
        opt = sc.nextInt();
        for(Employee emp : empList){
            if(emp.id == opt){
                emp.displayDetails();
                break;
            }
        }
        sc.close();
    }
}

class Employee {
    public int id, age;
    public String name, phno;

    public Employee(){}
    public Employee(int id, String name, String phno, int age){
        this.id = id;
        this.name = name;
        this.phno = phno;
        this.age = age;
    }

    public void displayDetails(){
        System.out.println(id + "\n" + name + "\n" + phno + "\n" + age);
    }
}

