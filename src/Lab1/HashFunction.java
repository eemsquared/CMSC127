package Lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

/**
 * Created by mmcalvarez on 1/26/2017.
 */

public class HashFunction {

    private static final String FILENAME = "inputHash.txt";

    public void run(){
        int hashValue = 0;
        String thisLine = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            ArrayList<Integer> arrayList = new ArrayList<>();

            while ((thisLine = br.readLine()) != null){
                hashValue = hasher(thisLine);
                //System.out.println("Hashcode for: " + thisLine + " is " + Math.abs(hashValue));
                arrayList.add(hashValue);
            }

            FileWriter fw = new FileWriter("outputHash.txt");
            for (Integer hash : arrayList){
                fw.write(hash + "\n");
            }

            br.close();
            fw.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public int hasher(String s){
        return Math.abs(s.hashCode() % 97); //random prime number. The bigger the number, much less collision.
    }

    public static void main(String[] args) {
        HashFunction hash = new HashFunction();
        hash.run();
    }
}
