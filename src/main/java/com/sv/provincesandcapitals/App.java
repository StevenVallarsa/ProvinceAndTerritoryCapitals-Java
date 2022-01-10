
package com.sv.provincesandcapitals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
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
    public static void main(String[] args) throws FileNotFoundException, Exception {
        
        Map<String, String> provincesAndCapitals = new HashMap<>();
        UserIO io = new UserIOImpl();
        
        Scanner scanner = new Scanner(new BufferedReader(new FileReader("provincesAndCapitals.txt")));
        
        while(scanner.hasNextLine()) {
            String newLine = scanner.nextLine();
            String[] array = newLine.split("::");
            
            provincesAndCapitals.put(array[0], array[1]);
        }
        
        PrintWriter out = new PrintWriter(new FileWriter("results.txt", true));
        Scanner in = new Scanner(new BufferedReader(new FileReader("results.txt")));
        
        boolean isPlayingGame = true;
        
        while (isPlayingGame) {
            
            int right = 0;
            int wrong = 0;
            Iterator iterator = provincesAndCapitals.entrySet().iterator();
            
            String[] correct = {"Yes!", "You got it!", "Correctomundo!", "You're on fire!", "You must be Canadian!", "Writoh"};
            Random random = new Random();
            
            while (iterator.hasNext()) {
                Map.Entry element = (Map.Entry)iterator.next();
                String guess = io.readString("What is the capital of " + element.getKey() +"?");
                if (guess.equalsIgnoreCase(element.getValue().toString())) {
                    right++;
                    io.print(correct[random.nextInt(correct.length)]);
                } else {
                    wrong++;
                    io.print("WRONG!");
                }
            }
            
            io.print("You got " + right + " right and " + wrong + " wrong.");
            
            while (in.hasNext()) {
                io.print(in.nextLine());
            }
            
            LocalDateTime dateTime = LocalDateTime.now();
            String marshal = "RIGHT: " + right + ", WRONG: " + wrong + ", " + dateTime;
            out.println(marshal);
            out.flush();
            out.close();
            
            if (right == 13) {
                io.print("You got them all. No need to keep playing.");
                isPlayingGame = false;
            } else if (right > 9) {
                String response = io.readString("You almost got them all. You can quit if you want (Y/N)");
                if (response.toUpperCase().substring(0, 1).equals("Y")) {
                    isPlayingGame = false;
                }
            } else {
                io.print("You're going to play again until you get more right.\n");
            }
        }
        io.print("\nGoodbye!");
    }
}



// ACCIDENTALLY DUMPED FILE with no repo 2022-01-08
        
//        Map<String, String> capitals = new HashMap<>();
//        capitals.put("British Columbia", "Victoria");
//        capitals.put("Yukon", "Whitehorse");
//        capitals.put("Alberta", "Edmonton");
//        capitals.put("Saskatchewan", "Regina");
//        capitals.put("Northwest Territories", "Yellowknife");
//        capitals.put("Manitoba", "Winnipeg");
//        capitals.put("Nunavut", "Iqaluit");
//        capitals.put("Ontario", "Toronto");
//        capitals.put("Quebec", "Quebec City");
//        capitals.put("New Brunswick", "Fredericton");
//        capitals.put("Price Edward Island", "Charlotettown");
//        capitals.put("Nova Scotia", "Halifax");
//        capitals.put("Newfoundland", "St. John's");
//        
//        Set<String> provinces = capitals.keySet();
//        Collection<String> capitalCities = capitals.values();
//        
//        System.out.println("PROVINCES");
//        System.out.println("=========");
//        for (String province : provinces) {
//            System.out.println(province);
//        }
//        for (String province : provinces) {
//            System.out.println(province);
//        }
//        
//        System.out.println("CAPITALS");
//        System.out.println("========");
//    }
//}