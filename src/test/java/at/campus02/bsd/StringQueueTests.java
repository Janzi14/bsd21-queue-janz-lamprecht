package at.campus02.bsd;

import at.campus02.bsd.drinks.Liquid;
import at.campus02.bsd.drinks.SimpleDrink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class StringQueueTests {

    StringQueue stringQueue;

    @BeforeEach
    public void setUp(){
        stringQueue = new StringQueue(8);
    }
    @Test
    void offerTest1(){
        Boolean result = stringQueue.offer("appleJuice");
        assertEquals(true, result);
    }
    @Test
    void offerTest2() {
        stringQueue.offer("word");
        stringQueue.offer("letter");
        stringQueue.offer("sentence");
        stringQueue.offer("anotherWord");
        stringQueue.offer("anotherSentence");
        stringQueue.offer("thirdWord");
        stringQueue.offer("forthWord");
        stringQueue.offer("Word");
        assertEquals(false, stringQueue.offer("p"));
    }

    @Test
    void pollTest1(){
        stringQueue.offer("appleJuice");
        String result = stringQueue.poll();
        assertEquals("appleJuice" ,result);
    }
    @Test void  pollTest2() {
        assertEquals(null, stringQueue.poll());
    }

    @Test
    void removeTest(){
        stringQueue.offer("appleJuice");
        String result = stringQueue.remove();
        assertEquals("appleJuice" ,result);
    }
    @Test
    void removeTest2() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            stringQueue.remove();
        });
    }
    @Test
    void peekTest1(){
        assertEquals(null, stringQueue.peek());
    }

    @Test
    void peekTest2() {
        stringQueue.offer("sentence");
        stringQueue.offer("paragraph");
        assertEquals("sentence", stringQueue.peek());
    }

    @Test
    void elementTest1(){
        stringQueue.offer("appleJuice");
        assertEquals("appleJuice", stringQueue.element());
    }
    @Test
    void elementTest2() {
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            stringQueue.element();
        });
    }
}
