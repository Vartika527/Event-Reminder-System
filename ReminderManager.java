package Event_Reminder_System;

import java.util.ArrayList;

public class ReminderManager {
    private ArrayList<Event> events;

    // Constructor
    public ReminderManager() {
        events = new ArrayList<>();
    }

    // Add Event
    public void addEvent(Event e) {
        events.add(e);
        System.out.println("Event added successfully!");
    }

    // View All Events
    public void viewEvents() {
        if (events.isEmpty()) {
            System.out.println("No events to display.");
            return;
        }

        for (int i = 0; i < events.size(); i++) {
            Event e = events.get(i);
            System.out.println((i + 1) + ". " + e.getTitle());
            System.out.println("   Description: " + e.getDescription());
            System.out.println("   Date: " + e.getDate());
            System.out.println("   Status: " + (e.getStatus() ? "Completed" : "Pending"));
            System.out.println();
        }
    }

    // Show Only Completed Events
    public void showCompletedEvents() {
        boolean found = false;

        for (int i = 0; i < events.size(); i++) {
            Event e = events.get(i);
            if (e.getStatus()) {
                found = true;
                System.out.println((i + 1) + ". " + e.getTitle());
                System.out.println("   Description: " + e.getDescription());
                System.out.println("   Date: " + e.getDate());
                System.out.println();
            }
        }

        if (!found) {
            System.out.println("No completed events.");
        }
    }

    // Mark Event as Completed
    public void updateEventStatus(int index) {
        if (index <= 0 || index > events.size()) {
            System.out.println("Invalid event number!");
            return;
        }

        events.get(index - 1).setStatus(true);
        System.out.println("Event marked as completed!");
    }

    // Remove Event
    public void removeEvent(int index) {
        if (index <= 0 || index > events.size()) {
            System.out.println("Invalid event number!");
            return;
        }

        events.remove(index - 1);
        System.out.println("Event removed successfully!");
    }
}
