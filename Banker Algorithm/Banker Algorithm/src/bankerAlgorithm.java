import java.util.*;
public class bankerAlgorithm {
    int numOfProcess,numOfResources;
    int []avaliable;
    int[]oldstate;
    ArrayList<process>processes=new ArrayList<process>();
    public bankerAlgorithm() {
    }
    public bankerAlgorithm(int n, int m) {
        numOfProcess=n;
        numOfResources=m;
        avaliable=new int[m];
        oldstate=new int[m];
        
    }
    bankerAlgorithm(int n, int m,int []avail,int [][]alloc,int [][]max ){    
        numOfProcess=n;
        numOfResources=m;
        avaliable=new int[m];
        oldstate=new int[m];
        int []all;
        int []ma;
        all=new int[m];
        ma=new int[m];
        
        for(int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                all[j]=alloc[i][j];
                ma[j]=max[i][j];
            }
            process a= new process(m, all, ma);
            processes.add(a);
        }
        for (int j=0;j<m;j++){
            avaliable[j]=avail[j];
            oldstate[j]=avail[j];
        }
    } 
    void addProcess(int []alloc,int[]max){
        process a= new process(numOfResources);
        a.setAlloc(alloc);
        a.setMax(max);
        a.setNeed();
        processes.add(a);
    }
    void isSave(){
        int counter=0;
        int [] safeSequence = new int[numOfProcess];
        boolean flag;
        while (counter<numOfProcess){
            flag=false;
            for (int i=0;i<numOfProcess;i++){
                if (processes.get(i).readyToRun(avaliable)&&(!processes.get(i).isDone)){
                    safeSequence[counter++]=i;
                    flag=true;
                    for (int j=0;j<numOfResources;j++){
                        avaliable[j]+=processes.get(i).alloc[j];
                    }
                    processes.get(i).isDone=true;
                    
                }
            }
            if (!flag)
                break;
            
        }
        if (counter<numOfProcess){
            System.out.println("System is unsafe");
            System.out.println("deadlock happen");
            System.out.println("completed processes");
            for (int i=0;i<counter;i++){
                System.out.println("p"+safeSequence[i]);
            }
        }
        else{
            System.out.println("Safe system");
            System.out.println("completed processes: ");
            for (int i=0;i<counter;i++){
                System.out.println("p"+safeSequence[i]);
            }
        }
    }
    void RQ(int proc,int[]alloc){
        processes.get(proc).setAlloc(alloc);
        processes.get(proc).setNeed();
        for (int i=0;i<numOfProcess;i++)
            processes.get(i).isDone=false;
        for (int j=0;j<numOfResources;j++)
            avaliable[j]=oldstate[j];
        isSave();   
    }

}
