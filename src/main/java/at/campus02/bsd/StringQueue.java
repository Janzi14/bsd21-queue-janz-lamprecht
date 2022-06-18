package at.campus02.bsd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class StringQueue implements IQueue {

  private List<String> elements = new ArrayList<String>();
  private int maxSize; // removed redundant initializer
  /**
   * reassigns new size to queue
   *
   * @param maxsize
   */
  public StringQueue(int maxsize) {
    this.maxSize = maxsize;
  } // resolved constructor problems
  /**
   * add offer to List 'elements'
   *
   * @param obj
   * @return boolean
   */
  @Override
  public boolean offer(String obj) {
    if (elements.size() != maxSize) {
      elements.add(obj);
    } else {
      return false;
    }
    return true;
  }
  /**
   * takes out first String in queue
   *
   * @return String
   */
  @Override
  public String poll() {
    String element = peek();

    if (elements.size() != 0) { // removed potential OutOfBounds Exception
      elements.remove(0);
    }

    return element;
  }
  /**
   * removes first element in queue with exception handling
   * @return String
   */
  @Override
  public String remove() {
    String element = poll();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }
  /**
   * fetches first String in queue without removing the Drink in its queue
   *
   * @return String
   */
  @Override
  public String peek() {
    String element;
    if (elements.size() > 0)
      element = elements.get(0);
    else
      element = null;

    return element;
  }
  /**
   * fetches first String in queue without removing the String in its queue with exception handling
   *
   * @return String
   */
  @Override
  public String element() { // duplicate to peek
    String element = peek();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

}// removed s