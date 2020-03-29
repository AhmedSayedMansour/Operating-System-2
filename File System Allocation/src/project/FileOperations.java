package project;

import java.io.*;
import java.util.ArrayList;

public class FileOperations {

    public FileOperations() {

    }

    public Disk loadFile() throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream("F:\\FCAI\\OS2\\Assignments\\Operating-System-2\\File System Allocation\\DiskStructure.vfs");
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);


        Directory root = new Directory();
        //Read Directory
        ArrayList<Directory> sub = (ArrayList<Directory>)input.readObject();
        ArrayList<File> files = (ArrayList<File>)input.readObject();
        String name = (String) input.readObject();
        root.subDirectories = sub;
        root.files = files;
        root.name = name;

        int numberOfBlocks = (int) input.readObject();

        Block []blocks = new Block[numberOfBlocks+1];
        for(int i=0 ; i<numberOfBlocks+1 ; i++) blocks[i] = new Block();

        //Read Blocks
        for(int i=0 ; i<numberOfBlocks+1 ; i++)
        {
            ArrayList<Integer> subBlocks = (ArrayList<Integer>) input.readObject();
            boolean allocated = (boolean) input.readObject();
            blocks[i].subBlocks = subBlocks;
            blocks[i].allocated = allocated;
        }

        int  allocatedSpace = (int) input.readObject();
        int  emptySpace = (int) input.readObject();
        int  mode = (int) input.readObject();

        Disk result = new Disk(numberOfBlocks , mode);
        result.blocks = blocks;
        result.allocatedSpace = allocatedSpace;
        result.emptySpace = emptySpace;
        result.directory = root;

        return result;
    }
    public void saveFile(Disk disk) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream("F:\\FCAI\\OS2\\Assignments\\Operating-System-2\\File System Allocation\\DiskStructure.vfs");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        ///Directory
        objectOutputStream.writeObject(disk.directory.subDirectories);
        objectOutputStream.writeObject(disk.directory.files);
        objectOutputStream.writeObject(disk.directory.name);

        objectOutputStream.writeObject(disk.numberOfBlocks);

        ///Blocks
        for(int i=0 ; i<disk.numberOfBlocks+1 ; i++)
        {
            objectOutputStream.writeObject(disk.blocks[i].subBlocks);
            objectOutputStream.writeObject(disk.blocks[i].allocated);
        }

        objectOutputStream.writeObject(disk.allocatedSpace);
        objectOutputStream.writeObject(disk.emptySpace);
        objectOutputStream.writeObject(disk.mode);
        objectOutputStream.close();
    }
    public void clearFile() throws IOException {
        FileWriter file = new FileWriter("F:\\FCAI\\OS2\\Assignments\\Operating-System-2\\File System Allocation\\DiskStructure.vfs", false);
        PrintWriter obj = new PrintWriter(file, false);
        obj.flush();
        obj.close();
        file.close();
    }
}
