package JAVA_OOP.seminar1.Menu_Commands;

import JAVA_OOP.seminar1.View;

public class GetFullList implements Option{
    View view;

    public GetFullList(View view) {
        this.view = view;}

    @Override
    public String discription() {
        return "Вывести подробный список.";}

    @Override
    public void execute() {view.GetFullList();}
    
}