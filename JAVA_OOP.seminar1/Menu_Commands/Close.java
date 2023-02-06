package JAVA_OOP.seminar1.Menu_Commands;

import JAVA_OOP.seminar1.View;

public class Close implements Option{
    View view;


    public Close(View view) {
        this.view = view;}

    @Override
    public String discription() {
        return "Завершить.";}

    @Override
    public void execute() {
        view.close();}
    
}