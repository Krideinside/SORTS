package ru.netology.javaqa;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

class AviaSoulsTest {
    AviaSouls manager = new AviaSouls();
    Ticket t1 = new Ticket("Москва", "Санкт-Петербург", 1500, 10, 15); //5 часов
    Ticket t2 = new Ticket("Казань", "Москва", 1400, 17, 20);
    Ticket t3 = new Ticket("Москва", "Иркутск", 2000, 8, 12);
    Ticket t4 = new Ticket("Москва", "Санкт-Петербург", 1200, 11, 13);  //2 часа
    Ticket t5 = new Ticket("Москва", "Санкт-Петербург", 1000, 7, 12);  //5 часов
    Ticket t6 = new Ticket("Иркутск", "Казань", 1700, 3, 17);
    Ticket t7 = new Ticket("Москва", "Санкт-Петербург", 1100, 15, 18);  //3 часа
    Ticket t8 = new Ticket("Москва", "Санкт-Петербург", 1800, 1, 4);  //3 часа

    @Test
    public void shouldSortTickets() {

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {t5, t7, t4, t1, t8};
        Ticket[] actual = manager.search("Москва", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSort1Ticket() {

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {t6};
        Ticket[] actual = manager.search("Иркутск", "Казань");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortNoTickets() {

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Лес", "Дом");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSortTicketsWithComparator() {

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {t4, t7, t8, t1, t5};
        Ticket[] actual = manager.search("Москва", "Санкт-Петербург", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSort1TicketWithComparator() {

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {t2};
        Ticket[] actual = manager.search("Казань", "Москва", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldSortNoTicketWithComparator() {

        manager.add(t1);
        manager.add(t2);
        manager.add(t3);
        manager.add(t4);
        manager.add(t5);
        manager.add(t6);
        manager.add(t7);
        manager.add(t8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] expected = {};
        Ticket[] actual = manager.search("Дом", "Работа", comparator);

        Assertions.assertArrayEquals(expected, actual);

    }
}