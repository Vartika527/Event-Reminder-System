package Event_Reminder_System;

import java.time.LocalDate;

public class Event {
    private String title;
    private String description;
    private LocalDate date;
    private boolean isCompleted;

    // Constructor
    public Event(String title, String description, LocalDate date) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.isCompleted = false; // default status
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public LocalDate getDate() {
        return date;
    }

    public boolean getStatus() {
        return isCompleted;
    }

    // Setter
    public void setStatus(boolean status) {
        this.isCompleted = status;
    }
}
