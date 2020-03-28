package project;

public class File {
    public String name;
    private String filePath;
    private Block[] allocatedBlocks;

    public File() {
    }

    public File(String name, String filePath, Block[] allocatedBlocks) {
        this.name = name;
        this.filePath = filePath;
        this.allocatedBlocks = allocatedBlocks;
    }
}
