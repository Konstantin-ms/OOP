package seminar_1.2.3;

import java.util.Comparator;

public class Human_Comparator_Birth_year implements Comparator<Human>{
    @Override
    public int compare(Human o1, Human o2) {
        return Integer.compare(o1.getbirth_year(), o2.getbirth_year());}    
}
