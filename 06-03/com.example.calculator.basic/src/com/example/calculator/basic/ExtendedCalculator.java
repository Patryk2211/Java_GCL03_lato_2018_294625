/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.calculator.basic;

/**
 *
 * @author pbukowsk
 */
public interface ExtendedCalculator extends Calculator
    {
        void calculateArea() throws Exception;
        void calculateVolume() throws Exception;
    }
