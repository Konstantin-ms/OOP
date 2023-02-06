package JAVA_OOP.seminar1.Menu_Commands;

import JAVA_OOP.seminar1.View;

public class GetShortList implements Option{
    View view;

    public GetShortList(View view) {
        this.view = view;}

    @Override
    public String discription() {
        return "Вывести краткий список.";}

    @Override
    public void execute() {
        view.getShortList();}
    
}