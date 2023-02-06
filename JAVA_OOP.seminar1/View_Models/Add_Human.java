package JAVA_OOP.seminar1.View_Models;

import java.util.ArrayList;
import java.util.Scanner;

import JAVA_OOP.seminar1.View;

public class Add_Human {

    public ArrayList<String> add_human(View v) {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list1 = new ArrayList<>();
        System.out.println("Создается новый объект с ID "+(v.presenter.my_tree.getMax_id()+1)+" : ");
        list1.add(String.valueOf(v.presenter.my_tree.getMax_id()+1));
        System.out.print("Введите имя : ");
        String first_name = scan.nextLine(); 
        list1.add(first_name);
        System.out.print("Введите фамилию : ");
        String last_name = scan.nextLine(); 
        list1.add(last_name);
        int birth_year = v.my_input("Введите год рождения : ",0,2023);
        list1.add(String.valueOf(birth_year));
        if (v.my_input("Введите пол (1-мужской/0-женский): ",0,1)==1) 
            list1.add("1");
        else 
            list1.add("0");
        int id_father = v.my_input("Введите ID отца (0 - отсутствует) : ",
            0,v.presenter.my_tree.getMax_id());
        list1.add(String.valueOf(id_father));
        int id_mother = v.my_input("Введите ID матери (0 - отсутствует) : ",
            0,v.presenter.my_tree.getMax_id());
        list1.add(String.valueOf(id_mother));
        int id_married = v.my_input("Введите ID cупруга/супруги (0 - отсутствует) : ",
            0,v.presenter.my_tree.getMax_id());
        list1.add(String.valueOf(id_married)); 
        return list1;
        
    }
    
}