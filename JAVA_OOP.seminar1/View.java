package JAVA_OOP.seminar1;
import java.util.ArrayList;
import java.util.List;

import JAVA_OOP.seminar1.Menu_Commands.Add_human;
import JAVA_OOP.seminar1.Menu_Commands.Close;
import JAVA_OOP.seminar1.Menu_Commands.GetFullList;
import JAVA_OOP.seminar1.Menu_Commands.GetHuman_Info_Id;
import JAVA_OOP.seminar1.Menu_Commands.GetShortList;
import JAVA_OOP.seminar1.Menu_Commands.H2h_community;
import JAVA_OOP.seminar1.Menu_Commands.Option;
import JAVA_OOP.seminar1.View_Models.Add_Human;
import JAVA_OOP.seminar1.View_Models.H2h_Community;
import JAVA_OOP.seminar1.View_Models.My_Input;

public class View {
    public Presenter presenter;  
    List<Option> command_list = new ArrayList<>();
    GetShortList command1 = new GetShortList(this);
    GetFullList command2 = new GetFullList(this);
    H2h_community command3 = new H2h_community(this);
    Add_human command4 = new Add_human(this);
    GetHuman_Info_Id command5 = new GetHuman_Info_Id(this);
    Close command6 = new Close(this);


    public View(Presenter presenter) {
        this.presenter = presenter;}

    public void print_list(ArrayList<String> list1) {
        for (String item : list1) {
            System.out.println(item);}}

    public void create_Main_menu() {
        command_list.add(command1);
        command_list.add(command2);
        command_list.add(command3);
        command_list.add(command4);
        command_list.add(command5);
        command_list.add(command6);        
    }

    public void main_menu() {
        int sel = 0;
        while (sel!=command_list.size()) {
            System.out.println();
            for (int index = 1; index <= command_list.size() ; index++) {
                System.out.println(index+". "+command_list.get(index-1).discription());}
            sel = my_input("Выберите пункт меню (1-"+command_list.size()+") : ",
                1,command_list.size());
            command_list.get(sel-1).execute();}} 

    public void getHuman_Info_Id() { 
        print_list(presenter.getHuman_Info_Id(my_input(
        "\nВведите ID объекта для получения полной информации : ",
        1,presenter.my_tree.getMax_id())));}

    public void getFullList() {
        System.out.println();
        print_list(presenter.getFullList());
        System.out.println();}

    public void getShortList() {
        System.out.println();
        print_list(presenter.getShortList());
        System.out.println();}   
        
    public int my_input (String str, int n1, int n2) {       
        return (new My_Input()).my_input(str, n1, n2);} 

    public void add_human() {        
        presenter.add_human(new Add_Human().add_human(this));}

    public void h2h_community() {        
        print_list(presenter.h2h_community(new H2h_Community().h2h_Community(this)));}

    public void close() {
        presenter.close();}

}