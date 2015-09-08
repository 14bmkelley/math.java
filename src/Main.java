/**
 * Main.java
 *
 * This file is the entrance for this math application.
 * It handles all user input and manages the work flow
 * of the application.
 *
 */

import com.brandonmkelley.math.processor.Processor;
import com.brandonmkelley.math.processor.CommandLineProcessor;
import com.brandonmkelley.math.processor.StartProcessor;

public class Main {
  
  public static void main(String[] args) {
    
    Processor currentMenu;
    
    if (args.length > 0) {
      currentMenu = new CommandLineProcessor(args);
      currentMenu.process();
      currentMenu = currentMenu.getNext();
    } else {
      currentMenu = new StartProcessor();
    }
    
    while (currentMenu.hasNextProcessor()) {
      currentMenu.process();
      currentMenu = currentMenu.getNext();
    }
    
    System.out.println("Done.");
    
  }
  
}
