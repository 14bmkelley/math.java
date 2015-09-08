/**
 * AdditionProcessor.java
 *
 * This class adds vectors.
 */

package com.brandonmkelley.math.processor.vector;

import java.util.Scanner;

import com.brandonmkelley.math.datatype.Vector;
import com.brandonmkelley.math.processor.Processor;
import com.brandonmkelley.math.processor.FinishProcessor;
import com.brandonmkelley.math.processor.util.OptionMenu;
import com.brandonmkelley.math.processor.util.ParsableQuestion;

public class AdditionProcessor extends Processor {
  
  private Processor _next;
  private String _q1;
  private String _q2;
  private Scanner _in;
  private String _input;
  private Vector _v1;
  private Vector _v2;
  
  public AdditionProcessor() {
    super();
    _q1 = "Please enter the first vector";
    _q2 = "Please enter the second vector";
    _in = new Scanner(System.in);
    _input = "";
    _v1 = new Vector();
    _v2 = new Vector();
  }
  
  public void process() {
    
    String question = "Choose the number of dimensions: ";
    String[] options = new String[2];
    options[0] = "2";
    options[1] = "3";
    OptionMenu menu = new OptionMenu(question, options);
    String option = menu.choose();
    
    if (option.equals("2")) {
      _q1 += " (?, ?): ";
      _q2 += " (?, ?): ";
    } else {
      _q1 += " (?, ?, ?): ";
      _q2 += " (?, ?, ?): ";
    }
    
    ParsableQuestion q = new ParsableQuestion();
    
    q.setQuestion(_q1);
    q.setParsable(new Vector());
    _v1 = (Vector) q.choose();
    
    q.setQuestion(_q2);
    q.setParsable(new Vector());
    _v2 = (Vector) q.choose();
    
    System.out.print("The sum of these two vectors is: ");
    System.out.println(_v1.add(_v2));
    System.out.println();
    
    _next = new FinishProcessor();
    
  }
  
  public Processor getNext() {
    if (_next != null) {
      return _next;
    }
  }
  
  public boolean hasNextProcessor() {
    return Processor._HAS_NEXT;
  }
  
}
