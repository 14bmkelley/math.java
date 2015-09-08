/**
 * AdditionProcessor.java
 *
 * This class adds vectors.
 */

package com.brandonmkelley.math.processor.vector;

import java.util.Scanner;

import com.brandonmkelley.math.processor.Processor;
import com.brandonmkelley.math.processor.FinishProcessor;
import com.brandonmkelley.math.processor.util.ParsableQuestion;
import com.brandonmkelley.math.datatype.Vector;

public class DotProductProcessor extends Processor {
  
  private Processor _next;
  private Scanner _in;
  private String _input;
  private Vector _v1;
  private Vector _v2;
  
  public DotProductProcessor() {
    super();
    _in = new Scanner(System.in);
    _input = "";
    _v1 = new Vector();
    _v2 = new Vector();
  }
  
  public void process() {
    
    String question = "Please enter the first vector (?, ?, ?): ";
    ParsableQuestion q = new ParsableQuestion(question, new Vector());
    _v1 = (Vector) q.choose();
    
    q.setQuestion("Please enter the second vector (?, ?, ?): ");
    q.setParsable(new Vector());
    _v2 = (Vector) q.choose();
    
    System.out.print("The dot product of these two vectors is: ");
    System.out.println(_v1.dot(_v2));
    System.out.println();
    
    _next = new FinishProcessor();
    
  }
  
  public Processor getNext() {
    return _next;
  }
  
  public boolean hasNextProcessor() {
    return Processor._HAS_NEXT;
  }
  
}
