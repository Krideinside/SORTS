package ru.netology.javaqa;
import java.util.Comparator;

public class TicketPriceComparator implements Comparator<Ticket> {
    @Override
    public int compare(Ticket t1, Ticket t2) {
        if (t1.getPrice() < t2.getPrice()) {
            return -1;
        } else if (t1.getPrice() > t2.getPrice()) {
            return 1;
        } else {
            return 0;
        }
    }
}
