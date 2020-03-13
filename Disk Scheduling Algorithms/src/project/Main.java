package project;

public class Main {

    public static void main(String[] args) {
        DiskScheduling disk = new DiskScheduling();

        int queue[] = {38,180,130,10,50,15,190,90,150};
        disk.optimized(queue);
        disk.FCFS(queue , 120);
        disk.SSTF(queue , 120);
        disk.scan(queue , 120 , 0);
        disk.cScan(queue, 120 , 0);
        disk.cLook(queue, 120 , 0);
    }
}
