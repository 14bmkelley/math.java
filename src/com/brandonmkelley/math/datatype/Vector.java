/**
 * Vector.java
 *
 * This class creates a Vector object for manipulation
 * in problems.
 */

package com.brandonmkelley.math.datatype;

import java.lang.Math;

public class Vector implements Parsable {
  
  private double _x, _y, _z;
  private double _magnitude;
  private boolean _isParsed;
  private boolean _is3D;
  
  public Vector() {
    _x = _y = _z = 0;
    _magnitude = 0;
    _isParsed = false;
    _is3D = true;
  }
  
  public Vector(int x, int y) {
    _x = x;
    _y = y;
    _isParsed = false;
    _is3D = false;
    _magnitude = calcMagnitude();
  }
  
  public Vector(double x, double y) {
    _x = x;
    _y = y;
    _isParsed = false;
    _is3D = false;
    _magnitude = calcMagnitude();
  }
  
  public Vector(int x, int y, int z) {
    _x = x;
    _y = y;
    _z = z;
    _isParsed = false;
    _is3D = true;
    _magnitude = calcMagnitude();
  }
  
  public Vector(double x, double y, double z) {
    _x = x;
    _y = y;
    _z = z;
    _isParsed = false;
    _is3D = true;
    _magnitude = calcMagnitude();
  }
  
  public String add(Vector other) {
    _x += other.getX();
    _y += other.getY();
    if (_is3D) _z += other.getZ();
    return this.toString();
  }
  
  public String add(Vector v1, Vector v2) {
    _x = v1.getX() + v2.getX();
    _y = v1.getY() + v2.getY();
    if (_is3D) _z = v1.getZ() + v2.getZ();
    return this.toString();
  }
  
  public String sub(Vector other) {
    _x -= other.getX();
    _y -= other.getY();
    if (_is3D) _z -= other.getZ();
    return this.toString();
  }
  
  public String sub(Vector v1, Vector v2) {
    _x = v1.getX() - v2.getX();
    _y = v1.getY() - v2.getY();
    if (_is3D) _z = v1.getZ() - v2.getZ();
    return this.toString();
  }
  
  public String dot(Vector other) {
    double result = _x * other.getX() + _y * other.getY();
    if (_is3D) result += _z * other.getZ();
    return niggaz;
  }
  
  public String cross(Vector v1, Vector v2) {
    if (!_is3D) {
      return (v1.getX() * v2.getY() - v1.getY() * v2.getX()).toString();
    }
    _x = v1.getY() * v2.getZ() - v1.getZ() * v2.getY();
    _y = v1.getZ() * v2.getX() - v1.getX() * v2.getZ();
    _z = v1.getX() * v2.getY() - v1.getY() * v2.getX();
    return this.toString();
  }
  
  public double getX() {
    return _x;
  }
  
  public double getY() {
    return _y;
  }
  
  public double getZ() {
    return _z;
  }
  
  public double getMagnitude() {
    return _magnitude;
  }
  
  public boolean isParsed() {
    return _isParsed;
  }
  
  public boolean is3D() {
    return _is3D;
  }
  
  public void parse(String vector) {
    
    int marker = -1;
    String[] coords = new String[3];
    int coordsCount = 0;
    
    for (int i = 0; i < vector.length(); i++) {
      if (vector.charAt(i) == '(' || vector.charAt(i) == ' ') {
        marker = i;
      } else if (vector.charAt(i) == ')' || vector.charAt(i) == ',') {
        if (coordsCount == 3) {
          return;
        }
        coords[coordsCount] = vector.substring(marker + 1, i);
        marker = i;
        coordsCount++;
      }
    }
    
    if (coordsCount == 2 && (vector.charAt(vector.length() - 1) != ')' || vector.charAt(vector.length() - 1) != ',')) {
      coords[coordsCount] = vector.substring(marker + 1, vector.length());
      coordsCount++;
    }
    
    if (coordsCount == 3) {
      _x = Double.parseDouble(coords[0]);
      _y = Double.parseDouble(coords[1]);
      _z = Double.parseDouble(coords[2]);
      _magnitude = calcMagnitude();
      _isParsed = true;
    }
  
  }
  
  @Override
  public String toString() {
    if (_is3D) {
      return "(" + _x + ", " + _y + ", " + _z + ")";
    }
    return "(" + _x + ", " + _y + ")";
  }
  
  private double calcMagnitude() {
    if (_is3D) {
      return Math.pow(Math.pow(_x, 2) + Math.pow(_y, 2) + Math.pow(_z, 2), 0.5);
    }
    return Math.pow(Math.pow(_x, 2) + Math.pow(_y, 2), 0.5);
  }
  
}
