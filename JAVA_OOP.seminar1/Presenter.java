package JAVA_OOP.seminar1;

import java.util.ArrayList;

public class Presenter {
    public Tree<Human> my_tree = new Tree<>();
    View view = new View(this);

    void pressButton() {
        // ArrayList<Human> humans = new ArrayList<>();
        // My_write_read.my_read(humans);        
        // my_tree.setHumans(humans);
        // my_tree.setMax_id(12);
        my_tree.setWriteable(new Write_read());
        my_tree = my_tree.read();        
        my_tree.create_tree();
        view.create_Main_menu();        
        view.main_menu();}

public void add_human(ArrayList<String> list1) {
    my_tree.add_human(list1);}
public ArrayList<String> h2h_community(int[] id) {
    return my_tree.h2h_community(id);}
public ArrayList<String> getHuman_Info_Id(int id) {
    return my_tree.getHuman_info_id(id);}
public ArrayList<String> getFullList() {
    return my_tree.getFullList();}
public ArrayList<String> getShortList() {
    return my_tree.getShortList();}
public void close() {
    my_tree.save();
    // My_write_read.my_write(my_tree.getHumans());
    }
}