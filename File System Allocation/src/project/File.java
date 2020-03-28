package project;

public class File {
    public String name;
    private String filePath;
    private Block[] allocatedBlocks;
    private boolean deleted;

    File(){}
    public void createFile(String path , String name , int size)
    {
        this.name = name;
        filePath = path;
    }
    public void deleteFile(String path , String name)
    {

    }
}
