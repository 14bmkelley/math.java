/**
 * ParsableQuestion.java
 *
 * This class is for use in a processor and
 * handles a question to the user and the
 * corresponding response.
 */

package com.brandonmkelley.math.processor.util;

import com.brandonmkelley.math.datatype.Parsable;

import java.util.Scanner;

public class ParsableQuestion {
  
  private String _question;
  private Parsable _result;
  
  public ParsableQuestion() {
    _question = "";
    _result = null;
  }
  
  public ParsableQuestion(String question) {
    this();
    _question = question;
  }
  
  public ParsableQuestion(String question, Parsable result) {
    this(question);
    _result = result;
  }
  
  public void setQuestion(String question) {
    _question = question;
  }
  
  public void setParsable(Parsable object) {
    _result = object;
  }
  
  public Parsable choose() {
    
    Scanner in = new Scanner(System.in);
    String input = "";
    
    do {
      System.out.print(_question);
      input = in.nextLine();
      _result.parse(input);
    } while (!_result.isParsed());
    
    return _result;
    
  }
  
}
