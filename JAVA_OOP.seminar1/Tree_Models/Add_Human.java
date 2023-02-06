package JAVA_OOP.seminar1.Tree_Models;

import java.util.ArrayList;

import JAVA_OOP.seminar1.Human;

public class Add_Human<T extends Human> {

    public T add_human(ArrayList<String> list1) {

        T human = (T) new Human();
        human.setId(Integer.parseInt(list1.get(0)));
        human.setFirst_name(list1.get(1));
        human.setLast_name(list1.get(2));
        human.setBirth_year(Integer.parseInt(list1.get(3)));
        if (list1.get(4).equals("1")) 
            human.setMan(true);
        else 
            human.setMan(false);
        human.setId_father(Integer.parseInt(list1.get(5)));
        human.setId_mother(Integer.parseInt(list1.get(6)));
        human.setId_married(Integer.parseInt(list1.get(7))); 

        return human;
        
    }


    
}