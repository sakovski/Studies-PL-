//Seweryn Rutkowski 240865
//Kryptografia
//Funkcje skrótu - zad2

import java.io.*;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Diff {

    public static void main(String[] args) {
        try {
            String[] functions = {"md5sum", "sha1sum", "sha224sum", "sha256sum", "sha384sum", "sha512sum"};
            String cat = "cat ";
            String hashPdf = "hash.pdf ";
            String hashTxt = "hash.txt ";
            String direct = " >> ";
            String personalTxt = "personal.txt ";
            String personal_Txt = "personal_.txt ";
            char newLine = '\n';
            Map<String, String> myMap = fillHashMapWithStrings(functions);

            StringBuilder sb = new StringBuilder();
            sb.append("Wykonywane polecenia i wyniki:" + newLine);
            sb.append(newLine);

            for(int i = 0; i < functions.length; i++)
            {
                int diffCounter = getDiff(functions[i], myMap);
                int bitsNumber = countBits(myMap.get(functions[i]+"1"));
                float percent = (float)diffCounter/bitsNumber * 100;
                sb.append(cat + hashPdf + personalTxt + "| " + functions[i] + direct + hashTxt + newLine);
                sb.append(cat + hashPdf + personal_Txt + "| " + functions[i] + direct + hashTxt + newLine);
                sb.append(myMap.get(functions[i]+"1") + newLine);
                sb.append(myMap.get(functions[i]+"2") + newLine);
                sb.append("Liczba różniących się bitów: " + diffCounter + " tj. " + percent + "% z " + bitsNumber + newLine);
                sb.append(newLine);
                System.out.println(diffCounter + " " + percent + "%");
            }


            File file = new File("diff.txt");
            BufferedWriter writer = null;
            writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
            if (writer != null) writer.close();

        }
        catch(Exception e) {e.printStackTrace();}
    }

    public static Map<String, String> fillHashMapWithStrings(String[] functions)
    {
        Map<String, String> myMap = new HashMap<String, String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("hash.txt"));
            String line = br.readLine();
            int i = 0;
            int option = 1;
            while (line != null) {
                myMap.put(functions[i]+option, line.toString());
                if (option == 1)
                {
                    option = 2;
                }
                else
                {
                    option = 1;
                    i++;
                }
                line = br.readLine();
            }


            br.close();
        } catch(Exception e) {}
        return myMap;
    }

    public static int countBits(String source)
    {
        int length = 0;
        try {
            byte[] byteArray = source.getBytes("UTF-8");
            length =  byteArray.length * 4;
        } catch(Exception e){}
        return length;
    }

    public static int getDiff(String mode, Map<String, String> map)
    {
        String string1 = map.get(mode+"1");
        String string2 = map.get(mode+"2");
        char[] binary1 = new BigInteger(string1, 16).toString(2).toCharArray();
        char[] binary2 = new BigInteger(string2, 16).toString(2).toCharArray();
        int breaker = binary1.length;
        if (binary1.length > binary2.length) {
            breaker = binary2.length;
        }
        int diffCounter = 0;
        for (int i = 0; i < breaker; i++) {
            if (binary2[i] != binary1[i])
                diffCounter++;

        }
        return diffCounter;
    }
}
