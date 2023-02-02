package JAVA_OOP.seminar1.Menu_Commands;

import JAVA_OOP.seminar1.View;

public class GetHuman_Info_Id implements Option {
    View view;

    public GetHuman_Info_Id(View view) {
        this.view = view;
    }

    @Override
    public String discription() {
        return "Вывести подробную информацию об объекте по ID.";}


    @Override
    public void execute() {view.GetHuman_Info_Id();}
    
}
