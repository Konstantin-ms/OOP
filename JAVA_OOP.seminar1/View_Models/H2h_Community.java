package JAVA_OOP.seminar1.View_Models;

import JAVA_OOP.seminar1.View;

public class H2h_Community {

    public int[] h2h_Community(View v) {
        int[] id = new int[2];
        boolean test = true;
        System.out.println();
        id[0] = v.my_input("\nВведите ID исследуемого человека : ",
        1,v.presenter.my_tree.getMax_id());
        while (test) {
            test = false;
            id[1] = v.my_input("Введите ID для установления степени родства : ",
            1,v.presenter.my_tree.getMax_id());
            if (id[1]==id[0])
                {System.out.println("Введите другого человека.");
                test = true;}}        
        return id;
        
    }
    
}
