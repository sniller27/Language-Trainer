/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Soren
 */
public class Engine {

    private Random gen, gen1;
    private int gennumber, gennumber2, gennumber3;
    private Ord randomPair, temp, randomPair2, randomPair3;
    private HashMap<String, Ord> wordMap; //= new HashMap<String, Ord>();
    private HashMap<String, Ord> wordMap2;
    private HashMap<String, Ord> wordMap3;

    public Engine() {

        wordMap = new HashMap();
        wordMap2 = new HashMap();
        wordMap3 = new HashMap();
    }

    public boolean load(String file) {

        wordMap = FileHandler.ReadFromFile(file);

        if (wordMap.isEmpty()) {
            return false;
        } else {
            return true;
        }

    }

    public String ruller() {

        gen1 = new Random();
        gennumber = gen1.nextInt(100);

        if (gennumber <= 60 && !wordMap.isEmpty()) {

            gen = new Random();
            gennumber = gen.nextInt(wordMap.size());
            Object[] oArray = wordMap.values().toArray();
            randomPair = (Ord) oArray[ gennumber];

            return randomPair.getDanskord();

        } else if (gennumber >= 61 && gennumber <= 90 && !wordMap2.isEmpty()) {

            gen = new Random();
            gennumber2 = gen.nextInt(wordMap2.size());
            Object[] oArray2 = wordMap2.values().toArray();
            randomPair2 = (Ord) oArray2[ gennumber2];

            return randomPair2.getDanskord();
        } else if (gennumber >= 91 && !wordMap3.isEmpty()) {

            gen = new Random();
            gennumber3 = gen.nextInt(wordMap3.size());
            Object[] oArray3 = wordMap3.values().toArray();
            randomPair3 = (Ord) oArray3[ gennumber3];

            return randomPair3.getDanskord();
        } else {

            return ruller();
        }

    }

    public void addToMap(String p, String o) {
        Ord ord = new Ord(p, o);
        wordMap.put(p, ord);

    }

    public boolean save2(String file) {

        return FileHandler.SaveToFile(wordMap, file);

    }

    public String gettemp(String o) {
        if (wordMap.containsKey(o)) {

            temp = wordMap.get(o);
            return temp.getEngelskord().toString();

        } else if (wordMap2.containsKey(o)) {

            temp = wordMap2.get(o);
            return temp.getEngelskord().toString();

        } else if (wordMap3.containsKey(o)) {

            temp = wordMap3.get(o);
            return temp.getEngelskord().toString();
        } else {
            return null;
        }

    }

    public int size() {

        return wordMap.size();
    }

    public void clear() {

        wordMap.clear();

    }

    public void MoveToList2(String o, String p) {

        if (wordMap.containsKey(o)) {
            Ord ord = new Ord(o, p);
            wordMap2.put(o, ord);

            wordMap.remove(o);

        } else if (wordMap2.containsKey(o)) {

            Ord ord = new Ord(o, p);
            wordMap3.put(o, ord);

            wordMap2.remove(o);

        }

    }

}
