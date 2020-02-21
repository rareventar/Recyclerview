package com.stratpoint.android;

import java.util.ArrayList;

public class Student {
    private String name;
    private int age;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    // Complete the function
    // a compare b negative before; positive after
    public void sortStudentListByName(ArrayList<Student> students){
        // TODO
        ArrayList<Student> temp = new ArrayList<Student>();
        int flag;
        while(students.size() > 0){
            flag = 0;
            for(int i = 0; i < students.size(); i++){
                if(students.get(flag).getName().compareTo(students.get(i).getName()) > 0){
                    flag = i;
                }
            }
            temp.add(students.remove(flag));
        }
        //temp = sorted a-z

    }
    // Complete the function
    public void sortStudentListByAge(ArrayList<Student> students){
        // TODO
        ArrayList<Student> temp = new ArrayList<Student>();
        int flag;
        while(students.size() > 0){
            flag = 0;
            for(int i = 0; i < students.size(); i++){
                if(students.get(flag).getAge() > students.get(i).getAge()){
                    flag = i;
                }
            }
            temp.add(students.remove(flag));
        }
        //temp sorted 0-1
    }
}
