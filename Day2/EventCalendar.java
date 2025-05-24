import java.util.List;
import java.util.ArrayList;
import java.util.TreeMap;

class Event {
    String title;
    String time;
    String description;

    public Event(String title, String time, String description) {
        this.title = title;
        this.time = time;
        this.description = description;
    }

    @Override
    public String toString() {
        return time + " - " + title + ": " + description;
    }
}

public class EventCalendar {
    private TreeMap<String, List<Event>> calendar;

    public EventCalendar() {
        calendar = new TreeMap<>();
    }

    public void addEvent(String date, Event event) {
        calendar.computeIfAbsent(date, k -> new ArrayList<>()).add(event);
    }
    public void removeEvent(String date, String title) {
        List<Event> events = calendar.get(date);
        if (events != null) {
            events.removeIf(e -> e.title.equalsIgnoreCase(title));
            if (events.isEmpty()) {
                calendar.remove(date);
            }
        }
    }
    public void displayEvents(String date) {
        List<Event> events = calendar.get(date);
        if (events == null || events.isEmpty()) {
            System.out.println("No events on " + date);
        } else {
            System.out.println("Events on " + date + ":");
            for (Event e : events) {
                System.out.println("  " + e);
            }
        }
    }

    // Display all upcoming events
    public void displayAllEvents() {
        if (calendar.isEmpty()) {
            System.out.println("No upcoming events.");
        } else {
            System.out.println("All Upcoming Events:");
            for (String date : calendar.keySet()) {
                System.out.println("Date: " + date);
                for (Event e : calendar.get(date)) {
                    System.out.println("  " + e);
                }
            }
        }
    }

    public static void main(String[] args) {
        EventCalendar ec = new EventCalendar();

        ec.addEvent("2025-05-23", new Event("Team Meeting", "10:00 AM", "Discuss sprint goals"));
        ec.addEvent("2025-05-23", new Event("Doctor Visit", "3:00 PM", "Eye check-up"));
        ec.addEvent("2025-05-24", new Event("Birthday Party", "7:00 PM", "Rohan's birthday"));

        ec.displayEvents("2025-05-23");
        System.out.println();

        ec.removeEvent("2025-05-23", "Doctor Visit");

        ec.displayEvents("2025-05-23");
        System.out.println();

        ec.displayAllEvents();
    }
}