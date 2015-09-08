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

public class CrossProductProcessor extends Processor {
  
  private Processor _next;
  private Scanner _in;
  private String _input;
  private Vector _v1;
  private Vector _v2;
  
  public CrossProductProcessor() {
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
    
    Vector out = new Vector();
    
    System.out.print("v1 cross v2 is: ");
    System.out.println(out.cross(_v1, _v2));
    System.out.print("v2 cross v1 is: ");
    System.out.println(out.cross(_v2, _v1));
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
