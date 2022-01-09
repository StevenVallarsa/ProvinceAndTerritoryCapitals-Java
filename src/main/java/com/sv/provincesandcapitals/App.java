/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.sv.provincesandcapitals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author: Steven Vallarsa
 * email: stevenvallarsa@gmail.com
 * date:
 * purpose:
 */
public class App {
    public static void main(String[] args) throws FileNotFoundException {
        
        Map<String, String> provincesAndCapitals = new HashMap<>();
        UserIO io = new UserIOImpl();
        
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("provincesAndCapitals.txt")));
        
        while(scanner.hasNextLine()) {
            String newLine = scanner.nextLine();
            String[] array = newLine.split("::");
            
            provincesAndCapitals.put(array[0], array[1]);
        }
        
        Set<String> provinces = provincesAndCapitals.keySet();
        
        for (String province : provinces) {
            io.print("The capital of " + province + " is " + provincesAndCapitals.get(province));
        }
        
    }
}
