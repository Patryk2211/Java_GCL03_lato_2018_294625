/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.logic;

import java.util.Scanner;
import com.example.calculator.basic.*;

/**
 *
 * @author pbukowsk
 */
public class ConeCalculator implements Calculator
{
    double radius = 0;
    final double PI = Math.PI;
    double area = 0;
    double perimeter = 0;

    @Override
    public double calculateBaseArea() {
        System.out.println("Podaj promień podstawy: ");
        Scanner read = new Scanner(System.in);
        radius = read.nextDouble();
        area = PI*radius*radius;
        System.out.print("Pole podstawy wynosi: " + area);
       
        return area;
    }

    @Override
    public double calculateBasePerimeter() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
