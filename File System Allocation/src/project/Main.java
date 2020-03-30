package project;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileOperations file = new FileOperations();
        //Disk disk = file.loadFile();
        Disk disk = new Disk(500  , 1);


        Scanner input = new Scanner(System.in);
        String command = input.nextLine();
        while (!command.equals("Exit") && !command.equals("exit")) {
            if (command .matches("help")){
                help();
            }
            else if (command .matches("clear")){
                file.clearFile();
            }
            else {
                if(disk.runCommand(command)){
                    //file.saveFile(disk);
                    System.out.println("Done");
                }
            }
            command = input.nextLine();
        }

        //file.saveFile(disk);


    }

    public static void help() {
        System.out.println("To create a file : CreateFile $path $size");
        System.out.println("To create a folder : CreateFolder $path");
        System.out.println("To delete a file : DeleteFile $path");
        System.out.println("To delete a folder : DeleteFolder $path");
        System.out.println("To display disk status : DisplayDiskStatus");
        System.out.println("To display disk structure : DisplayDiskStructure");
        System.out.println("To clear the file : clear");
    }
}