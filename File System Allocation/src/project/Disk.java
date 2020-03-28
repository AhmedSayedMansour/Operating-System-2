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

    public void createFile(String path, int size) {

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
    // Display Directories and files in tree structure
    public void displayDiskStructure()
    {

    }

    public class Map{
        String name;
        int start;
        int size;
    }
}
