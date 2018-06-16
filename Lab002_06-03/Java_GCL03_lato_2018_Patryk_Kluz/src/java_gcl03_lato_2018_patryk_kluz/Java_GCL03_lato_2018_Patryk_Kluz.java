/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package java_gcl03_lato_2018_patryk_kluz;

import java.util.Scanner;
import com.example.calculator.basic.*;

/**
 *
 * @author pbukowsk
 */
public class Java_GCL03_lato_2018_Patryk_Kluz {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int pick;
        Scanner read;
        
        System.out.println("1. Stożek");
        System.out.println("2. Czworościan");
        System.out.println("3. Wyjście");
        System.out.println("Twój wybór: ");
        read = new Scanner(System.in);
        pick = read.nextInt();
        
        switch(pick)
        {
            case 1:
                ConeCalculator cone = new ConeCalculator();
                System.out.println("1. Pole podstawy");
                System.out.println("2. Obwód podstawy");
                 System.out.println("Twój wybór: ");
                Scanner read2 = new Scanner(System.in);
                int pick2 = read2.nextInt();
                
                switch(pick2)
                {
                    case 1:
                        cone.calculateBaseArea();
                        break;
                    case 2:
                        cone.calculateBasePerimeter();
                        break;
                }
                
                break;
            case 2: 
                TetrahedronCalculator hedron = new TetrahedronCalculator();
                System.out.println("1. Pole podstawy");
                System.out.println("2. Obwód podstawy");
                System.out.println("Twój wybór: ");
                Scanner read3 = new Scanner(System.in);
                int pick3 = read3.nextInt();
                
                switch(pick3)
                {
                    case 1:
                        hedron.calculateBaseArea();
                        break;
                    case 2:
                        hedron.calculateBasePerimeter();
                        break;
                }
                
                break;
            case 3:
                System.exit(pick);
        }
        
    }
    
}



    @Override
    public double calculateBasePerimeter() {
        System.out.println("Podaj promień podstawy: ");
        Scanner read = new Scanner(System.in);
        radius = read.nextDouble();
        perimeter = 2*PI*radius;
        System.out.print("Obwód podstawy wynosi: " + perimeter);
       
        return perimeter;
    }
    
}

public class TetrahedronCalculator implements Calculator
{
    double side = 0;
    double area = 0;
    double perimeter = 0;
    
    @Override
    public double calculateBaseArea() {
        System.out.println("Podaj bok podstawy (trójkąt równoboczny): ");
        Scanner read = new Scanner(System.in);
        side = read.nextDouble();
        area = (side*side*(Math.sqrt(3)))/4;
        System.out.print("Pole podstawy wynosi: " + area);
        
        return area;
    }

    @Override
    public double calculateBasePerimeter() {
       System.out.println("Podaj promień podstawy (trójkąt równoboczny): ");
        Scanner read = new Scanner(System.in);
        perimeter = read.nextDouble();
        perimeter = 3*side;
        System.out.print("Obwód podstawy wynosi: " + perimeter);
       
        return perimeter;
        
    }
    
}

public class ExtendedConeCalculator extends ConeCalculator implements ExtendedCalculator
{

    @Override
    public void calculateArea() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calculateVolume() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

public class ExtendedTetrahedronCalculator extends TetrahedronCalculator implements ExtendedCalculator
{

    @Override
    public void calculateArea() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void calculateVolume() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}