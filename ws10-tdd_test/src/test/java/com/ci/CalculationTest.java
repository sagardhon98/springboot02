package com.ci;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculationTest {

	@Test
	public void testAddition() {
		Calculation calc = new Calculation();
		int actual = calc.addition(10, 15);
		int expected = 25;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testSubstraction() {
		Calculation calc = new Calculation();
		int actual = calc.substraction(12, 5);
		int expected = 5;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testDivision() {
		Calculation calc = new Calculation();
		int actual = calc.division(12, 4);
		int expected = 3;
		assertEquals(expected, actual);
	}
	
	@Test
	public void testMultiplication() {
		Calculation calc = new Calculation();
		int actual = calc.multiplication(3, 5);
		int expected = 12;
		assertEquals(expected, actual);
	}
}
