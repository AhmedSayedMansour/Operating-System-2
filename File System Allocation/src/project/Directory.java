package project;

import java.util.ArrayList;

public class Directory {
    private String directoryPath;
    private ArrayList<File> files;
    private ArrayList<Directory> subDirectories;
    private boolean deleted = false;

    public Directory(String directoryPath) {
        this.directoryPath = directoryPath;
    }

    public void createFolder(String path , String name)
    {

    }
    public void deleteFolder(String path , String name)
    {

    }

    public void createFile(String path , String name , int size)
    {

    }
}
