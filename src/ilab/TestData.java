/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilab;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author chrismkhontwana
 */
public class TestData
{
    ArrayList<String> tempFileData = new ArrayList<>();
    public static String applicationName;
    public static String message;
    public static String emailaddress;
    
    public String generatePhoneNumber()
    {
        String phoneNumber = "";
        Random rand = new Random();
        int num1 = (rand.nextInt(7) + 1) * 100 + (rand.nextInt(8) * 10) + rand.nextInt(8);
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);

        DecimalFormat df3 = new DecimalFormat("000"); // 3 zeros
        DecimalFormat df4 = new DecimalFormat("0000"); // 4 zeros

        phoneNumber =  "073 " + df3.format(num2) + " " + df4.format(num3);
        
        return phoneNumber;
    }
   
    public ArrayList<String> readTxtFile(String filePath)
    {
         
            String line = null;
            try
             {
                 FileReader fileReader = new FileReader(filePath);
                 BufferedReader bufferedReader = new BufferedReader(fileReader);
                 
                 while ((line = bufferedReader.readLine()) != null)
                 {
                     tempFileData.add(line);
                 }
                 bufferedReader.close();

             }
             catch (FileNotFoundException e)
             {
                System.out.println("Error: Failed to read text file - "+e.getMessage());
             }
             catch (Exception e)
             {
                System.out.println("Error: Failed to read text file - "+e.getMessage());
             }
           return tempFileData;
       }
    
    public void getTestData()
    {
        String[] rowDetails;
        for(int i = 0; i < tempFileData.size();i++)
        {
           rowDetails = tempFileData.get(i).split("#");
           applicationName = rowDetails[0];
           message = rowDetails[2];
           emailaddress = rowDetails[1];
        }
    }
}
