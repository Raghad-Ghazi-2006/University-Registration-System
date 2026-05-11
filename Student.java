package Assigenment;

import java.util.Arrays;
import java.util.Scanner;

public class Student {

    private String name;
    private String studentId;
    private int age;
    private Subject[] ss;

    public Student() {
    }

    public Student(String name, String studentId, int age, Subject[] ss) {
        setName(name);
        setStudentId(studentId);
        setAge(age);
        setSs(ss);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        } else {
             Scanner input = new Scanner(System.in);
            while (true) {
               
                System.out.println("Invalid name enter another valid name");
                String x = input.nextLine();
                if(x != null && !x.isEmpty()){
                    this.name = x;
                break;}
              
            }
        }

    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        if (studentId != null && !studentId.isEmpty()) {
            this.studentId = studentId;
        } else {
             Scanner input = new Scanner(System.in);
            while (true) {
               
                System.out.println("Invalid id enter another valid id");
                String x = input.next();
                if(x != null && !x.isEmpty()){
                    this.studentId = x;
                break;}
              
            }
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age >= 17) {
            this.age = age;
        } else {
             Scanner input = new Scanner(System.in);
            while (true) {
               
                System.out.println("Invalid age enter another valid age");
                int x = input.nextInt();
                if (x >= 17) {
                    this.age = x;
                break;}
              
            }
        }
    }

    public Subject[] getSs() {
        return ss;
    }


    public void setSs(Subject[] ss) {
        Scanner input = new Scanner(System.in);
        if (ss.length >= 4&& ss!=null) {
            this.ss = new Subject[ss.length];
            for (int i = 0; i < ss.length; i++) {
                System.out.println("enter mark of " + ss[i].getName() + "  for student " + name);
                double mark = input.nextDouble();
                this.ss[i] = new Subject(ss[i].getName(), ss[i].getSubjectId(), mark);
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", studentId=" + studentId + ", age=" + age + ", ss=" + Arrays.toString(ss) + '}';
    }

    public double calculateAvg() {
        if (ss == null || ss.length == 0) {
            return 0;
        }

        double sum = 0;
        for (int i = 0; i < ss.length; i++) {
            sum += ss[i].getMark();
        }
        return sum / ss.length;
    }

}
