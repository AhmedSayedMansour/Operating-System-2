package project;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileOperations file = new FileOperations();
        Disk disk = file.loadFile();
        //Disk disk = new Disk(500  , 1);


        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        while(!command.equals("Exit"))
        {
            disk.runCommand(command);
            command = input.nextLine();
        }

        //file.saveFile(disk);


    }

}