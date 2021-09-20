package Workers;

public class SoftDeveloper extends Employee
{
    SoftDeveloper(String name,String middle_name,int age,float salaryPerHour,WorkExperience workExperience)
    {
        super(name,middle_name,age,salaryPerHour,workExperience);

    }
    public SoftDeveloper(String name, String middle_name, String age, String salaryPerHour,String we)
    {
        super(name,middle_name,age,salaryPerHour,we);
    }

    @Override
    public void showInfo()
    {
        System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
        System.out.println("Position: Soft Developer");
        super.showInfo();
    }
}
