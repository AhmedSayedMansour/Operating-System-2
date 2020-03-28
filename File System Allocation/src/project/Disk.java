package project;

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
            String []dirs = parser.path.split(" ");
            if(!dirs[0].equals("root"))
            {
                System.out.println("Wrong path!");
                return;
            }
            if (parser.cmd.matches("CreateFile")){
                createFile(dirs , parser.folderName, parser.fileName , parser.size , 1 , directory);
            }
            else if (parser.cmd.matches("CreateFolder")){
                createFolder(dirs, parser.folderName , 1 , directory);
            }
            else if (parser.cmd.matches("DeleteFile")){
                deleteFile(parser.path, parser.folderName, parser.fileName);
            }
            else if (parser.cmd.matches("DeleteFolder")){
                deleteFolder(dirs, parser.folderName , 1 , directory);
            }
            else if (parser.cmd.matches("DisplayDiskStatus")){
                displayDiskStatus();
            }
            else if (parser.cmd.matches("DisplayDiskStructure")){
                System.out.println("root");
                displayDiskStructure(directory , 4 , 1);
            }
        }
    }

    public void createFile(String[] path, String folderName, String fileName, int size , int index , Directory current) {
        if(index < path.length)
        {
            if(checkName(current ,path[index]))
            {
                createFile(path, folderName, fileName, size , index+1 , getDirectory(current , path[index]));
            }
            else
            {
                current.subDirectories.add(new Directory(path[index]));
                createFile(path , folderName , fileName , size , index+1 , getDirectory(current , path[index]));
            }
        }
        else if (index == path.length)
        {
            String completePath = "";
            for(int i=0 ; i<path.length ; i++) completePath += path[i] + " ";
            // Not completed // You can do it mans
            current.createFile(completePath , fileName , size);
        }
    }

    public boolean checkName(Directory dir, String name)
    {
        for(int i=0 ; i<dir.subDirectories.size() ; i++)
        {
            if(dir.subDirectories.get(i).name == name) return true;
        }
        return false;
    }
    public Directory getDirectory(Directory dir, String name)
    {
        for(int i=0 ; i<dir.subDirectories.size() ; i++)
        {
            if(dir.subDirectories.get(i).name == name) return dir.subDirectories.get(i);
        }
        return null;
    }
    public void createFolder(String[] path, String folderName , int index , Directory current) {
        if(index < path.length)
        {
            if(checkName(current ,path[index]))
            {
                createFolder(path, folderName,index+1 , getDirectory(current , path[index]));
            }
            else
            {
                current.subDirectories.add(new Directory(path[index]));
                createFolder(path , folderName ,index+1 , getDirectory(current , path[index]));
            }
        }
        else if (index == path.length)
        {
            current.subDirectories.add(new Directory(folderName));
        }
    }

    public void deleteFile(String path, String folderName, String fileName) {

    }

    public void deleteFolder(String[] path, String folderName , int index , Directory current) {
        if(index < path.length)
        {
            if(checkName(current ,path[index]))
            {
                createFolder(path, folderName,index+1 , getDirectory(current , path[index]));
            }
            else
            {
                System.out.println("Wrong path!");
                return;
            }
        }
        else if (index == path.length)
        {
            if(checkName(current , folderName))
            current.subDirectories.remove(getDirectory(current , folderName));
        }
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

    public void displayDiskStructure(Directory current , int spaces , int level){

        if(current.subDirectories.size() == 0 && current.files.size() == 0) return;

        else if(current.subDirectories.size() ==0)
        {
            for (int i=0 ; i<current.files.size() ; i++)
            {
                for (int j=0 ; j<spaces*level ; j++) System.out.print(" ");
                System.out.println(current.files.get(i).name);
            }
            return;
        }
        else
        {
            for (int i=0 ; i<current.files.size() ; i++)
            {
                for (int j=0 ; j<spaces*level ; j++) System.out.print(" ");
                System.out.println(current.files.get(i).name);
            }
            for (int i=0 ; i<current.subDirectories.size() ; i++)
            {
                for (int j=0 ; j<spaces*level ; j++) System.out.print(" ");
                System.out.println(current.subDirectories.get(i).name);
                displayDiskStructure(current.subDirectories.get(i) , spaces ,level+1);
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

    public class Map{
        String name;
        int start;
        int size;
    }
}
