package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import models.Converter;


public class ModelsTest {
	
	public ModelsTest()
	{
	}
	
	@Test
	public void fahrenheitToCelsius()
	{
	Converter converter = new Converter();
	try
	{
	for (int i = 0; i < FC.length; ++i) assertTrue(Math.abs(converter.ftoc(FC
	[i][0]) - FC[i][1]) < 0.01);
	}
	catch (Exception ex)
	{
	fail(ex.getMessage());
	}
	}
	
	 @Test
	 public void celsiusToFahrenheit()
	 {
	Converter converter = new Converter();
	try
	{
 for (int i = 0; i < FC.length; ++i) assertTrue(Math.abs(converter.ctof(FC
	[i][1]) - FC[i][0]) < 0.01);
	}
	catch (Exception ex)
	{
	fail(ex.getMessage());
	}
	}

	 @Test
	public void kelvinToCelsius()
	{
	Converter converter = new Converter();
	try
	{
	for (int i = 0; i < KC.length; ++i) assertTrue(Math.abs(converter.ktoc(KC
	[i][0]) - KC[i][1]) < 0.01);
	}
	catch (Exception ex)
	{
	fail(ex.getMessage());
	}
	}
	
	@Test
	public void celsiusToKelvin()
	{
	Converter converter = new Converter();
	try
	{
	for (int i = 0; i < KC.length; ++i) assertTrue(Math.abs(converter.ctok(KC
	[i][1]) - KC[i][0]) < 0.01);
	}
	catch (Exception ex)
	{
	fail(ex.getMessage());
	}
	}
	
	 @Test
	public void kelvinToFahrenheit()
	{
	Converter converter = new Converter();
	try
	{
	for (int i = 0; i < KF.length; ++i) assertTrue(Math.abs(converter.ktof(KF
	[i][0]) - KF[i][1]) < 0.01);
	}
 catch (Exception ex)
	 {
	fail(ex.getMessage());
	}
	}
	
	 @Test
	public void fahrenheitToKelvin()
	{
	Converter converter = new Converter();
	try
	{
	for (int i = 0; i < KF.length; ++i) assertTrue(Math.abs(converter.ftok(KF
	[i][1]) - KF[i][0]) < 0.01);
	}
	catch (Exception ex)
	{
		fail(ex.getMessage());
		
		}
		
		}
		
	 private static double[][] FC={
		{-459.67,-273.15 },
		{-50,-45.56 },
		{-40,-40.00 },
		{-30,-34.44 },
		{-20,-28.89 },
		{-10,-23.33 },
		{ 0,-17.78 },
		{ 10,-12.22 },
		{ 20,-6.67 },
		{ 30,-1.11 },
		{ 32,0 },
		{ 40, 4.44 },
		{ 50, 10.00 },
		{ 60, 15.56 },
		{ 70, 21.11 },
		{ 80, 26.67 },
		{ 90, 32.22 },
		{ 98.6, 37 },
		{ 100, 37.78 },
		{ 110, 43.33 },
		{ 120, 48.89 },
		{ 130, 54.44 },
		{ 140, 60.00 },
		{ 150, 65.56 },
		{ 160, 71.11 },
		{ 170, 76.67 },
		{ 180, 82.22 },
		{ 190, 87.78 },
		{ 200, 93.33 },
		{ 212, 100 },
		{ 300, 148.89 },
		{ 400, 204.44 },
		{ 500, 260.00 },
		{ 600, 315.56 },
		{ 700, 371.11 },
		{ 800, 426.67 },
		{ 900, 482.22 },
		{ 1000, 537.78
		}
		};
		
		private static double[][] KC={
		{ 0,-273.15 },
		{ 10,-263.15 },
		{ 20,-253.15 },
		{ 30,-243.15 },
		{ 40,-233.15 },
		{ 50,-223.15 },
		{ 60,-213.15 },
		{ 70,-203.15 },
		{ 80,-193.15 },
		{ 90,-183.15 },
		{ 100,-173.15 },
		{ 110,-163.15 },
		{ 120,-153.15 },
		{ 130,-143.15 },
		{ 140,-133.15 },
		{ 150,-123.15 },
		{ 160,-113.15 },
		{ 170,-103.15 },
		{ 180,-93.15 },
		{ 190,-83.15 },
		{ 200,-73.15 },
		{ 210,-63.15 },
		{ 220,-53.15 },
		{ 230,-43.15 },
		{ 240,-33.15 },
		{ 250,-23.15 },
		{ 260,-13.15 },
		{ 270,-3.15 },
		{ 273.15,0 },
		{ 294.15, 21 },
		{ 300, 26.85 },
		{ 310.15, 37 },
		{ 373.15, 100 },
		{ 400, 126.85 },
		{ 500, 226.85 },
		{ 600, 326.85 },
		{ 700, 426.85 },
		{ 800, 526.85 },
		{ 900, 626.85 },
		{ 1000, 726.85
		}
	};
		 private static double[][] KF={
		{ 0,-459.67 },
		{ 10,-441.67 },
		{ 20,-423.67 },
		{ 30,-405.67 },
		{ 40,-387.67 },
		{ 50,-369.67 },
		{ 60,-351.67 },
		{ 70,-333.67 },
		{ 80,-315.67 },
		{ 90,-297.67 },
		{ 100,-279.67 },
		{ 110,-261.67 },
		{ 120,-243.67 },
		{ 130,-225.67 },
		{ 140,-207.67 },
		{ 150,-189.67 },
		{ 160,-171.67 },
		{ 170,-153.67 },
		{ 180,-135.67 },
		{ 190,-117.67 },
		{200,-99.67 },
		{ 210,-81.67 },
		{ 220,-63.67 },
		{ 230,-45.67 },
		{ 240,-27.67 },
		{ 250,-9.67 },
		{ 260, 8.33 },
		{ 270, 26.33 },
		{ 280, 44.33 },
		{ 290, 62.33 },
		{ 300, 80.33 },
		{ 400, 260.33 },
		{ 500, 440.33 },
		{ 600, 620.33 },
		{ 700, 800.33 },
		{ 800, 980.33 },
		{ 900, 1160.33 },
		{ 1000, 1340.33}
		};
	

}

