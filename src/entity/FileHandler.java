/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author Soren
 */
public class FileHandler {

    public static HashMap<String, Ord> ReadFromFile(String file) {

        HashMap<String, Ord> map = new HashMap();
        Scanner skan = null;

        try {

            skan = new Scanner(new File(file));

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }

        while (skan.hasNext()) {

            String næste = skan.nextLine();

            String test[] = næste.split(",");

            Ord p1 = new Ord(test[0], test[1]);
            map.put(test[0], p1);

        }

        skan.close();
        return map;
    }

    public static boolean SaveToFile(HashMap map1, String file) {

        PrintWriter pw = null;

        try {

            pw = new PrintWriter(new File(file));

        } catch (FileNotFoundException ex) {
            System.out.println("Error: ");
            return false;
        }

        for (int i = 0; map1.size() > i; i++) {

            Object[] oArray = map1.values().toArray();
            Ord randomPair = (Ord) oArray[i];
            String save = randomPair.getDanskord() + "," + randomPair.getEngelskord();
            pw.println(save);
        }
        pw.close();
        return true;
    }
}
