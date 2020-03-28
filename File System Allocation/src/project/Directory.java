package project;

import java.util.ArrayList;

public class Directory {
    //private String directoryPath;
    public ArrayList<File> files;
    public String name;
    public ArrayList<Directory> subDirectories;
    private boolean deleted = false;

    public Directory() {
        files = new ArrayList<>();
        subDirectories = new ArrayList<>();
        this.name = name;
    }
    public Directory(String name)
    {
        files = new ArrayList<>();
        subDirectories = new ArrayList<>();
        this.name = name;
    }
    /*public Directory(String directoryPath) {
        this.directoryPath = directoryPath;
    }
    */
    public void createFolder(String path , String name)
    {

    }
    public void deleteFolder(String path , String name)
    {

    }

    public void createFile(String path , String name , int size)
    {
        File newFile = new File();
    }
}
