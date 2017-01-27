package Lab1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by mmcalvarez on 1/26/2017.
 */
public class Sequential {

    private static final String FILENAME = "inputSeq.txt";

    public void run(){
        String thisLine = null;
        ArrayList<String> s = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(FILENAME));

            while((thisLine = br.readLine()) != null){
                s.add(thisLine);
            }

            Collections.sort(s);

            FileWriter fw = new FileWriter("outputSeq.txt");
            for(String str : s){
                fw.write(str + "\n");
            }

            br.close();
            fw.close();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Sequential seq = new Sequential();
        seq.run();
    }
}
