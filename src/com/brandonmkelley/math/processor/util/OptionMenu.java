/**
 * OptionMenu.java
 *
 * This class is for use in a processor and
 * handles giving the user options to choose from.
 */

package com.brandonmkelley.math.processor.util;

import java.util.ArrayList;
import java.util.Scanner;

public class OptionMenu {
  
  private String _question;
  private ArrayList<String> _options;
  
  public OptionMenu() {
    _question = "";
    _options = new ArrayList<String>();
  }
  
  public OptionMenu(String question) {
    this();
    _question = question;
  }
  
  public OptionMenu(String question, ArrayList<String> options) {
    this(question);
    _options = options;
  }
  
  public OptionMenu(String question, String[] options) {
    this(question);
    for (int i = 0; i < options.length; i++) {
      _options.add(options[i]);
    }
  }
  
  public String choose() {
    
    boolean chosen = false;
    int chosenNum = 0;
    String input = "";
    
    do {
      
      System.out.println(_question + " (1-" + _options.size() + ")");
      
      for (int i = 0; i < _options.size(); i++) {
        System.out.print(i + 1);
        System.out.println(") " + _options.get(i));
      }
      
      System.out.println();
      
      Scanner in = new Scanner(System.in);
      input = in.next();
      
      for (int i = 0; i < _options.size(); i++) {
        if (String.valueOf(i + 1).equals(input)) {
          chosen = true;
          chosenNum = i;
        }
      }
      
      System.out.println();
      
      if (!chosen) {
        System.out.println("Please choose a valid option.");
      }
    
    } while (!chosen);
    
    return _options.get(chosenNum);
  
  }
  
}
