package JAVA_OOP.seminar1;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import JAVA_OOP.seminar1.Menu_Commands.Add_human;
import JAVA_OOP.seminar1.Menu_Commands.Close;
import JAVA_OOP.seminar1.Menu_Commands.GetFullList;
import JAVA_OOP.seminar1.Menu_Commands.GetHuman_Info_Id;
import JAVA_OOP.seminar1.Menu_Commands.GetShortList;
import JAVA_OOP.seminar1.Menu_Commands.H2h_community;
import JAVA_OOP.seminar1.Menu_Commands.Option;

public class View {
    Scanner scan = new Scanner(System.in);
    Presenter presenter;  

    public View(Presenter presenter) {
        this.presenter = presenter;
    }

    public void print_list(ArrayList<String> list1) {
        for (String item : list1) {System.out.println(item);}}

    public int my_input (String str, int n1, int n2) {
        int inp = 0;
        boolean test = true;
        while (test) {
            Scanner scan = new Scanner(System.in);
            System.out.print(str);
            try { inp = scan.nextInt();test = false;} 
            catch (Exception e) { 
                System.out.println("Вы ввели не число, попробуйте еще раз.");}
            if (!test)   { 
            if (inp>=n1&&inp<=n2) test = false;
            else {test = true; 
                System.out.println("Число от "+n1+" до "+n2+". попробуйте еще раз.");}}}
        return inp;}        
 
    public void main_menu() {
        int sel = 0;
        List<Option> command_list = new ArrayList<>();
        GetShortList command1 = new GetShortList(this);
        GetFullList command2 = new GetFullList(this);
        H2h_community command3 = new H2h_community(this);
        Add_human command4 = new Add_human(this);
        GetHuman_Info_Id command5 = new GetHuman_Info_Id(this);
        Close command6 = new Close(this);
        command_list.add(command1);
        command_list.add(command2);
        command_list.add(command3);
        command_list.add(command4);
        command_list.add(command5);
        command_list.add(command6);
        while (sel!=command_list.size()) {
            System.out.println();
            for (int index = 1; index <= command_list.size() ; index++) {
                System.out.println(index+". "+command_list.get(index-1).discription());}
            sel = my_input("Выберите пункт меню (1-6) : ",1,command_list.size());
            command_list.get(sel-1).execute();}
        scan.close();} 

    public void Add_human() {
        Scanner scan = new Scanner(System.in);
        ArrayList<String> list1 = new ArrayList<>();
        System.out.println("Создается новый объект с ID "+(presenter.my_tree.getMax_id()+1)+" : ");
        list1.add(String.valueOf(presenter.my_tree.getMax_id()+1));
        System.out.print("Введите имя : ");
        String first_name = scan.nextLine(); 
        list1.add(first_name);
        System.out.print("Введите фамилию : ");
        String last_name = scan.nextLine(); 
        list1.add(last_name);
        int birth_year = my_input("Введите год рождения : ",0,2023);
        list1.add(String.valueOf(birth_year));
        if (my_input("Введите пол (1-мужской/0-женский): ",0,1)==1) 
        list1.add("1");
        else list1.add("0");
        int id_father = my_input("Введите ID отца (0 - отсутствует) : ",
            0,presenter.my_tree.getMax_id());
        list1.add(String.valueOf(id_father));
        int id_mother = my_input("Введите ID матери (0 - отсутствует) : ",
            0,presenter.my_tree.getMax_id());
        list1.add(String.valueOf(id_mother));
        int id_married = my_input("Введите ID cупруга/супруги (0 - отсутствует) : ",
            0,presenter.my_tree.getMax_id());
        list1.add(String.valueOf(id_married)); 
        presenter.Add_human(list1);}

    public void H2h_community() {
        int[] id = new int[2];
        boolean test = true;
        System.out.println();
        id[0] = my_input("\nВведите ID исследуемого человека : ",
        1,presenter.my_tree.getMax_id());
        while (test) {
        test = false;
        id[1] = my_input("Введите ID для установления степени родства : ",
        1,presenter.my_tree.getMax_id());
        if (id[1]==id[0])
            {System.out.println("Введите другого человека.");
            test = true;}}        
        print_list(presenter.H2h_community(id));}

    public void GetHuman_Info_Id() { 
        print_list(presenter.GetHuman_Info_Id(my_input(
        "\nВведите ID объекта для получения полной информации : ",
        1,presenter.my_tree.getMax_id())));}

    public void Close() {presenter.Close();}

    public void GetFullList() {
        System.out.println();
        print_list(presenter.GetFullList());
        System.out.println();}

    public void GetShortList() {
        System.out.println();
        print_list(presenter.GetShortList());
        System.out.println();}   

}