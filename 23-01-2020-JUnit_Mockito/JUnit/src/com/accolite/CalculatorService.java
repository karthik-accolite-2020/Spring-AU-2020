package com.accolite;

import java.util.List;
import java.util.HashMap;

public interface CalculatorService {
	   public double add(double input1, double input2);
	   public double subtract(double input1, double input2);
	   public double multiply(double input1, double input2);
	   public double divide(double input1, double input2);
	   public List<String> getAll(HashMap<Integer, String> map);
	}
