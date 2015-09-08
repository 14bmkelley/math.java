/**
 * StartProcessor.java
 *
 * This class begins the program if commandline
 * arguments weren't specified.
 */

package com.brandonmkelley.math.processor;

import com.brandonmkelley.math.processor.Processor;
import com.brandonmkelley.math.processor.FinishProcessor;
import com.brandonmkelley.math.processor.vector.VectorProcessor;
import com.brandonmkelley.math.processor.util.OptionMenu;

public class StartProcessor extends Processor {
  
  private Processor _next;
  
  public void process() {
    
    String question = "What kind of problem would you like to work solve?";
    
    String[] options = new String[1];
    options[0] = "Vector";
    
    OptionMenu menu = new OptionMenu(question, options);
    String userChoice = menu.choose();
    
    if (userChoice.equals("Vector")) {
      _next = new VectorProcessor();
    } else {
      _next = new FinishProcessor();
    }
    
  }
  
  public Processor getNext() {
    return _next;
  }
  
  public boolean hasNextProcessor() {
    return Processor._HAS_NEXT;
  }
  
}
