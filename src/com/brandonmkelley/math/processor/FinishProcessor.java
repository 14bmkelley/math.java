/**
 * FinishProcessor.java
 *
 * This class processes whether the user is ready
 * for the program to end.
 */

package com.brandonmkelley.math.processor;

import java.util.Scanner;

import com.brandonmkelley.math.processor.Processor;
import com.brandonmkelley.math.processor.StartProcessor;

public class FinishProcessor extends Processor {
  
  private boolean _hasNext;
  private Processor _next;
  private Scanner _in;
  private String _input;
  
  public FinishProcessor() {
    super();
    _hasNext = Processor._HAS_NEXT;
    _in = new Scanner(System.in);
    _input = "";
  }
  
  public FinishProcessor(boolean hasNext) {
    this();
    _hasNext = hasNext;
  }
  
  public void process() {
    
    System.out.println("Are you finished using this program (Y/n)?");
    
    _input = _in.nextLine().toLowerCase();
    
    if (_input.equals("n")) {
      _next = new StartProcessor();
    } else {
      _next = new FinishProcessor(Processor._EXIT);
    }
    
    if (!_input.equals("")) {
      System.out.println();
    }
    
  }
  
  public Processor getNext() {
    return _next;
  }
  
  public boolean hasNextProcessor() {
    return _hasNext;
  }
  
}
