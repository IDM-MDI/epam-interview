package com.company;

import Workers.*;

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
    public void showInfoAboutTeam()
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
    public void collectingTeam()
    {
        Team typeTeam = new Team();
        showInformationAboutSpecifiedPosition("Soft Developer");
        checkingAndCollectionWithTime(typeTeam,"Soft Developer");
        showInformationAboutSpecifiedPosition("Engineer");
        checkingAndCollectionWithTime(typeTeam,"Engineer");
        showInformationAboutSpecifiedPosition("QA");
        checkingAndCollectionWithTime(typeTeam,"QA");
        showInformationAboutSpecifiedPosition("Project Manager");
        checkingAndCollectionWithTime(typeTeam,"Project Manager");
        typeTeam.setPriceOfTeamPerOneHour();
        teams.add(typeTeam);
    }

    private void checkingAndCollectionWithTime(Team team,String position)
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
            forChecking = collectingSpecifiedPosition(position,userChoice);
            if(forChecking == -1 || isThereSuchPersonInTeam(team,position,userChoice) !=false)
            {
                i--;
            }
            else
            {
                team.addEmployee(employees.get(forChecking));
            }
            i++;
        }while(i!= userChoiceInteger);

    }
    public void order(Customer customer)
    {
        Scanner scanner = new Scanner(System.in);
        showInfoAboutTeam();
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
    private boolean isThereSuchPersonInTeam(Team team,String position,String name) {
        switch (position) {
            case "Soft Developer" -> {
                for (int i = 0; i < team.employees.size(); i++) {
                    if (team.employees.get(i) instanceof SoftDeveloper && team.employees.get(i).getName().equals(name)) {
                        System.out.println("Sorry, but there is already such a person in your team");
                        return true;
                    }
                }
            }
            case "Engineer" -> {
                for (int i = 0; i < team.employees.size(); i++) {
                    if (team.employees.get(i) instanceof Engineer && team.employees.get(i).getName().equals(name)) {
                        System.out.println("Sorry, but there is already such a person in your team");
                        return true;
                    }
                }
            }
            case "Director" -> {
                for (int i = 0; i < team.employees.size(); i++) {
                    if (team.employees.get(i) instanceof Director && team.employees.get(i).getName().equals(name)) {
                        System.out.println("Sorry, but there is already such a person in your team");
                        return true;
                    }
                }
            }
            case "Graphic Designer" -> {
                for (int i = 0; i < team.employees.size(); i++) {
                    if (team.employees.get(i) instanceof GraphicDesigner && team.employees.get(i).getName().equals(name)) {
                        System.out.println("Sorry, but there is already such a person in your team");
                        return true;
                    }
                }
            }
            case "QA" -> {
                for (int i = 0; i < team.employees.size(); i++) {
                    if (team.employees.get(i) instanceof QA && team.employees.get(i).getName().equals(name)) {
                        System.out.println("Sorry, but there is already such a person in your team");
                        return true;
                    }
                }
            }
            case "Project Manager" -> {
                for (int i = 0; i < team.employees.size(); i++) {
                    if (team.employees.get(i) instanceof ProjectManager && team.employees.get(i).getName().equals(name)) {
                        System.out.println("Sorry, but there is already such a person in your team");
                        return true;
                    }
                }
            }
        }
        System.out.println("Accepted. There is no such a person in the team");
        return false;
    }

    private int collectingSpecifiedPosition(String position,String name)
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

    public void showHierarchy()
    {
        WorkExperience we;
        List<Employee> typename = new ArrayList<>();
        we = WorkExperience.SENIOR;
        for (int i = 0; i < employees.size(); i++)
        {
            if(employees.get(i).getWorkExperience() == we)
            {
                typename.add(employees.get(i));
            }
        }
        we = WorkExperience.MIDDLE;
        for (int i = 0; i < employees.size(); i++)
        {
            if(employees.get(i).getWorkExperience() == we)
            {
                typename.add(employees.get(i));
            }
        }
        we = WorkExperience.JUNIOR;
        for (int i = 0; i < employees.size(); i++)
        {
            if(employees.get(i).getWorkExperience() == we)
            {
                typename.add(employees.get(i));
            }
        }
        showInformationAboutSpecifiedPosition(typename,"Director");
        showInformationAboutSpecifiedPosition(typename,"Project Manager");
        showInformationAboutSpecifiedPosition(typename,"Soft Developer");
        showInformationAboutSpecifiedPosition(typename,"Graphic Designer");
        showInformationAboutSpecifiedPosition(typename,"QA");
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
    public void showInformationAboutSpecifiedPosition(String position)
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
    public void showInformationAboutSpecifiedPosition(List<Employee>typename,String position)
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
