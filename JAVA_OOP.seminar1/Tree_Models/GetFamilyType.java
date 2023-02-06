package JAVA_OOP.seminar1.Tree_Models;

import JAVA_OOP.seminar1.Human;

public class GetFamilyType<T extends Human> {
    public String getFamilyType(T my_human, T human) {
        String str1 = "Не является генетическим родственником.";
        int gender;
        if (my_human.getMan()) {
            gender = 0;}
        else {
            gender = 1;}
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
                if (human.getMan()) 
                    return type9[gender];
                else 
                    return type10[gender];}}
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
        &&my_human.getMother().equals(human.getMother())) 
            return type3[gender];        
// сын-дочь
        if ((my_human.getFather()!=null&&my_human.getFather().equals(human))||
        (my_human.getMother()!=null&&my_human.getMother().equals(human))) 
            return type1[gender];
// внук-внучка
        if (my_human.getFather()!=null&&my_human.getMother()!=null){
            if ((my_human.getFather().getFather()!=null&&my_human.getFather().getFather().equals(human))||
                (my_human.getFather().getMother()!=null&&my_human.getFather().getMother().equals(human))||
                (my_human.getMother().getMother()!=null&&my_human.getMother().getMother().equals(human))||
                (my_human.getMother().getFather()!=null&&my_human.getMother().getFather().equals(human))) 
                    return type5[gender];}
// отец-мать
        if (my_human.getChild().size()>0&&my_human.getChild().contains(human)) 
            return type2[gender];
// дедушка-бабушка
        if ((my_human.getChild().size()>0&&human.getFather()!=null&&human.getMother()!=null)&&
            (my_human.getChild().contains(human.getFather())||(my_human.getChild().contains(human.getMother())))) 
                return type4[gender];
// племянник-племянница
        if (my_human.getFather()!=null&&my_human.getFather().getFather()!=null&&
        my_human.getFather().getMother()!=null&&human.getFather()!=null&&human.getMother()!=null) {
                if (my_human.getFather().getFather().equals(human.getFather())&&
                my_human.getFather().getMother().equals(human.getMother())){
                    return type6[gender]+" по отцовской линии";}}
        if (my_human.getMother()!=null&&my_human.getMother().getFather()!=null&&
        my_human.getMother().getMother()!=null&&human.getFather()!=null&&human.getMother()!=null) {
                if (my_human.getMother().getFather().equals(human.getFather())&&
                my_human.getMother().getMother().equals(human.getMother())){
                    return type6[gender]+" по материнской линии";}}
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
        if (my_human.getMarried()!=null&&my_human.getMarried().equals(human)) 
            return type8[gender];
        return str1;
        
    }
    
}