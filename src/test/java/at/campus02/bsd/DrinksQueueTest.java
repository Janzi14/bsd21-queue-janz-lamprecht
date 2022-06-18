package at.campus02.bsd;

import at.campus02.bsd.drinks.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class DrinksQueueTest {

    private DrinksQueue drinksQueue;
    private SimpleDrink vodka;
    private SimpleDrink juice;


    @BeforeEach
    public void setUp(){
        drinksQueue = new DrinksQueue(5);
        Liquid liquid1 = new Liquid("part1", 1.0, 0);
        Liquid liquid2 = new Liquid("part2", 2.0, 1.0);
        vodka = new SimpleDrink("part1", liquid1);
        juice = new SimpleDrink("part2", liquid2);
    }

    @Test
    void offer1() {
        assertEquals(true, drinksQueue.offer(vodka));
    }

    @Test
    void offer2() {
        drinksQueue.offer(vodka);
        drinksQueue.offer(juice);
        drinksQueue.offer(vodka);
        drinksQueue.offer(juice);
        drinksQueue.offer(juice);
        assertEquals(false, drinksQueue.offer(vodka));
    }


    @Test
    void poll1() {
        drinksQueue.offer(vodka);
        drinksQueue.offer(juice);
        assertEquals(vodka, drinksQueue.poll());
    }

    @Test
    void poll2() {
        assertEquals(null, drinksQueue.poll());
    }

    @Test
    void remove1() {
        drinksQueue.offer(vodka);
        drinksQueue.offer(juice);
        assertEquals(vodka, drinksQueue.remove());
    }

    @Test
    void remove2() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            drinksQueue.remove();
        });
    }

    @Test
    void peek1() {
        drinksQueue.offer(vodka);
        drinksQueue.offer(juice);
        assertEquals(vodka, drinksQueue.peek());
    }

    @Test
    void peek2() {
        assertEquals(null, drinksQueue.peek());
    }

    @Test
    void element1() {
        drinksQueue.offer(vodka);
        drinksQueue.offer(juice);
        assertEquals(vodka, drinksQueue.element());
    }

    @Test
    void element2() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            drinksQueue.element();
        });
    }

}
