package com.company;

import java.util.Scanner;

public class Customer
{
    private final String typeOfTime;
    Customer()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose type of work\n1)Short(3 days)\n2)Normal(12 days)\n3)Long(90 days)");
        int choice  = scanner.nextInt();
        typeOfTime = (choice == 1)?"Short":(choice == 2)?"Normal":"Long";
    }

    public String getTypeOfTime() {
        return typeOfTime;
    }
}
