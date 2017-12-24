/*
22.10.2017
Imie i nazwisko: Seweryn Rutkowski
Informatyka III rok sp. Tester programista gr. 1
Termin zajec: Poniedzialek 8:00-10:00
Zadanie: Obliczanie wartosci funkcji sin(x) za pomoca:
 *  a) korzystajac z bibliotecznych funkcji wbudowanych,
 *  b) sumujac elementy szeregu potegowego od poczatku i od konca,
 *  c) obliczajac kolejny wyraz szeregu na podstawie poprzedniego oraz bezposrednio ze wzoru
*/


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Main 
{
	public static void main(String[] args)
	{
    	 
	    double angle_degree;
	    int n;
	    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	    
	    try {
	    	System.out.println("Podaj k¹t w stopniach: ");
			angle_degree = Double.parseDouble(reader.readLine());
			n=7;
		    test(angle_degree,n);
			
		} catch (NumberFormatException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	    
	    try {
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	    
	}
	
	public static double pow(double number, int power)
	{
		if(number == 0)
		{
			return 0;
		}
		
		if (power == 0)
		{
			return 1;
		}
		
		double pow = 1;
		for(int i = 0; i<power; i++)
		{
			pow *= number;
		}
		return pow;
	}
	
	public static int strong(int number)
	{
		if (number == 0 || number == 1)
		{
			return 1;
		}
		else
		{
			return number * strong(number - 1);
		}
	}
	
	public static double change_degree_to_radian(double angle)
	{
		return angle*Math.PI/180;
	}
	
	public static double get_sinus_from_javalib(double angle)
	{
		return Math.sin(angle);
	}
	
	public static double count_sinus_with_series_based_on_previous(double x, int n)
	{
		double term = x;
	    double result = x;
	    double x_sq = x * x;
	    int i;
	    for(i = 0; i < n-1; i++){
	        term = term * (-x_sq/((2*i+2)*(2*i+3)));
	        result += term;
	    }
	    return result;
	}
	
	public static double count_sinus_with_series_based_on_previous_backwards(double x, int n)
	{
		int el_id = 1;
	    double elements[] = new double[n];
	    double term = x;
	    elements[0] = x;
	    double result = 0;
	    double x_sq = x * x;
	    int i;
	    for(i = 0; i < n-1; i++){
	        term = term * (-x_sq/((2*i+2)*(2*i+3)));
	        elements[el_id++] = term;
	    }
	 
	    for(i = n-1; i>=0; i--){
	        result += elements[i];
	    }
	    return result;
	}
	
	public static double count_sinus_with_series_from_beginning(double x, int n)
	{
		double sum = 0;
	    double sign = 0;
	    for(int i = 0; i < n; i++){
	        sign = (1.0 /strong(2*i+1))*pow(x,2*i+1);
	        if (i%2 != 0) sign = -sign;
	        sum += sign;
	    }
	    return sum;
	}
	
	public static double count_sinus_with_series_from_end(double x, int n)
	{
		double result = 0;
	    double change = 0;
	    for(int i = n - 1; i >= 0; i--){
	        change = (1.0 /strong(2*i+1))*pow(x,(2*i+1));
	        if (i%2 != 0) change = -change;
	        result += change;
	    }
	    return result;
	}
	
	public static void test(double angle, int n)
	{
		try
		{
			PrintWriter errors_beginning_writer = new PrintWriter(new FileWriter("errors_from_beginning.csv", true));
			PrintWriter errors_end_writer = new PrintWriter(new FileWriter("errors_from_end.csv", true));
			PrintWriter errors_previous_writer = new PrintWriter(new FileWriter("errors_from_based_on_previous.csv", true));
			PrintWriter errors_previous_backwards_writer = new PrintWriter(new FileWriter("errors_from_based_on_previous_backwards.csv", true));
	    	    
			StringBuilder sb_error_beginning = new StringBuilder();
			StringBuilder sb_error_end = new StringBuilder();
			StringBuilder sb_error_previous = new StringBuilder();
			StringBuilder sb_error_previous_backwards = new StringBuilder();
	    
			double current_angle = 1.0;
			for(int i = 1; i<=(int)angle*100; i++)
			{
				double angle_radian = change_degree_to_radian(current_angle);
				double sinus_java_lib = get_sinus_from_javalib(angle_radian);
				System.out.println("-------------------------------------------------");
				System.out.println("TEST FOR "+current_angle+" DEGREES");
				System.out.println("From javalib: "+ sinus_java_lib);
				double sinus_series_from_beginning = count_sinus_with_series_from_beginning(angle_radian,n);
				double sinus_series_from_end = count_sinus_with_series_from_end(angle_radian,n);
				double sinus_series_based_on_previous = count_sinus_with_series_based_on_previous(angle_radian, 20);
				double sinus_series_based_on_previous_backwards = count_sinus_with_series_based_on_previous_backwards(angle_radian, 20);
				double error_series_from_beginning = Math.abs((sinus_series_from_beginning - sinus_java_lib) / Math.abs(sinus_java_lib));
				double error_series_from_end = Math.abs((sinus_series_from_end - sinus_java_lib) / Math.abs(sinus_java_lib));
				double error_series_based_on_previous = Math.abs((sinus_series_based_on_previous - sinus_java_lib) / Math.abs(sinus_java_lib));
				double error_series_based_on_previous_backwards = Math.abs((sinus_series_based_on_previous_backwards - sinus_java_lib) / Math.abs(sinus_java_lib));
			
				System.out.println("From series from beginning: "+ sinus_series_from_beginning);
				System.out.println("From series from end: "+ sinus_series_from_end);
				System.out.println("From series where next element is based on previous: "+ sinus_series_based_on_previous);
				System.out.println("From series where next element is based on previous backwards: "+ sinus_series_based_on_previous_backwards);
				System.out.println("Error relative series from beginning: "+ error_series_from_beginning);
				System.out.println("Error relative series from end: "+ error_series_from_end);
				System.out.println("Error relative series where next element is based on previous: "+ error_series_based_on_previous);
			
				sb_error_beginning.append(current_angle);
				sb_error_beginning.append(';');
				sb_error_beginning.append(error_series_from_beginning);
				sb_error_beginning.append(';');
				sb_error_beginning.append("\r\n");
			
				sb_error_end.append(current_angle);
				sb_error_end.append(';');
				sb_error_end.append(error_series_from_end);
				sb_error_end.append(';');
				sb_error_end.append("\r\n");
			
				sb_error_previous.append(current_angle);
				sb_error_previous.append(';');
				sb_error_previous.append(error_series_based_on_previous);
				sb_error_previous.append(';');
				sb_error_previous.append("\r\n");
			
				sb_error_previous_backwards.append(current_angle);
				sb_error_previous_backwards.append(';');
				sb_error_previous_backwards.append(error_series_based_on_previous_backwards);
				sb_error_previous_backwards.append(';');
				sb_error_previous_backwards.append("\r\n");
				
				current_angle += 0.01;
			}
			errors_beginning_writer.write(sb_error_beginning.toString());
			errors_end_writer.write(sb_error_end.toString());
			errors_previous_writer.write(sb_error_previous.toString());
			errors_previous_backwards_writer.write(sb_error_previous_backwards.toString());
	  
			errors_beginning_writer.close();
			errors_end_writer.close();
			errors_previous_writer.close();
			errors_previous_backwards_writer.close();
		}
		catch(FileNotFoundException ex)
		{
			System.out.println("FILE NOT FOUND EXCEPTION");
			ex.printStackTrace();
		}
		catch(IOException ex)
		{
			System.out.println("IOEXCEPTION");
			ex.printStackTrace();
		}
		
	}

}
