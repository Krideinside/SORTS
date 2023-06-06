package ru.netology.javaqa;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class AviaSoulsTest {
    Ticket t1 = new Ticket(
            "Москва",
            "Санкт-Петербург",
            1500,
            1000,
            1500
    );

    Ticket t2 = new Ticket(
            "Казань",
            "Москва",
            1400,
            1700,
            2000
    );

//    Ticket t3 = new Ticket(
//            "Москва",
//            "Иркутск",
//            2000,
//            800,
//            1200
//    );

    @Test
    public void shouldCompareT1andT2() {

        int expected = -1;
        int actual = t1.compareTo(t2);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsByPrice() {
        TicketPriceComparator priceComparator = new TicketPriceComparator();

        Ticket[] tickets = { t1, t2 };
        Arrays.sort(tickets, priceComparator);
    }

    @Test
    public void search(){
        TicketPriceComparator priceComparator = new TicketPriceComparator();

        Ticket[] tickets = {t1, t2};
        Arrays.sort(tickets, priceComparator);
    }

    @Test
    public void shouldSortByTime(){
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        Ticket[] tickets = {t1, t2};
        Arrays.sort(tickets, timeComparator);
    }
}