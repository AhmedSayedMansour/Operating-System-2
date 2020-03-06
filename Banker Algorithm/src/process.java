
public class process {
    
    int resources;
    int [] alloc;
    int [] max;
    int []need;
    boolean isDone=false;

    process() {
    }
    
    process(int re){
        resources  = re;
        alloc=new int[re];
        max=new int[re];
        need=new int [re];
    }

    process(int re, int []all,int[]ma) {
        resources=re;
        alloc=new int[re];
        max=new int[re];
        need=new int[re];
        for (int i=0;i<re;i++){
            alloc[i]=all[i];
        }
        for (int i=0;i<re;i++){
            max[i]=ma[i];
        }
        setNeed();
    }
    
    
    void setAlloc(int []arr){
        for (int i=0;i<resources;i++){
            alloc[i]=arr[i];
        }
    }
    void setMax(int []arr){
        for (int i=0;i<resources;i++){
            max[i]=arr[i];
        }
    }
    void setNeed(){
        for (int i=0;i<resources;i++){
            need[i]=max[i]-alloc[i];
        }
    }
    
    boolean readyToRun(int []arr){
        for (int i=0;i<resources;i++){
            if (arr[i]<need[i])
                return false;
        }
        return true;
    }
}
