package Assigenment;

import java.util.Scanner;

public class Subject {

    private String name;
    private String SubjectId;
    private double mark;

    public Subject() {
    }

    public Subject(String name, String SubjectId) {
        setName(name);
        setSubjectId(SubjectId);

    }

    public Subject(String name, String SubjectId, double mark) {
        setName(name);
        setSubjectId(SubjectId);
        setMark(mark);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }else {
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

    public String getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(String SubjectId) {
        if (SubjectId != null && !SubjectId.isEmpty()) {
            this.SubjectId = SubjectId;
        } else {
            Scanner input = new Scanner(System.in);
            while (true) {

                System.out.println("Invalid id enter another valid id");
                String x = input.next();
                if (x != null && !x.isEmpty()) {
                    this.SubjectId = x;
                    break;
                }

            }
        }
    }

    public double getMark() {
        return mark;
    }

    public void setMark(double mark) {
        if (mark >= 0 && mark <= 100) {
            this.mark = mark;
        } else {
             Scanner input = new Scanner(System.in);
            while (true) {
               
                System.out.println("Invalid mark enter another valid mark");
                double x = input.nextDouble();
                if (x >= 0 && x <= 100) {
                    this.mark = x;
                break;}
              
            }
        }
    }

    @Override
    public String toString() {
        return "Subject{" + "name=" + name + ", SubjectId=" + SubjectId + ", mark=" + mark + '}';
    }

}
