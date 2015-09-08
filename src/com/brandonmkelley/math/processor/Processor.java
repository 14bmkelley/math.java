/**
 * Processor.java
 *
 * This class serves to create a base class for all
 * processors that will interact with the user. Each 
 * processor is to extend this.
 */

package com.brandonmkelley.math.processor;

public abstract class Processor {
  
  public static final boolean _HAS_NEXT = true;
  public static final boolean _EXIT = false;
  
  public abstract void process();
  public abstract Processor getNext();
  public abstract boolean hasNextProcessor();
  
}
