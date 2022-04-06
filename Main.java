package com.company;
import java.io.*;
import java.lang.*;
public class Main {

    public static void main(String[] args) {
	// write your code here
        File file = null;
        FileInputStream fis = null;
        try{
            file = new File("C:\\Users\\srikar\\IdeaProjects\\MyFirstFileInputStream\\src\\com\\company\\prompt.txt");
            fis = new FileInputStream(file);
            int inp = fis.read();
            String inpStr = new String();
            boolean num1 = false;
            boolean num2 = false;
            String players = new String();
            String servers = new String();
            while (inp != -1){
                char iToA = (char)inp;
                if (num1){
                    if(!(inp <= 57 && inp >= 48)){
                        num1 = false;
                    }
                    else{
                        players += String.valueOf(iToA);
                    }
                }
                else if(num2){
                    if(!(inp <= 57 && inp >= 48)){
                        num2 = false;
                    }
                    else{
                        servers += String.valueOf(iToA);
                    }
                }
                if (iToA == ':' ) {
                    if (players.isEmpty()) {
                        num1 = true;
                    }
                    else{
                        num2 = true;
                    }
                }
                inp = fis.read();
            }
            System.out.println("There are " + players + " players and " + servers + " servers.");
        }
        catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        finally{
            if (fis != null){
                try{
                    fis.close();
                }
                catch(IOException error){
                    error.printStackTrace();
                }
            }
            else{
                System.out.println("File opening failed");
            }
        }
    }
}
