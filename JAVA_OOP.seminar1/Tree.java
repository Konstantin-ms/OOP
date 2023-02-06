package JAVA_OOP.seminar1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import JAVA_OOP.seminar1.Tree_Models.Add_Human;
import JAVA_OOP.seminar1.Tree_Models.GetFamilyType;

public class Tree<T extends Human> implements Serializable, Iterable<T>{
    private int max_id;
    private ArrayList<T> humans = new ArrayList<>();
    private Writeable writeable; 

    public Tree<T> read () {
        return writeable.read();}
    public void save()  {
        writeable.save(this);}
    public void setWriteable(Writeable writeable) {
        this.writeable = writeable;}

    public String getFamilyType(T my_human, T human) {
        return new GetFamilyType<>().getFamilyType(my_human, human);}

    public T getHuman_id(int id) {   
        T human = (T) new Human();
        for (T item : this) {
            if (item.getId()==id) 
                human = item;}
        return human;}

    public void create_tree() {
        for (T item : this) {
            item.childClear();}
        for (T item : this) {
        // ищем супругов
            if (item.getId_married()!=0) 
                item.setMarried(getHuman_id(item.getId_married()));
        // ищем родителей
            if (item.getId_father()>0) 
                item.setFather(getHuman_id(item.getId_father()));
            if (item.getId_mother()>0) 
                item.setMother(getHuman_id(item.getId_mother()));
        // ищем детей
            if (item.getId_father()>0) 
                getHuman_id(item.getId_father()).addChild(item);
            if (item.getId_mother()>0) 
                getHuman_id(item.getId_mother()).addChild(item);}}

    public void add_human(ArrayList<String> list1) {
        T human = (T) new Add_Human<>().add_human(list1);
        this.humans.add(human);
        this.setMax_id(++this.max_id);
        this.create_tree();}

    public ArrayList<String> getHuman_info_id(int id) {
        ArrayList<String> list1 = new ArrayList<>();
        T human = getHuman_id(id);
        list1.add("\nИсследуется объект : "+human.toString()+"\n");
        for (T item : this) {
            if (!item.equals(human)&&!getFamilyType(item,human).equals(
                "Не является генетическим родственником."))    
                    list1.add(getFamilyType(item,human)+ " : "+item.toString());}
        return list1;}

    public ArrayList<String> h2h_community(int[] n) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("\n"+this.getHuman_id(n[0]).toString());
        list1.add(getFamilyType(this.getHuman_id(n[0]),this.getHuman_id(n[1]))+" для");
        list1.add(this.getHuman_id(n[1]).toString());
        return list1;} 
    
    public ArrayList<String> getShortList() {
        ArrayList<String> list1 = new ArrayList<>();
        this.getHumans().sort(new Human_Comparator_Name());
        for (Human item : this) 
            list1.add(item.toString());
        return list1;}
    
    public ArrayList<String> getFullList() {
        ArrayList<String> list1 = new ArrayList<>();
        this.getHumans().sort(new Human_Comparator_Birth_year());    
        for (Human item : this) {
            for (int index = 0; index < item.to_List().size(); index++) {
                list1.add(item.to_List().get(index));}}    
        return list1;}
        
    public ArrayList<T> getHumans() {
        return humans;}
        
    public void setHumans(ArrayList<T> humans) {
        this.humans = humans;}
    
    public int getMax_id() {
        return max_id;}
    public void setMax_id(int max_id) {
        this.max_id = max_id;}

    @Override
    public Iterator<T> iterator() {
        return new Tree_Iterator<T>(humans);}    
}
