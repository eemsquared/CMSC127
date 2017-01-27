package Lab1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.RandomAccessFile;
import java.nio.BufferUnderflowException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mmcalvarez on 1/26/2017.
 */
public class IndexedSequential {

    private static final String FILENAME = "seek.txt";
    private static final String FILENAMETWO = "index.txt";

    public void run() throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String thisLine = null;
        boolean found = false;

        try{
            BufferedReader br = new BufferedReader(new FileReader(FILENAME));
            List<String> list = new ArrayList<>();

            while((thisLine = br.readLine()) != null){
                list.add(thisLine);
            }

            System.out.println("Type name you want to lookup: ");
            String nameToLookUp = sc.nextLine();

            char firstLetter = nameToLookUp.charAt(0);
            int start = 0;
            int end = list.size();

            br = new BufferedReader(new FileReader(FILENAMETWO));

            while((thisLine = br.readLine()) != null){
                if(thisLine.charAt(0) == firstLetter){
                    start = thisLine.charAt(thisLine.length() - 1) - '0';
                    try {
                        end = br.readLine().charAt(thisLine.length() - 1) - '0';
                    }catch (NullPointerException e){

                    }
                }
            }

            for(int i = start; i < end; i++){
                if(list.get(i).equals(nameToLookUp)){
                    System.out.println("Name found!");
                    found = true;
                    break;
                }
            }
            if(!found){
                System.out.println("Name not found.");
            }

            br.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IndexedSequential indexed = new IndexedSequential();
        try {
            indexed.run();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
