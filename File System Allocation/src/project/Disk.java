package project;

import java.awt.*;

public class Disk {

    private Directory directory;
    int numberOfBlocks;
    int emptySpace;
    int allocatedSpace;
    Block [] blocks;

    public Disk(int numberOfBlocks) {
        directory= new Directory("root");
        this.numberOfBlocks = numberOfBlocks;
        this.emptySpace = numberOfBlocks;
        this.allocatedSpace = 0;
        blocks = new Block[numberOfBlocks];
        for(int i = 0 ; i < numberOfBlocks ;++i){
            blocks[i].allocated = false;
        }
    }

    public void RunCommand(String command){
        Parser parser = new Parser();
        Boolean isValid = parser.parse(command);
        if (!isValid){
            System.out.println("ERROR :(");
        }
        else {
            if (parser.cmd.matches("CreateFile")){
                createFile(parser.path, parser.folderName, parser.fileName , parser.size);
            }
            else if (parser.cmd.matches("CreateFolder")){
                createFolder(parser.path, parser.folderName);
            }
            else if (parser.cmd.matches("DeleteFile")){
                deleteFile(parser.path, parser.folderName, parser.fileName);
            }
            else if (parser.cmd.matches("DeleteFolder")){
                deleteFolder(parser.path, parser.folderName);
            }
            else if (parser.cmd.matches("DisplayDiskStatus")){
                displayDiskStatus();
            }
            else if (parser.cmd.matches("DisplayDiskStructure")){
                displayDiskStructure();
            }
        }
    }

    public void createFile(String path, String folderName, String fileName, int size) {

    }

    public void createFolder(String path, String folderName) {

    }

    public void deleteFile(String path, String folderName, String fileName) {

    }

    public void deleteFolder(String path, String folderName) {

    }

    public void displayDiskStatus(){
        System.out.println("1-Empty space : " + emptySpace);
        System.out.println("2-Allocated space : " + allocatedSpace);
        System.out.println("3-Empty Blocks in the Disk : ");
        for (int i = 0 ; i < numberOfBlocks ; ++i){
            if (!blocks[i].allocated){
                System.out.print(i + " ");
            }
            if (i % 29 == 0){
                System.out.println("");
            }
        }
        System.out.println("\n4-Allocated  Blocks in the Disk : ");
        for (int i = 0 ; i < numberOfBlocks ; ++i){
            if (blocks[i].allocated){
                System.out.print(i + " ");
            }
            if (i % 29 == 0){
                System.out.println("");
            }
        }
    }

    public void displayDiskStructure(){

    }

    // Should provide => Empty space , Allocated space , Empty blocks , Allocated blocks
    public void allocateContiguous(String name , int size)
    {

    }
    public void allocateLinked(String name , int start , int end)
    {

    }
    public void releaseMemory(String name)
    {

    }

    public class Map{
        String name;
        int start;
        int size;
    }
}
