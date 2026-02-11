package Event_Reminder_System;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Executer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ReminderManager manager = new ReminderManager();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        while (true) {
            System.out.println("\n===== Event Reminder System =====");
            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Mark Event as Completed");
            System.out.println("4. Remove Event");
            System.out.println("5. Show Completed Events");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();

                    System.out.print("Enter description: ");
                    String description = sc.nextLine();

                    LocalDate date = null;
                    while (date == null) {
                        System.out.print("Enter date (yyyy-MM-dd): ");
                        String dateInput = sc.nextLine();

                        try {
                            date = LocalDate.parse(dateInput, formatter);
                        } catch (DateTimeParseException e) {
                            System.out.println("Invalid date format! Try again.");
                        }
                    }

                    Event event = new Event(title, description, date);
                    manager.addEvent(event);
                    break;

                case 2:
                    manager.viewEvents();
                    break;

                case 3:
                    System.out.print("Enter event number to mark as completed: ");
                    try {
                        int index = Integer.parseInt(sc.nextLine());
                        manager.updateEventStatus(index);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number!");
                    }
                    break;

                case 4:
                    System.out.print("Enter event number to remove: ");
                    try {
                        int index = Integer.parseInt(sc.nextLine());
                        manager.removeEvent(index);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid number!");
                    }
                    break;

                case 5:
                    manager.showCompletedEvents();
                    break;

                case 6:
                    System.out.println("Thank you for using Event Reminder System!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice! Please select from 1 to 6.");
            }
        }
    }
}
s