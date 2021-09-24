package com.company;

import com.company.Workers.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
        if(typeOfTime == "Short"){price *= 3;}
        else if(typeOfTime == "Normal"){price *= 12;}
        else{price *= 90;}
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
    Team createTeam(ItCompany company)
    {
        company.showInfoAboutSpecifiedPosition("Soft Developer");
        MenuWithTime(company,"Soft Developer");
        company.showInfoAboutSpecifiedPosition("Engineer");
        MenuWithTime(company,"Engineer");
        company.showInfoAboutSpecifiedPosition("QA");
        MenuWithTime(company,"QA");
        company.showInfoAboutSpecifiedPosition("Project Manager");
        MenuWithTime(company,"Project Manager");
        setPriceOfTeamPerOneHour();
        return this;
    }
    private void MenuWithTime(ItCompany company,String position)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type how many " + position+" do you want in your team");
        String userChoice = scanner.nextLine();
        int userChoiceInteger = Integer.parseInt(userChoice);
        int i=0;
        int forChecking;
        do
        {
            System.out.println("Type Name to choose them to your team");
            userChoice = scanner.nextLine();
            Employee employee = company.getEmployee(userChoice,position);
            if(employee == null || isPersonInTeam(position,userChoice) !=false)
            {
                i--;
            }
            else
            {
                addEmployee(employee);
            }
            i++;
        }while(i!= userChoiceInteger);

    }
    private boolean isPersonInTeam(String position, String name) {
        switch (position) {
            case "Soft Developer" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof SoftDeveloper && employees.get(i).getName().equals(name)) {
                        System.out.println("Sorry, but there is already such a person in your team");
                        return true;
                    }
                }
            }
            case "Engineer" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof Engineer && employees.get(i).getName().equals(name)) {
                        System.out.println("Sorry, but there is already such a person in your team");
                        return true;
                    }
                }
            }
            case "Director" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof Director && employees.get(i).getName().equals(name)) {
                        System.out.println("Sorry, but there is already such a person in your team");
                        return true;
                    }
                }
            }
            case "Graphic Designer" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof GraphicDesigner && employees.get(i).getName().equals(name)) {
                        System.out.println("Sorry, but there is already such a person in your team");
                        return true;
                    }
                }
            }
            case "QA" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof QA && employees.get(i).getName().equals(name)) {
                        System.out.println("Sorry, but there is already such a person in your team");
                        return true;
                    }
                }
            }
            case "Project Manager" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof ProjectManager && employees.get(i).getName().equals(name)) {
                        System.out.println("Sorry, but there is already such a person in your team");
                        return true;
                    }
                }
            }
        }
        System.out.println("Accepted. There is no such a person in the team");
        return false;
    }

}
