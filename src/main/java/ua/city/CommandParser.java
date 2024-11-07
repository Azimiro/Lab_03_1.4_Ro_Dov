package ua.city;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandParser {
    private StreetDAO streetDAO = new StreetDAO();
    private BuildingDAO buildingDAO = new BuildingDAO();
    private ApartmentDAO apartmentDAO = new ApartmentDAO();

    public void executeCommand(String command) {
        if (command.startsWith("insert street")) {
            // Команда для додавання нової вулиці
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)', city='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String name = matcher.group(2);
                String city = matcher.group(3);
                streetDAO.insertStreet(id, name, city);
                System.out.println("Inserted street successfully.");
            } else {
                System.out.println("Invalid insert street command format.");
            }
        } else if (command.startsWith("update street")) {
            // Команда для оновлення назви вулиці
            Pattern pattern = Pattern.compile("id=(\\d+), name='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String newName = matcher.group(2);
                streetDAO.updateStreet(id, newName);
                System.out.println("Updated street successfully.");
            } else {
                System.out.println("Invalid update street command format.");
            }
        } else if (command.startsWith("delete street")) {
            // Команда для видалення вулиці за id
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                streetDAO.deleteStreet(id);
                System.out.println("Deleted street successfully.");
            } else {
                System.out.println("Invalid delete street command format.");
            }
        } else if (command.startsWith("read street")) {
            // Команда для зчитування всіх вулиць
            streetDAO.getAllStreets();

        } else if (command.startsWith("insert building")) {
            // Команда для додавання нового будинку
            Pattern pattern = Pattern.compile("id=(\\d+), address='(.+?)', street_id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String address = matcher.group(2);
                int streetId = Integer.parseInt(matcher.group(3));
                buildingDAO.insertBuilding(id, address, streetId);
                System.out.println("Inserted building successfully.");
            } else {
                System.out.println("Invalid insert building command format.");
            }
        } else if (command.startsWith("update building")) {
            // Команда для оновлення адреси будинку
            Pattern pattern = Pattern.compile("id=(\\d+), address='(.+?)'");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                String newAddress = matcher.group(2);
                buildingDAO.updateBuilding(id, newAddress);
                System.out.println("Updated building successfully.");
            } else {
                System.out.println("Invalid update building command format.");
            }
        } else if (command.startsWith("delete building")) {
            // Команда для видалення будинку за id
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                buildingDAO.deleteBuilding(id);
                System.out.println("Deleted building successfully.");
            } else {
                System.out.println("Invalid delete building command format.");
            }
        } else if (command.startsWith("read building")) {
            // Команда для зчитування всіх будинків
            buildingDAO.getAllBuildings();

        } else if (command.startsWith("insert apartment")) {
            // Команда для додавання нової квартири
            Pattern pattern = Pattern.compile("id=(\\d+), building_id=(\\d+), number=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                int buildingId = Integer.parseInt(matcher.group(2));
                int number = Integer.parseInt(matcher.group(3));
                apartmentDAO.insertApartment(id, buildingId, number);
                System.out.println("Inserted apartment successfully.");
            } else {
                System.out.println("Invalid insert apartment command format.");
            }
        } else if (command.startsWith("update apartment")) {
            // Команда для оновлення номера квартири
            Pattern pattern = Pattern.compile("id=(\\d+), number=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                int newNumber = Integer.parseInt(matcher.group(2));
                apartmentDAO.updateApartment(id, newNumber);
                System.out.println("Updated apartment successfully.");
            } else {
                System.out.println("Invalid update apartment command format.");
            }
        } else if (command.startsWith("delete apartment")) {
            // Команда для видалення квартири за id
            Pattern pattern = Pattern.compile("id=(\\d+)");
            Matcher matcher = pattern.matcher(command);
            if (matcher.find()) {
                int id = Integer.parseInt(matcher.group(1));
                apartmentDAO.deleteApartment(id);
                System.out.println("Deleted apartment successfully.");
            } else {
                System.out.println("Invalid delete apartment command format.");
            }
        } else if (command.startsWith("read apartment")) {
            // Команда для зчитування всіх квартир
            apartmentDAO.getAllApartments();

        } else {
            System.out.println("Unknown command. Please try again.");
        }
    }
}

