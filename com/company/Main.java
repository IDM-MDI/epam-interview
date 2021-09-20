package com.company;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        ItCompany epam = new ItCompany();
        ImportExportFromXml importing = new ImportExportFromXml();
        importing.import_employees(epam);
        epam.showInformation();
        epam.collectingTeam();
/*      epam.showInfoAboutTeam();
        Customer customer = new Customer();
        epam.order(customer);*/
        //epam.showHierarchy();
        importing.export_team(epam);
    }
}
