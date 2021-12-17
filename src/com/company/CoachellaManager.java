package com.company;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class CoachellaManager {
    Map<String, Integer> guests;

    public CoachellaManager(String fileName) {
        this.guests = new HashMap<>();
        readFile(fileName);
    }

    public void readFile(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("File has already existed!");
            }
        }

        BufferedReader br = null;
        FileReader fr = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String st;
            while ((st = br.readLine()) != null) {
                String[] temp = st.split(",");
                guests.put(temp[0], Integer.valueOf(temp[1]));
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not exists.");
        } catch (IOException e) {
            System.out.println("IOException.");
        } finally {
            try {
                if (br != null) {
                    br.close();
                    if (fr != null) {
                        fr.close();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sortList() {
        Comparator<Map.Entry<String, Integer>> valueComparator =
                (e1, e2) -> e1.getKey().compareTo(e2.getKey());
        Map<String, Integer> sortedMap =
                guests.entrySet().stream().
                        sorted(valueComparator).
                        collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
        guests = sortedMap;
    }

    public void printGuestList() {

        for (String e : guests.keySet()) {
            System.out.println(e);
        }
//        for (String key : guests.keySet()) {
//            System.out.println(key);
//        }
    }

    public void printAllPassesNumber() {
        int sum = 0;
        for (Integer v : guests.values()) {
            sum += v;
        }
        System.out.println("Number of passes: " + sum);
    }

    public void changePassesAmountBy45Percent() {
        for (Map.Entry<String, Integer> e : guests.entrySet()) {
            e.setValue(e.getValue() + (int) (e.getValue() * 0.45));
            System.out.println(e.getKey() + " " + e.getValue());
        }

    }

    public void writeToFile(String fileName) {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(fileName, true), "utf-8"));) {
            writer.write("\n");
            for (Map.Entry<String, Integer> e : guests.entrySet()) {
                writer.write(e.getKey() + "," + e.getValue() + "\n");
            }
        } catch (IOException ex) {
            // Report
        }
    }
}
