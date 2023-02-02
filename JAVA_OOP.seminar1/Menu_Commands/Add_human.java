package JAVA_OOP.seminar1.Menu_Commands;

import JAVA_OOP.seminar1.View;

public class Add_human implements Option{
View view;
    public Add_human(View view) {
    this.view = view;}

    @Override
    public String discription() {
        return "Добавить объект.";}

    @Override
    public void execute() {view.Add_human();}
    
}
