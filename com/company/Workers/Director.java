package com.company.Workers;

public class Director extends Employee
{
    public Director(String name,String middle_name,int age,float salaryPerHour,WorkExperience workExperience)
    {
        super(name,middle_name,age,salaryPerHour,workExperience);

    }
    public Director(String name, String middle_name, String age, String salaryPerHour,String we)
    {
        super(name,middle_name,age,salaryPerHour,we);
    }

    @Override
    public void showInfo() {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Position: Director");
        super.showInfo();
    }
}
