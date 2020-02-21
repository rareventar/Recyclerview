package com.stratpoint.android;
import java.util.ArrayList;
public class WarmUpExercise {

    public static void main(String[] args){
        String word = "";
        Student ramon = new Student();
        Student mayque = new Student();
        ArrayList<Student> list = new ArrayList<Student>();
        ramon.setName("ramon");
        ramon.setAge(10);
        mayque.setName("mayque");
        mayque.setAge(22);
        list.add(ramon);
        list.add(mayque);
        // System.out.println("b".compareTo("a"));
        ramon.sortStudentListByAge(list);
        word = "Stella won no wallets";
        palindrome(word);
        prime(2);
    }
    public static void palindrome(String word){
        word  = word.replaceAll("\\s", "");
        word = word.toLowerCase();
        String splitted[] = word.split("");
        int length  = splitted.length;
        String reverse = "";
        for(int i = length-1; i >= 0; i--){
            reverse = reverse + splitted[i];
        }
        if (word.equals(reverse)){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not");
        }
    }

    public static void prime(int num){
        boolean temp = false;
        for(int i = 2; i <= num/2; i++){
            if(num%i == 0){
                temp = true;
                break;
            }
        }
        if(temp == true){
            System.out.println("Composite");
        }else{
            System.out.println("Prime");
        }
    }
}
