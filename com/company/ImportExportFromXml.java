package com.company;

import Workers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ImportExportFromXml
{
    private final String PROJECT_MANAGER = "pm";
    private final String QA_SPECIALIST = "qa";
    private final String GRAPHIC_DESIGNER = "graphic";
    private final String SOFT_DEVELOPER = "soft";
    private final String ENGINEER = "eng";
    private final String DIRECTOR = "dir";

    ImportExportFromXml()
    {

    }
    public void import_employees(ItCompany company) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("com/company/ImportXmlFile.xml"));
        collect_information(document,DIRECTOR,company);
        collect_information(document,PROJECT_MANAGER,company);
        collect_information(document,QA_SPECIALIST,company);
        collect_information(document,GRAPHIC_DESIGNER,company);
        collect_information(document,SOFT_DEVELOPER,company);
        collect_information(document,ENGINEER,company);
    }
    private void collect_information(Document document, String name_of_element,ItCompany company)
    {
        NodeList elements = document.getElementsByTagName(name_of_element);
        for (int i = 0; i < elements.getLength(); i++) {
            // Получение всех атрибутов элемента
            NamedNodeMap attributes = elements.item(i).getAttributes();
            //String name = attributes.getNamedItem("name").getNodeValue();

            // В зависимости от типа элемента, нам нужно собрать свою дополнительну информацию про каждый подкласс, а после добавить нужные образцы в коллекцию.
            switch (name_of_element) {
                case DIRECTOR -> {
                    Director employee = new Director(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("middle_name").getNodeValue(), attributes.getNamedItem("age").getNodeValue(), attributes.getNamedItem("p_in_hour").getNodeValue(), attributes.getNamedItem("exp").getNodeValue());
                    company.add_employee(employee);
                }
                case PROJECT_MANAGER -> {
                    ProjectManager employee = new ProjectManager(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("middle_name").getNodeValue(), attributes.getNamedItem("age").getNodeValue(), attributes.getNamedItem("p_in_hour").getNodeValue(), attributes.getNamedItem("exp").getNodeValue());
                    company.add_employee(employee);
                }
                case QA_SPECIALIST -> {
                    QA employee = new QA(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("middle_name").getNodeValue(), attributes.getNamedItem("age").getNodeValue(), attributes.getNamedItem("p_in_hour").getNodeValue(), attributes.getNamedItem("exp").getNodeValue());
                    company.add_employee(employee);
                }
                case GRAPHIC_DESIGNER -> {
                    GraphicDesigner employee = new GraphicDesigner(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("middle_name").getNodeValue(), attributes.getNamedItem("age").getNodeValue(), attributes.getNamedItem("p_in_hour").getNodeValue(), attributes.getNamedItem("exp").getNodeValue());
                    company.add_employee(employee);
                }
                case SOFT_DEVELOPER -> {
                    SoftDeveloper employee = new SoftDeveloper(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("middle_name").getNodeValue(), attributes.getNamedItem("age").getNodeValue(), attributes.getNamedItem("p_in_hour").getNodeValue(), attributes.getNamedItem("exp").getNodeValue());
                    company.add_employee(employee);
                }
                case ENGINEER -> {
                    Engineer employee = new Engineer(attributes.getNamedItem("name").getNodeValue(), attributes.getNamedItem("middle_name").getNodeValue(), attributes.getNamedItem("age").getNodeValue(), attributes.getNamedItem("p_in_hour").getNodeValue(), attributes.getNamedItem("exp").getNodeValue());
                    company.add_employee(employee);
                }
            }
        }
    }
    public void export_team(ItCompany company) throws ParserConfigurationException {
        DocumentBuilderFactory dbf;
        DocumentBuilder        db ;
        Document               doc;

        dbf = DocumentBuilderFactory.newInstance();
        db  = dbf.newDocumentBuilder();
        doc = db.newDocument();
        Element root = doc.createElement("Teams");
        List<Team> typeteams = new ArrayList<>();
        Element[] e_users  = new Element[company.getTeams().size()];
        typeteams = company.getTeams();

        String counter = "team";
        for (int i = 0; i < e_users.length; i++)
        {
            counter += Integer.toString(i+1);
            e_users[i] = doc.createElement(counter);
            counter = "team";
        }
        for (int i = 0; i < company.getTeams().size(); i++)
        {
            //root.appendChild(e_users[i]);
            for (int j = 0; j < typeteams.get(i).employees.size(); j++)
            {
                String position;
                if(typeteams.get(i).employees.get(j) instanceof SoftDeveloper)
                {
                    position = "SoftDeveloper";
                }
                else if(typeteams.get(i).employees.get(j) instanceof Engineer)
                {
                    position = "Engineer";
                }
                else if(typeteams.get(i).employees.get(j) instanceof QA)
                {
                    position = "QA";
                }
                else
                {
                    position = "ProjectManager";
                }
                Element nameOfPosition = doc.createElement(position);
                    Element name = doc.createElement("name");
                    name.setAttribute("name",typeteams.get(i).employees.get(j).getName());
                    nameOfPosition.appendChild(name);

                    Element middleName = doc.createElement("MiddleName");
                    middleName.setAttribute("MiddleName",typeteams.get(i).employees.get(j).getMiddle_name());
                    nameOfPosition.appendChild(middleName);

                    Element age = doc.createElement("age");
                    age.setAttribute("age",Integer.toString(typeteams.get(i).employees.get(j).getAge()));
                    nameOfPosition.appendChild(age);

                    Element exp = doc.createElement("exp");
                    String experience;
                    switch (typeteams.get(i).employees.get(j).getWorkExperience())
                    {
                        case JUNIOR -> experience = "Junior";
                        case MIDDLE -> experience = "Middle";
                        case SENIOR -> experience = "Senior";
                        default -> experience = "0";
                    }
                    exp.setAttribute("exp",experience);
                    nameOfPosition.appendChild(exp);

                    Element payInOneHour = doc.createElement("payInOneHour");
                    payInOneHour.setAttribute("payInOneHour",Float.toString(typeteams.get(i).employees.get(j).getSalaryPerHour()));
                    nameOfPosition.appendChild(payInOneHour);
                e_users[i].appendChild(nameOfPosition);
            }
            root.appendChild(e_users[i]);
        }

        doc.appendChild(root);
        writeDocument(doc, "ExportXmlFile.xml");
    }
    private void writeDocument(Document document, String path)
    {
        Transformer trf;
        DOMSource src;
        FileOutputStream fos;
        try {
            trf = TransformerFactory.newInstance()
                    .newTransformer();
            src = new DOMSource(document);
            fos = new FileOutputStream(path);

            StreamResult result = new StreamResult(fos);
            trf.transform(src, result);
        } catch (TransformerException | IOException e) {
            e.printStackTrace(System.out);
        }
    }
}
