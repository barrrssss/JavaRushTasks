package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args.length < 2) return;
        if (!(args[0].equals("-u") || args[0].equals("-d"))) return;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = bufferedReader.readLine()) != null){
            int id = getId(line);

            if (id == Integer.parseInt(args[1])){
                if (args[0].equals("-u")){
                    String lineToWrite = createLine(id, args[2], args[3], args[4]);
                    stringBuilder.append(lineToWrite).append("\n");
                }
            }
            else {
                stringBuilder.append(line).append("\n");
            }
        }
        bufferedReader.close();

        FileWriter fileWriter = new FileWriter(fileName);
        fileWriter.write(stringBuilder.toString());
        fileWriter.close();



    }

    private static int getId(String line){
        String substring = line.substring(0, 8);
        if (substring.startsWith("\uFEFF")){
            substring = substring.substring(1);
        }
        int result = Integer.parseInt(substring.trim());

        return result;
    }

    private static String createLine(int id, String productName, String price, String quantity){
        String stringId = Integer.toString(id);

        String result = parameterLenght(stringId, 8) + parameterLenght(productName, 30)
                + parameterLenght(price, 8) + parameterLenght(quantity, 4);

        return result;
    }

    private static String parameterLenght(String parameter, int lenght){
        StringBuilder stringBuilder = new StringBuilder(parameter);
        while (stringBuilder.length() < lenght){
            stringBuilder.append(" ");
        }

        String result = stringBuilder.toString();

        return result;
    }
}
