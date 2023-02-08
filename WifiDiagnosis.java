/*
 * Class: CMSC203 
 * Instructor: Ahmed Tarek
 * Description: A program that will guide you step by step on multiple ways of fixing the internet connection.
 * Due: 2/07/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Abass Shikur
*/

import java.util.Scanner;
public class WifiDiagnosis {
	public static void main(String[] args) { //Main Method
		Scanner obj = new Scanner(System.in); //Creates Scanner Object
		System.out.println("Reboot the computer and try to connect");
		System.out.println("Did that fix the problem");//Prompt for User
		String response1 = obj.nextLine(); //Input from User
			if (response1.equals("No")) {
				System.out.println("Reboot the router and try to connect");
				System.out.println("DId that fix the problem"); //Prompt for User
				String response2 = obj.nextLine(); //Input from User
				if (response2.equals("No")) {
					System.out.println("Make sure the cables connecting the router are firmly plugged in and power is getting to the router");
					System.out.println("DId that fix the problem"); //Prompt for User
					String response3 = obj.nextLine(); //Input from User
					if (response3.equals("No")) {
						System.out.println("Move the computer closer to the router and try to connect");
						System.out.println("DId that fix the problem"); //Prompt for User
						String response4 = obj.nextLine(); //Input from User
						if (response4.equals("No")) {
							System.out.println("Contact your ISP");
						}
					}
				}
			}
			System.out.println("Thank you for using my program.");
		}
	}