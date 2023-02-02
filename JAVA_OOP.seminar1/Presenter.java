package JAVA_OOP.seminar1;

import java.util.ArrayList;

public class Presenter {
    Tree<Human> my_tree = new Tree<>();
    View view = new View(this);

    void PressButton() {
        // ArrayList<Human> humans = new ArrayList<>();
        // My_write_read.my_read(humans);        
        // my_tree.setHumans(humans);
        // my_tree.setMax_id(10);
        my_tree.setWriteable(new Write_read());
        my_tree = my_tree.read();        
        my_tree.create_tree();        
        view.main_menu();}

public void Add_human(ArrayList<String> list1) {my_tree.add_human(list1);}
public ArrayList<String> H2h_community(int[] id) {return my_tree.h2h_community(id);}
public ArrayList<String> GetHuman_Info_Id(int id) {return my_tree.getHuman_info_id(id);}
public ArrayList<String> GetFullList() {return my_tree.GetFullList();}
public ArrayList<String> GetShortList() {return my_tree.GetShortList();}
public void Close() {
        my_tree.save();
        // My_write_read.my_write(my_tree.getHumans());
    }
}
