package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {

            if (args.length < 4 || !"-c".equals(args[0])) return;

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = reader.readLine();
            reader.close();
            int maxId = 0;

            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

            String line;
            if ((line = bufferedReader.readLine()) != null){
                if (line.startsWith("\uFEFF")){
                    line = line.substring(1);
                }

                maxId = getId(line);
            }

            while ((line = bufferedReader.readLine()) != null){
                int id = getId(line);

                if (id > maxId){
                    maxId = id;
                }
            }
            bufferedReader.close();

            String lineToWrite = createLine(++maxId, args[1], args[2], args[3]);

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true));
            bufferedWriter.newLine();
            bufferedWriter.write(lineToWrite);
            bufferedWriter.close();
    }


    private static int getId(String line){
        String substring = line.substring(0, 8);
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
        while (parameter.length() < lenght){
            parameter += " ";
        }

        return parameter;
    }
}
