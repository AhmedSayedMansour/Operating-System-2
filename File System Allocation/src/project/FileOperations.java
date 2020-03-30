package project;

import java.io.*;

public class FileOperations implements Serializable{


    private static final long serialVersionUID = 1L;
    String path = "F:\\FCAI\\OS2\\Assignments\\Operating-System-2\\File System Allocation\\DiskStructure.vfs";
    public FileOperations() {

    }
    public void saveFile(Disk disk) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(disk);

        fileOutputStream.close();
        objectOutputStream.close();
    }
    public Disk loadFile() throws IOException, ClassNotFoundException {

        InputStream file = new FileInputStream(path);
        InputStream buffer = new BufferedInputStream(file);
        ObjectInput input = new ObjectInputStream(buffer);

        Disk disk = (Disk) input.readObject();

        file.close();
        buffer.close();
        input.close();

        return  disk;
    }
    public void clearFile() throws IOException {
        FileWriter file = new FileWriter(path, false);
        PrintWriter obj = new PrintWriter(file, false);
        obj.flush();
        obj.close();
        file.close();
    }

}
