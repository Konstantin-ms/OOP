package JAVA_OOP.seminar1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;

public class Human implements Serializable{
    private String first_name,last_name;
    private Boolean man;
    private int birth_year,id,id_father,id_mother,id_married;
    private Human father, mother, married;
    private LinkedList<Human> child = new LinkedList<>(); 

    @Override
    public java.lang.String toString() 
        {return this.getLast_name()+" "+this.getFirst_name()+" "
        +this.getbirth_year()+"г.р. ( id : "+this.getId()+" )";}

    public ArrayList<String> to_List() {
        ArrayList<String> list1 = new ArrayList<>();
        String str1 = "";

        str1 = "\nID : "+this.getId()+" Имя : "+this.getFirst_name()+ " "
        +this.getLast_name()+" Пол : ";
        if (this.getMan()==true) 
            str1 = str1+"Мужской";
        else 
            str1 = str1+"Женский";
        str1 = str1+" Год рождения : "+this.getbirth_year();
        list1.add(str1);
        if (this.getFather()!= null) 
            list1.add("Отец : "+this.getFather().toString());
        if (this.getMother()!= null) 
            list1.add("Мать : "+this.getMother().toString());
        if (this.getId_married()!=0){
            if (this.getMan()==true) 
                list1.add("Жена : "+this.getMarried().toString());
            else 
                list1.add("Муж : "+this.getMarried().toString());}
        if (this.getChild().size()>0) 
            {list1.add("Дети : ");
            for (Human child:this.getChild()) {list1.add(child.toString());}}            
        return list1;}  
    
    public void addChild(Human child) {
        this.child.add(child);}

    public void childClear() {
        this.child.clear();}

    public boolean equals(Human human) {
        return (this.id==human.id);}

    public Human getMarried() {
        return married;}

    public void setMarried(Human married) {
        this.married = married;}

    public int getId_married() {
        return id_married;}

    public void setId_married(int married) {
        this.id_married = married;}

    public int getId_mother() {
        return id_mother;}
        
    public void setId_mother(int id_mother) {
        this.id_mother = id_mother;}

    public int getId_father() {
        return id_father;}

    public void setId_father(int id_father) {
        this.id_father = id_father;}

    public int getId() {
        return id;}

    public void setId(int id) {
        this.id = id;}                   
    
    public boolean getMan() {
        return man;}

    public void setMan(Boolean man) {
        this.man = man;} 

    public String getFirst_name() {
        return first_name;}

    public void setFirst_name(String first_name) {
        this.first_name = first_name;}

    public String getLast_name() {
        return last_name;}

    public void setLast_name(String last_name) {
        this.last_name = last_name;}

    public int getbirth_year() {
        return birth_year;}

    public void setBirth_year(int birth_year) {
        this.birth_year = birth_year;}

    public Human getFather() {
        return father;}

    public void setFather(Human father) {
        this.father = father;}

    public Human getMother() {
        return mother;}

    public void setMother(Human mother) {
        this.mother = mother;}

    public LinkedList<Human> getChild() {
        return child;}        
}