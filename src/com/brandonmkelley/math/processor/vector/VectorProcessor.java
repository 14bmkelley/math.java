/**
 * VectorProcessor.java
 *
 * This class represents the router for the vector
 * portion of the math program
 */

package com.brandonmkelley.math.processor.vector;

import com.brandonmkelley.math.processor.Processor;
import com.brandonmkelley.math.processor.FinishProcessor;
import com.brandonmkelley.math.processor.vector.AdditionProcessor;
import com.brandonmkelley.math.processor.util.OptionMenu;

public class VectorProcessor extends Processor {
  
  private Processor _next;
  
  public void process() {
    
    String question = "What kind of vector problem would you like to solve?";
    
    String[] options = new String[4];
    options[0] = "Addition";
    options[1] = "Subtraction";
    options[2] = "Dot Product";
    options[3] = "Cross Product";
    
    OptionMenu menu = new OptionMenu(question, options);
    
    String userChoice = menu.choose();
    
    if (userChoice.equals("Addition")) {
      _next = new AdditionProcessor();
    } else if (userChoice.equals("Subtraction")) {
      _next = new SubtractionProcessor();
    } else if (userChoice.equals("Dot Product")) {
      _next = new DotProductProcessor();
    } else if (userChoice.equals("Cross Product")) {
      _next = new CrossProductProcessor();
    } else {
      System.out.println("There was an errorrrrrrr.");
    }
    
  }
  
  public Processor getNext() {
    return _next;
  }
  
  public boolean hasNextProcessor() {
    return Processor._HAS_NEXT;
  }
  
}
