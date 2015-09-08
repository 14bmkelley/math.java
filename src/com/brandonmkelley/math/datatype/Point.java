/**
 * Point.java
 *
 * This class creates a Point object for manipulation
 * in problems.
 */

package com.brandonmkelley.math.datatype;

public class Point implements Parsable {
  
  private double _x, _y, _z;
  private boolean _isParsed;
  private boolean _is3D;
  
  public Point() {
    _x = _y = _z = 0;
    _isParsed = false;
    _is3D = true;
  }
  
  public Point(int x, int y) {
    _x = x;
    _y = y;
    _isParsed = false;
    _is3D = false;
  }
  
  public Point(double x, double y) {
    _x = x;
    _y = y;
    _isParsed = false;
    _is3D = false;
  }
  
  public Point(int x, int y, int z) {
    _x = x;
    _y = y;
    _z = z;
    _isParsed = false;
    _is3D = true;
  }
  
  public Point(double x, double y, double z) {
    _x = x;
    _y = y;
    _z = z;
    _isParsed = false;
    _is3D = true;
  }
  
  public boolean isParsed() {
    return _isParsed;
  }
  
  public boolean is3D() {
    return _is3D;
  }
  
  public void parse(String point) {
    int marker = 0;
    String[] coords = new String[3];
    int coordsCount = 0;
    for (int i = 0; i < point.length(); i++) {
      if (point.charAt(i) == ')' || point.charAt(i) == ' ') {
        marker = i;
      } else if (point.charAt(i) == ')' || point.charAt(i) == ',') {
        if (coordsCount == 3) {
          return;
        }
        coords[coordsCount] = point.substring(marker + 1, i);
        coordsCount++;
      }
    }
    if (coordsCount == 2) {
      _isParsed = true;
      _x = Double.parseDouble(coords[0]);
      _y = Double.parseDouble(coords[1]);
      _is3D = false;
    }
    if (coordsCount == 3) {
      _z = Double.parseDouble(coords[2]);
      _is3D = true;
    }
  }
  
  @Override
  public String toString() {
    if (_is3D) {
      return "(" + _x + ", " + _y + ", " + _z + ")";
    }
    return "(" + _x + ", " + _y + ")";
  }
  
}
