package com.company;

import Workers.*;

import java.util.ArrayList;
import java.util.List;

public class Team {
    List<Employee> employees;
    private float priceOfTeamPerOneHour;
    public Team()
    {
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee)
    {
        employees.add(employee);
    }

    void showInfoAboutTeam()
    {
        System.out.println("List of your team:");
        for (Employee i: employees)
        {
          i.showInfo();
        }
    }

    public void setPriceOfTeamPerOneHour() {
        this.priceOfTeamPerOneHour = priceOfTeamPerHour();
    }


    public float priceOfTeamPerHour()
    {
        float price = 0;
        for(Employee i: employees)
        {
            price+= i.getSalaryPerHour();
        }
        return price;
    }

    public float priceOfTeam(String typeOfTime)
    {
        float price = priceOfTeamPerHour() * 24;

        switch(typeOfTime)
        {
            case "Short":
            {
                price *= 3;
            }break;
            case "Normal":
            {
                price *= 12;
            }break;
            case "Long":
            {
                price *= 90;
            }break;
        }
        return price;
    }

    public void qualityComposition()
    {
        int eng = 0,soft = 0,qa = 0,pm = 0;
        int[] engineer = new int[]{0,0,0};
        int[] softdev = new int[]{0,0,0};
        int[] qas = new int[]{0,0,0};
        int[] projectman = new int[]{0,0,0};
        for (int i = 0; i < employees.size(); i++)
        {
            if(employees.get(i) instanceof SoftDeveloper)
            {
                switch (employees.get(i).getWorkExperience())
                {
                    case JUNIOR ->{softdev[0]++;break;}
                    case MIDDLE ->{softdev[1]++;break;}
                    case SENIOR ->{softdev[2]++;break;}
                }
                soft++;
            }
            else if(employees.get(i) instanceof QA)
            {
                switch (employees.get(i).getWorkExperience())
                {
                    case JUNIOR ->{qas[0]++;break;}
                    case MIDDLE ->{qas[1]++;break;}
                    case SENIOR ->{qas[2]++;break;}
                }
                qa++;
            }
            else if(employees.get(i) instanceof ProjectManager)
            {
                switch (employees.get(i).getWorkExperience())
                {
                    case JUNIOR ->{projectman[0]++;break;}
                    case MIDDLE ->{projectman[1]++;break;}
                    case SENIOR ->{projectman[2]++;break;}
                }
                pm++;
            }
            else if(employees.get(i) instanceof Engineer)
            {
                switch (employees.get(i).getWorkExperience())
                {
                    case JUNIOR ->{engineer[0]++;break;}
                    case MIDDLE ->{engineer[1]++;break;}
                    case SENIOR ->{engineer[2]++;break;}
                }
                eng++;
            }
        }
        System.out.println("Team:\nSoft Developer: "+ soft  + "\nJunior: \n"+softdev[0]+"\nMiddle: "+softdev[1] +"\nSenior: " + softdev[2]);
        System.out.println("Team:\nQA: "+ qa + "\nJunior: \n"+qas[0]+"\nMiddle: "+qas[1] +"\nSenior: " + qas[2]);
        System.out.println("Team:\nProject Manager: "+ pm  + "\nJunior: \n"+projectman[0]+"\nMiddle: "+projectman[1] +"\nSenior: " + projectman[2]);
        System.out.println("Team:\nEngineer: "+ eng  + "\nJunior: \n"+engineer[0]+"\nMiddle: "+engineer[1] +"\nSenior: " + engineer[2]);
    }
}
