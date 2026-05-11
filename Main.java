package Assigenment;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Raghad Ghazi Abusamra      ID : 202510758 ");
         Subject t1 = new Subject("english", "555");
        Subject t2 = new Subject("math", "111");
        Subject t3 = new Subject("physics", "222");
        Subject t4 = new Subject("java", "333");
        Subject t5 = new Subject("oop", "444");
        Student s1 = new Student("hiba", "1", 17, new Subject[]{t1, t2, t3, t4});
        Student s2 = new Student("masa", "2", 18, new Subject[]{t1, t2 ,t3, t5});
        Student s3 = new Student("leen", "3", 19, new Subject[]{t4,t2, t3, t5});
        Student s4 = new Student("raghad", "4", 20, new Subject[]{t3, t2, t1, t5});
        Student s5 = new Student("rahaf", "5", 19, new Subject[]{t4, t2, t3, t5});

        printByAge(s1, s2, s3);

        Student[] sss = {s1, s2, s3, s4, s5};
        
       Student[] successfulstudents= SuccessfulStudents(sss);
        System.out.println("Successful Students are:");
        for (Student x : successfulstudents) {
            System.out.println(x);
        }
        
        
        
        Subject[] sharedsubject=SharedSubject(sss);
        System.out.println("Shared Subject are:");
        for (Subject x : sharedsubject) {
            System.out.println(x);
        }
        
        
        String[] fullmarkIds=FullMarkIds(sss);
        System.out.println("fullmaark id are:");
        for (String x : fullmarkIds) {
            System.out.println(x);
        }
        
    }
    
//METHOD 1
    public static void printByAge(Student s1, Student s2, Student s3) {
        Student min;
        Student mid;
        Student max;
        if (s1.getAge() > s2.getAge() && s1.getAge() > s3.getAge()) {
            max = s1;
        } else if (s2.getAge() > s1.getAge() && s2.getAge() > s3.getAge()) {
            max = s2;
        } else {
            max = s3;
        }

        if (s1.getAge() < s2.getAge() && s1.getAge() < s3.getAge()) {
            min = s1;
        } else if (s2.getAge() < s1.getAge() && s2.getAge() < s3.getAge()) {
            min = s2;
        } else {
            min = s3;
        }

        if (s1 != min && s1 != max) {
            mid = s1;
        } else if (s2 != min && s2 != max) {
            mid = s2;
        } else {
            mid = s3;
        }

        System.out.println("min: " + min.toString());
        System.out.println("mid: " + mid.toString());
        System.out.println("max: " + max.toString());

    }

    
   //METHOD 2 
    public static Student[] SuccessfulStudents(Student[] arr) {
        int counterSize = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].calculateAvg() >= 60) {
                counterSize++;
            }
        }
        Student[] SuccessfulStudents = new Student[counterSize];
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].calculateAvg() >= 60) {
                SuccessfulStudents[c] = arr[i];
                c++;
            }
        }

        return SuccessfulStudents;
    }
    
    
//METHOD 3
    public static Subject[] SharedSubject(Student[] arr) {
        Subject[] SharedSubject=null;
        int countersize=0;
        Subject[] x = arr[0].getSs();
        boolean Shared;
        for (int i = 0; i < x.length; i++) {
            Shared=true;
            for (int j = 0; j < arr.length; j++) {
                boolean g=false;
                for (int k = 0; k <arr[j].getSs().length; k++) {
                    if(x[i].getSubjectId().equals(arr[j].getSs()[k].getSubjectId())){
                        g=true;
                        break;
                    }
                }
                if(g==false){
                    Shared=false;
                    break;
                }
            }
            if(Shared==true){
                countersize++;
            }
            
        }
        
            int c=0;
            SharedSubject=new Subject[countersize];
            for (int i = 0; i < x.length; i++) {
            Shared=true;
            for (int j = 0; j < arr.length; j++) {
                boolean g=false;
                for (int k = 0; k <arr[j].getSs().length; k++) {
                    if(x[i].getSubjectId().equals(arr[j].getSs()[k].getSubjectId())){
                        g=true;
                        break;
                    }
                }
                if(g==false){
                    Shared=false;
                    break;
                }
            }
            if(Shared==true){
                SharedSubject[c]=new Subject(x[i].getName(),x[i].getSubjectId());
                c++;
            }
            
        }
        return SharedSubject;
        
    }
    
    
    //METHOD 4
    public static String[] FullMarkIds(Student[] arr) {
        int countersize = 0;
        for (int i = 0; i < arr.length; i++) {
            Subject[] sub = arr[i].getSs();
            for (int j = 0; j < sub.length; j++) {
                if (sub[j].getMark() == 100) {
                    countersize++;
                    break;
                }
            }
        }
        String[] FullMarkIds = new String[countersize];
        int c = 0;
        for (int i = 0; i < arr.length; i++) {
            Subject[] sub = arr[i].getSs();
            for (int j = 0; j < sub.length; j++) {
                if (sub[j].getMark() == 100) {
                    FullMarkIds[c] = arr[i].getStudentId();
                    c++;
                    break;
                }
            }
        }
        return FullMarkIds;

    }

}
