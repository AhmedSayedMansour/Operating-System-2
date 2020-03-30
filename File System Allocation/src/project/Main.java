package project;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileOperations file = new FileOperations();

        Disk disk = file.loadFile();
        System.out.println("File Loaded Successfully");

        Scanner input = new Scanner(System.in);
        Scanner choice = new Scanner(System.in);
        String command = input.nextLine();
        while (!command.equals("Exit") && !command.equals("exit")) {
            if (command .matches("help")){
                help();
            }
            else if(command.equals("changeToIndexed") && disk.mode == 2)
            {
                System.out.println("You are already in Indexed Allocation Mode");
            }
            else if(command.equals("changeToIndexed") && disk.mode == 1)
            {
                System.out.println("Virtual File will be cleared to change mode!");
                System.out.print("Enter Y to continue or N to Discard Command : ");
                char in = choice.next().charAt(0);
                while(in != 'Y' && in != 'N' && in != 'y' && in != 'n')
                {
                    System.out.println("Wrong input!");
                    System.out.print("Enter Y to continue or N to Discard Command : ");
                    in = choice.next().charAt(0);
                }
                if(in == 'Y' || in == 'y')
                {
                    file.clearFile();
                    System.out.println("File Cleared");
                    System.out.println("You are now in Indexed allocation mode");
                    disk = new Disk(500 , 2);
                }
            }
            else if(command.equals("changeToContiguous") && disk.mode == 1)
            {
                System.out.println("You are already in Contiguous Allocation Mode");
            }
            else if(command.equals("changeToContiguous") && disk.mode == 2)
            {
                System.out.println("Virtual File will be cleared to change mode!");
                System.out.print("Enter Y to continue or N to Discard Command : ");
                char in = choice.next().charAt(0);
                while(in != 'Y' && in != 'N' && in != 'y' && in != 'n')
                {
                    System.out.println("Wrong input!");
                    System.out.print("Enter Y to continue or N to Discard Command : ");
                    in = choice.next().charAt(0);
                }
                if(in == 'Y' || in == 'y')
                {
                    file.clearFile();
                    System.out.println("File Cleared");
                    System.out.println("You are now in contiguous allocation mode");
                    disk = new Disk(500 , 1);
                }
            }
            else if (command .matches("clear")){
                file.clearFile();
            }
            else {
                if(disk.runCommand(command)){
                    file.saveFile(disk);
                    System.out.println("\nSaved");
                }
            }
            command = input.nextLine();
        }
    }

    public static void help() {
        System.out.println("To create a file : CreateFile $path $size");
        System.out.println("To create a folder : CreateFolder $path");
        System.out.println("To delete a file : DeleteFile $path");
        System.out.println("To delete a folder : DeleteFolder $path");
        System.out.println("To display disk status : DisplayDiskStatus");
        System.out.println("To display disk structure : DisplayDiskStructure");
        System.out.println("To clear the file : clear");
        System.out.println("To mode to contiguous : changeToContiguous");
        System.out.println("To mode to Indexed : changeToIndexed");
    }
}