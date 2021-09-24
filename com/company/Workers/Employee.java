package com.company.Workers;

public abstract class Employee
{
    private WorkExperience workExperience;
    private float salaryPerHour;
    private String name,middle_name;
    private int age;

    Employee(String name,String middle_name,int age,float salaryPerHour,WorkExperience we)
    {
        this.name = name;
        this.middle_name = middle_name;
        this.age = age;
        this.salaryPerHour = salaryPerHour;
        this.workExperience = we;
    }
    Employee(String name,String middle_name,String age,String salaryPerHour,String we)
    {
        this.name = name;
        this.middle_name = middle_name;
        this.age = Integer.parseInt(age);
        this.salaryPerHour = Float.parseFloat(salaryPerHour);
        switch (we)
        {
            case "1":
            {
                this.workExperience = WorkExperience.JUNIOR;
            }break;
            case "2":
            {
                this.workExperience = WorkExperience.MIDDLE;
            }break;
            case "3":
            {
                this.workExperience = WorkExperience.SENIOR;
            }break;
        }
    }

    public void showInfo()
    {
        System.out.println("Name: "+ this.name+
                "\nMiddle name: "+this.middle_name+
                "\nAge: " + this.age +
                "\nPay in one hour: " + this.salaryPerHour);
        switch (workExperience)
        {
            case JUNIOR: System.out.println("WorkExperience: JUNIOR"); break;
            case MIDDLE: System.out.println("WorkExperience: MIDDLE"); break;
            case SENIOR: System.out.println("WorkExperience: SENIOR"); break;
        }
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
    }
    public String getName() {
        return name;
    }

    public String getMiddle_name() {
        return middle_name;
    }

    public int getAge() {
        return age;
    }

    public float getSalaryPerHour() {
        return salaryPerHour;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

}
