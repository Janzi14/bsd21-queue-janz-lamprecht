package at.campus02.bsd;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


public class StringQueue implements IQueue {

  private List<String> elements = new ArrayList<String>(); // shall we change it to proper "deque"?
  private int maxSize; // removed redundant initializer

  public StringQueue(int maxsize) {
    this.maxSize = maxsize;
  } // resolved constructor problems

  @Override
  public boolean offer(String obj) {
    if (elements.size() != maxSize) {
      elements.add(obj);
    } else {
      return false;
    }
    return true;
  }

  @Override
  public String poll() {
    String element = peek();

    if (elements.size() == 0) {
      elements.remove(0); // causes OutOfBoundsException!
    }

    return element;
  }

  @Override
  public String remove() { // inefficient, but stable
    String element = poll();
    element = "";
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

  @Override
  public String peek() {
    String element;
    if (elements.size() > 0)
      element = elements.get(0);
    else
      element = null;

    return element;
  }

  @Override
  public String element() { // duplicate to peek
    String element = peek();
    if (element == null)
      throw new NoSuchElementException("there's no element any more");

    return element;
  }

}// removed s