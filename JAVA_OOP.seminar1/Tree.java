package JAVA_OOP.seminar1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Tree<T extends Human> implements Serializable, Iterable<T>{
    private int max_id;
    private ArrayList<T> humans = new ArrayList<>();
    private Writeable writeable; 

// public Tree_class(int inp_max_id, ArrayList<Human> inp_humans){
//     this.max_id = inp_max_id;
//     this.humans = inp_humans;}

    public Tree read () {return writeable.read();}
    public void save()  {writeable.save(this);}
    public void setWriteable(Writeable writeable) {this.writeable = writeable;}

    public String getFamilyType(T my_human, T human) {
        String str1 = "Не является генетическим родственником.";
        int gender;
        if (my_human.getMan()) {gender = 0;}
        else {gender = 1;}
        String[] type1 = {"Сын","Дочь"};
        String[] type2 = {"Отец","Мать"};
        String[] type3 = {"Брат","Сестра"};
        String[] type4 = {"Дедушка","Бабушка"};
        String[] type5 = {"Внук","Внучка"};
        String[] type6 = {"Племянник","Племянница"};
        String[] type7 = {"Дядя","Тетя"};
        String[] type8 = {"Муж","Жена"};        
        String[] type9 = {"Тесть","Теща"};
        String[] type10 = {"Свекор","Свекровь"};
        String[] type11 = {"Зять","Невестка"};

// тесть-теща-свекор-свекровь
        if (my_human.getChild().size()>0&&human.getMarried()!=null){
            if (my_human.getChild().contains(human.getMarried())) {
                if (human.getMan()) return type9[gender];
                else return type10[gender];}}
// зять-невестка
        if (my_human.getMarried()!=null&&my_human.getMarried().getFather()!=null&&
        my_human.getMarried().getMother()!=null){
            if (my_human.getMarried().getFather().equals(human)||
            my_human.getMarried().getMother().equals(human))
                return type11[gender];}
// брат-сестра
        if (my_human.getFather()!=null&&human.getFather()!=null&&
        my_human.getMother()!=null&&human.getMother()!=null&&
        my_human.getFather().equals(human.getFather())
            &&my_human.getMother().equals(human.getMother())) return type3[gender];        
// сын-дочь
        if ((my_human.getFather()!=null&&my_human.getFather().equals(human))||
            (my_human.getMother()!=null&&my_human.getMother().equals(human))) return type1[gender];
// внук-внучка
        if (my_human.getFather()!=null&&my_human.getMother()!=null){
            if ((my_human.getFather().getFather()!=null&&my_human.getFather().getFather().equals(human))||
                (my_human.getFather().getMother()!=null&&my_human.getFather().getMother().equals(human))||
                (my_human.getMother().getMother()!=null&&my_human.getMother().getMother().equals(human))||
                (my_human.getMother().getFather()!=null&&my_human.getMother().getFather().equals(human))) 
                return type5[gender];}
// отец-мать
        if (my_human.getChild().size()>0&&my_human.getChild().contains(human)) return type2[gender];
// дедушка-бабушка
        if ((my_human.getChild().size()>0&&human.getFather()!=null&&human.getMother()!=null)&&
            (my_human.getChild().contains(human.getFather())||(my_human.getChild().contains(human.getMother())))) 
            return type4[gender];
// племянник-племянница
        if (my_human.getFather()!=null&&my_human.getFather().getFather()!=null&&
        my_human.getFather().getMother()!=null&&human.getFather()!=null&&human.getMother()!=null) {
                if (my_human.getFather().getFather().equals(human.getFather())&&
                my_human.getFather().getMother().equals(human.getMother()))
                {return type6[gender]+" по отцовской линии";}}
        if (my_human.getMother()!=null&&my_human.getMother().getFather()!=null&&
        my_human.getMother().getMother()!=null&&human.getFather()!=null&&human.getMother()!=null) {
                if (my_human.getMother().getFather().equals(human.getFather())&&
                my_human.getMother().getMother().equals(human.getMother()))
                {return type6[gender]+" по материнской линии";}}
// дядя-тетя
        if (my_human.getFather()!=null&&my_human.getMother()!=null&&human.getFather()!=null&&
            human.getFather().getFather()!=null&&human.getFather().getMother()!=null){
                if (my_human.getFather().equals(human.getFather().getFather())&&
                my_human.getMother().equals(human.getFather().getMother())) 
                    return type7[gender]+" по отцовской линии";}
        if (my_human.getFather()!=null&&my_human.getMother()!=null&&human.getMother()!=null&&
        human.getMother().getFather()!=null&&human.getMother().getMother()!=null){
            if (my_human.getFather().equals(human.getMother().getFather())&&
            my_human.getMother().equals(human.getMother().getMother())) 
                return type7[gender]+" по материнской линии";}
// муж-жена 
        if (my_human.getMarried()!=null&&my_human.getMarried().equals(human)) return type8[gender];
        return str1;}

    public T getHuman_id(int id) {   
        T human = (T) new Human();
        for (T item : this) {if (item.getId()==id) human = item;}
        return human;}

    public void create_tree() {
        for (T item : this) {item.childClear();}
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
        T human = (T) new Human();
        human.setId(Integer.parseInt(list1.get(0)));
        human.setFirst_name(list1.get(1));
        human.setLast_name(list1.get(2));
        human.setBirth_year(Integer.parseInt(list1.get(3)));
        if (list1.get(4).equals("1")) human.setMan(true);
        else human.setMan(false);
        human.setId_father(Integer.parseInt(list1.get(5)));
        human.setId_mother(Integer.parseInt(list1.get(6)));
        human.setId_married(Integer.parseInt(list1.get(7))); 
        this.humans.add(human);
        this.setMax_id(++this.max_id);
        this.create_tree();}

    public ArrayList<String> getHuman_info_id(int id) {
        ArrayList<String> list1 = new ArrayList<>();
        T human = getHuman_id(id);
        list1.add("\nИсследуется объект : "+human.toString()+"\n");
        for (T item : this) {
        if (!item.equals(human)&&
        !getFamilyType(item,human).equals("Не является генетическим родственником."))    
            list1.add(getFamilyType(item,human)+ " : "+item.toString());}
            return list1;}

    public ArrayList<String> h2h_community(int[] n) {
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("\n"+this.getHuman_id(n[0]).toString());
        list1.add(getFamilyType(this.getHuman_id(n[0]),this.getHuman_id(n[1]))+" для");
        list1.add(this.getHuman_id(n[1]).toString());
       return list1;} 
    
    public ArrayList<String> GetShortList() {
        ArrayList<String> list1 = new ArrayList<>();
        this.getHumans().sort(new Human_Comparator_Name());
        for (Human item : this) list1.add(item.toString());
        return list1;}
    
    public ArrayList<String> GetFullList() {
        ArrayList<String> list1 = new ArrayList<>();
        this.getHumans().sort(new Human_Comparator_Birth_year());    
        for (Human item : this) {
            for (int index = 0; index < item.toString_1().size(); index++) {
                list1.add(item.toString_1().get(index));}}    
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