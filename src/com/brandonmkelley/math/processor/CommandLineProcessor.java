/**
 * CommandLineProcessor.java
 *
 * This class is the commandline parser that returns
 * the correct processor for the program after satisfying
 * the commandline arguments.
 */

package com.brandonmkelley.math.processor;

import com.brandonmkelley.math.processor.Processor;
import com.brandonmkelley.math.processor.FinishProcessor;

public class CommandLineProcessor extends Processor {
  
  private String[] _args;
  private Processor _commanded;
  
  public CommandLineProcessor(String[] args) {
    _args = args;
  }
  
  public void process() {
    _commanded = new FinishProcessor();
  }
  
  public Processor getNext() {
    return _commanded;
  }
  
  public boolean hasNextProcessor() {
    return Processor._HAS_NEXT;
  }
  
}
