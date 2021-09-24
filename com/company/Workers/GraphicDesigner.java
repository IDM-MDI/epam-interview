package com.company.Workers;

public class GraphicDesigner extends Employee
{
    GraphicDesigner(String name,String middle_name,int age,float salaryPerHour,WorkExperience workExperience)
    {
        super(name,middle_name,age,salaryPerHour,workExperience);

    }
    public GraphicDesigner(String name, String middle_name, String age, String salaryPerHour,String we)
    {
        super(name,middle_name,age,salaryPerHour,we);
    }

    @Override
    public void showInfo() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Position: Graphic Designer");
        super.showInfo();
    }
}
