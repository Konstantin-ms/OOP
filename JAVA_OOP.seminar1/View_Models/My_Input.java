package JAVA_OOP.seminar1.View_Models;

import java.util.Scanner;

public class My_Input {

public int my_input(String str, int n1, int n2) {
    int inp = 0;
    boolean test = true;
    Scanner scan = new Scanner(System.in);

    while (test) {
        System.out.print(str);
        try { inp = scan.nextInt();test = false;} 
        catch (Exception e) { 
            System.out.println("Вы ввели не число, попробуйте еще раз.");
            scan = new Scanner(System.in);
        }
        if (!test)   { 
            if (inp>=n1&&inp<=n2) 
                test = false;
            else {
                test = true; 
                System.out.println("Число от "+n1+" до "+n2+". попробуйте еще раз.");}}}
    return inp;
    
}
    
}