package com.accolite;


import static org.mockito.Mockito.verify;

import static org.mockito.Mockito.when;

import java.util.HashMap;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {
	
   @InjectMocks 
   MathApplication mathApplication = new MathApplication();

   @Mock
   CalculatorService calcService;

   @Test
   public void testCalculator(){
      //add the behavior of calc service to add two numbers
      when(calcService.add(10.0,20.0)).thenReturn(30.00);
      when(calcService.subtract(20.0,10.0)).thenReturn(1.0);
      when(calcService.multiply(20.0, 13.00)).thenReturn(260.00);
      when(calcService.divide(20.0, 10.00)).thenReturn(2.0);
		
      //test the add functionality
      Assert.assertEquals(calcService.add(10.0, 20.0),30.0,0);
      Assert.assertEquals(calcService.subtract(20.0, 10.0),1.0,0);
      Assert.assertEquals(calcService.multiply(20.0, 13.0),260.0,0);
      Assert.assertEquals(calcService.divide(20.00, 10.00), 2.1,0.3);
      InOrder inOrder = inOrder(calcService);
   
//Testing fails.
//Order of execution not maintained.
      inOrder.verify(calcService).add(10.0,20.0);      
      inOrder.verify(calcService).multiply(20.0,13.0);
      inOrder.verify(calcService).divide(20.0,10.0);
      inOrder.verify(calcService).subtract(20.0,10.0);

   }
}