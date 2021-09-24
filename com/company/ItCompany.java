package com.company;

import com.company.Workers.*;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ItCompany
{
    private final List<Employee> employees;
    private final List<Team> teams;

    public ItCompany() {
        employees = new ArrayList<>();
        teams = new ArrayList<>();
    }
    public Employee getEmployee(String name,String Position)
    {
        if(Position == "Soft Developer")
        {
            for(Employee i: employees)
            {
                if(i.getName().equals(name) && i instanceof SoftDeveloper)
                {
                    return i;
                }
            }
        }
        else if(Position == "Engineer")
        {
            for(Employee i: employees)
            {
                if(i.getName().equals(name) && i instanceof Engineer)
                {
                    return i;
                }
            }
        }
        else if(Position == "QA")
        {
            for(Employee i: employees)
            {
                if(i.getName().equals(name) && i instanceof QA)
                {
                    return i;
                }
            }
        }
        else if(Position == "Graphic Designer")
        {
            for(Employee i: employees)
            {
                if(i.getName().equals(name) && i instanceof GraphicDesigner)
                {
                    return i;
                }
            }
        }
        else if(Position == "Project Manager")
        {
            for(Employee i: employees)
            {
                if(i.getName().equals(name) && i instanceof ProjectManager)
                {
                    return i;
                }
            }
        }
        else
        {
            for(Employee i: employees)
            {
                if(i.getName().equals(name) && i instanceof Director)
                {
                    return i;
                }
            }
        }
        return null;
    }
    public void showTeams()
    {
        for (int i = 0; i < teams.size(); i++)
        {
            System.out.println("///////////////////////////////////////////////////////////");
            System.out.println("Team ");
            System.out.print(i+1);
            System.out.print(":\n");
          teams.get(i).showInfoAboutTeam();
        }
    }
    public void addTeam()
    {
        Team typeTeam = new Team();
        typeTeam = typeTeam.createTeam(this);
        teams.add(typeTeam);
    }

    public void order(Customer customer)
    {
        Scanner scanner = new Scanner(System.in);
        showTeams();
        int choice;
        while(true)
        {
            System.out.println("Choose your team: ");
            choice = scanner.nextInt();
            choice--;
            if(choice < 0 || choice > teams.size())
            {
                System.out.println("Try again");
            }
            else
            {
                break;
            }
        }
        System.out.println("Price: "+ teams.get(choice).priceOfTeam(customer.getTypeOfTime()));
    }

    private int collectSpecifiedPosition(String position, String name)
    {
        switch (position) {
            case "Soft Developer" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof SoftDeveloper && employees.get(i).getName().equals(name)) {
                        return i;
                    }
                }
            }
            case "Engineer" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof Engineer && employees.get(i).getName().equals(name)) {
                        return i;
                    }
                }
            }
            case "Director" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof Director && employees.get(i).getName().equals(name)) {
                        return i;
                    }
                }
            }
            case "Graphic Designer" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof GraphicDesigner && employees.get(i).getName().equals(name)) {
                        return i;
                    }
                }
            }
            case "QA" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof QA && employees.get(i).getName().equals(name)) {
                        return i;
                    }
                }
            }
            case "Project Manager" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof ProjectManager && employees.get(i).getName().equals(name)) {
                        return i;
                    }
                }
            }
        }
        System.out.println("This name doesn't exist");
        return -1;
    }
    public void addTeam(Team team){
        teams.add(team);
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }


    private Employee getEmployee(WorkExperience we)
    {
        for(Employee i: employees)
        {
            if(i.getWorkExperience().equals(we))
            {
                return i;
            }
        }
        return null;
    }
    public void showHierarchy()
    {
        List<Employee> typename = new ArrayList<>();
        typename.add(getEmployee(WorkExperience.SENIOR));
        typename.add(getEmployee(WorkExperience.MIDDLE));
        typename.add(getEmployee(WorkExperience.JUNIOR));
        showInfoAboutSpecifiedPosition(typename,"Director");
        showInfoAboutSpecifiedPosition(typename,"Project Manager");
        showInfoAboutSpecifiedPosition(typename,"Soft Developer");
        showInfoAboutSpecifiedPosition(typename,"Graphic Designer");
        showInfoAboutSpecifiedPosition(typename,"QA");
    }
    public List<Employee> getEmployees()
    {
        return employees;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void add_employee(Employee employee) {
        employees.add(employee);
    }

    public void showInformation()
    {
        for(int i = 0; i < employees.size();i++)
        {
            employees.get(i).showInfo();
        }
    }
    public void showInfoAboutSpecifiedPosition(String position)
    {
        switch (position) {
            case "Soft Developer" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof SoftDeveloper) {
                        employees.get(i).showInfo();
                    }
                }
            }
            case "Engineer" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof Engineer) {
                        employees.get(i).showInfo();
                    }
                }
            }
            case "Director" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof Director) {
                        employees.get(i).showInfo();
                    }
                }
            }
            case "Graphic Designer" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof GraphicDesigner) {
                        employees.get(i).showInfo();
                    }
                }
            }
            case "QA" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof QA) {
                        employees.get(i).showInfo();
                    }
                }
            }
            case "Project Manager" -> {
                for (int i = 0; i < employees.size(); i++) {
                    if (employees.get(i) instanceof ProjectManager) {
                        employees.get(i).showInfo();
                    }
                }
            }
        }
    }
    public void showInfoAboutSpecifiedPosition(List<Employee>typename, String position)
    {
        switch (position) {
            case "Soft Developer" -> {
                for (int i = 0; i < typename.size(); i++) {
                    if (typename.get(i) instanceof SoftDeveloper) {
                        typename.get(i).showInfo();
                    }
                }
            }
            case "Engineer" -> {
                for (int i = 0; i < typename.size(); i++) {
                    if (typename.get(i) instanceof Engineer) {
                        typename.get(i).showInfo();
                    }
                }
            }
            case "Director" -> {
                for (int i = 0; i < typename.size(); i++) {
                    if (typename.get(i) instanceof Director) {
                        typename.get(i).showInfo();
                    }
                }
            }
            case "Graphic Designer" -> {
                for (int i = 0; i < typename.size(); i++) {
                    if (typename.get(i) instanceof GraphicDesigner) {
                        typename.get(i).showInfo();
                    }
                }
            }
            case "QA" -> {
                for (int i = 0; i < typename.size(); i++) {
                    if (typename.get(i) instanceof QA) {
                        typename.get(i).showInfo();
                    }
                }
            }
            case "Project Manager" -> {
                for (int i = 0; i < typename.size(); i++) {
                    if (typename.get(i) instanceof ProjectManager) {
                        typename.get(i).showInfo();
                    }
                }
            }
        }
    }
}
