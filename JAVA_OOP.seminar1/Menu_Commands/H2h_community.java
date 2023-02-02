package JAVA_OOP.seminar1.Menu_Commands;

import JAVA_OOP.seminar1.View;

public class H2h_community implements Option{
    View view;

    public H2h_community(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Вывести тип родственной связи между объектами.";
    }

    @Override
    public void execute() {view.H2h_community();}
    
}