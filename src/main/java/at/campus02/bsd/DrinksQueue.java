package at.campus02.bsd;

import at.campus02.bsd.drinks.Drink;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DrinksQueue implements IDrinksQueue {
    private List<Drink> elements = new ArrayList<>();
    private int maxSize;

    /**
     * add offer to List 'elements'
     *
     * @param obj
     * @return boolean
     */
    @Override
    public boolean offer(Drink obj) {
        if (elements.size() != maxSize) {
            elements.add(obj);
        } else {
            return false;
        }
        return true;
    }

    /**
     * reassigns new size to queue
     *
     * @param maxsize
     */
    public DrinksQueue(int maxsize) {
        this.maxSize = maxsize;
    }

    /**
     * takes out first Drink in queue
     *
     * @return Drink
     */
    @Override
    public Drink poll() {
        Drink element = peek();

        if (elements.size() != 0) {
            elements.remove(0);
        }

        return element;
    }
    /**
     * removes first element in queue with exception handling
     * @return Drink
     */
    @Override
    public Drink remove() {
        Drink element = poll();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

    /**
     * fetches first Drink in queue without removing the Drink in its queue
     *
     * @return Drink
     */
    @Override
    public Drink peek() {
        Drink element;
        if (elements.size() > 0)
            element = elements.get(0);
        else
            element = null;

        return element;
    }

    /**
     * fetches first Drink in queue without removing the Drink in its queue with exception handling
     *
     * @return Drink
     */
    @Override
    public Drink element() {
        Drink element = peek();
        if (element == null)
            throw new NoSuchElementException("there's no element any more");

        return element;
    }

}
