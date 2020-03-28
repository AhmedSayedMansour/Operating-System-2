package project;

public class Main {

    public static void main(String[] args) {

        Directory root = new Directory();
        Directory obj = new Directory("Atef");
        root.subDirectories.add(obj);
        File file = new File();
        root.files.add(file);

        if(checkName(root , "Atef"))
            System.out.println("Good");

        Directory result = getDirectory(root , "Atef");
        System.out.println(result.name);
    }
    public static boolean checkName(Directory dir, String name)
    {
        for(int i=0 ; i<dir.subDirectories.size() ; i++)
        {
            if(dir.subDirectories.get(i).name == name) return true;
        }
        return false;
    }
    public static Directory getDirectory(Directory dir, String name)
    {
        for(int i=0 ; i<dir.subDirectories.size() ; i++)
        {
            if(dir.subDirectories.get(i).name == name) return dir.subDirectories.get(i);
        }
        return null;
    }
}