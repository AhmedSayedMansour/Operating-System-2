package project;

import java.util.Arrays;

public class DiskScheduling {

    public void optimized(int[] inputQueue)
    {
        int queue[] = new int[inputQueue.length];
        copy(inputQueue , queue);
        Arrays.sort(queue);

        System.out.println("Optimized Algorithm : ");
        System.out.print("Sequence : ");
        for(int i=0 ; i<queue.length ; i++)
        {
            System.out.print(queue[i] + " ");
        }
        System.out.println("\nTotal number of movement : " + queue[queue.length-1] + "\n");
    }

    public void FCFS(int[] queue , int headPosition)
    {
        int current = headPosition;
        int numberOfMovement = 0;

        System.out.println("FCFS Algorithm : ");
        System.out.print("Sequence : ");
        for(int i=0 ; i<queue.length ; i++)
        {
            System.out.print(queue[i] + " ");
            numberOfMovement += Math.abs(current - queue[i]);
            current = queue[i];
        }
        System.out.println("\nTotal number of movement : " + numberOfMovement + "\n");
    }
    public void SSTF(int[] inputQueue , int headPosition)
    {
        int len = inputQueue.length;
        int queue[] = new int[len];
        copy(inputQueue , queue);
        int current = headPosition;
        int numberOfMovement = 0;
        int index = 0;

        System.out.println("SSTF Algorithm : ");
        System.out.print("Sequence : ");
        for(int i=0 ; i<queue.length ; i++)
        {
            int min = Integer.MAX_VALUE;
            for(int j=0 ; j<queue.length ; j++)
            {
                if(Math.abs(current-queue[j]) < min)
                {
                    min = Math.abs(current-queue[j]);
                    index = j;
                }
            }
            System.out.print(queue[index] + " ");
            numberOfMovement += Math.abs(current - queue[index]);
            current = queue[index];
            queue[index] = Integer.MAX_VALUE;
        }
        System.out.println("\nTotal number of movement : " + numberOfMovement + "\n");
    }
    public void scan(int inputQueue[] , int headPosition , int Direction)
    {
        int len = inputQueue.length;
        int queue[] = new int[len];
        copy(inputQueue , queue);
        Arrays.sort(queue);

        int numberOfMovement = 0;
        int current = headPosition;
        int index = len;
        for(int i=0 ; i<len ; i++)
        {
            if(headPosition == queue[i] || headPosition < queue[i])
            {
                index = i;
                break;
            }
        }
        System.out.println("Scan Algorithm : ");
        System.out.print("Sequence : ");
        if(Direction == 0)
        {
            if(headPosition != queue[index]) index -= 1;
            for(int i=index ; i>=0 ; i--)
            {
                System.out.print(queue[i] + " ");
                numberOfMovement += Math.abs(current - queue[i]);
                current = queue[i];
            }
            for(int i=index+1 ; i<len ; i++)
            {
                System.out.print(queue[i] + " ");
                numberOfMovement += Math.abs(current - queue[i]);
                current = queue[i];
            }
            // Add the Movement till the zero
            numberOfMovement += queue[0] * 2;
        }
        else if(Direction == 1)
        {
            for(int i=index ; i<len ; i++)
            {
                System.out.print(queue[i] + " ");
                numberOfMovement += Math.abs(current - queue[i]);
                current = queue[i];
            }
            for(int i=index-1 ; i>=0 ; i--)
            {
                System.out.print(queue[i] + " ");
                numberOfMovement += Math.abs(current - queue[i]);
                current = queue[i];
            }
            // Add the Movement till the End(200)
            numberOfMovement += (200 - queue[len-1]) * 2;
        }
        System.out.println("\nTotal number of movement : " + numberOfMovement + "\n");

    }

    public void cScan(int inputQueue[] , int headPosition , int direction)
    {
        code(inputQueue , headPosition , direction , 1);
    }
    public void cLook(int inputQueue[] , int headPosition , int direction)
    {
        code(inputQueue , headPosition , direction , 0);
    }

    private void code(int inputQueue[] , int headPosition , int direction , int identifier)
    {
        int len = inputQueue.length;
        int queue[] = new int[len];
        copy(inputQueue , queue);
        Arrays.sort(queue);

        int numberOfMovement = 0;
        int current = headPosition;
        int index = len;
        for(int i=0 ; i<len ; i++)
        {
            if(headPosition == queue[i] || headPosition < queue[i])
            {
                index = i;
                break;
            }
        }
        if(identifier == 1) System.out.println("C-Scan Algorithm : ");
        else System.out.println("C-Look Algorithm : ");
        System.out.print("Sequence : ");
        if(direction == 0)
        {
            if(headPosition != queue[index]) index -= 1;
            for(int i=index ; i>=0 ; i--) {
                System.out.print(queue[i] + " ");
                numberOfMovement += Math.abs(current - queue[i]);
                current = queue[i];
            }
            if(identifier == 1)
            {
                numberOfMovement += current;    // Add the difference till the zero
                numberOfMovement += 200;        // Rotation to the beginning
                current = 200;                  // Set the current
            }
            else
            {
                numberOfMovement += (queue[len-1] - current);
                current = queue[len-1];
            }
            for(int i=len-1 ; i > index ; i--)
            {
                System.out.print(queue[i] + " ");
                numberOfMovement += Math.abs(current - queue[i]);
                current = queue[i];
            }
        }
        else if(direction == 1)
        {
            for(int i=index ; i<len ; i++)
            {
                System.out.print(queue[i] + " ");
                numberOfMovement += Math.abs(current - queue[i]);
                current = queue[i];
            }
            if(identifier == 1)
            {
                numberOfMovement += (200 - current);
                numberOfMovement += 200;
                current = 0;
            }
            else
            {
                numberOfMovement += (current - queue[0]);
                current = queue[0];
            }
            for(int i=0 ; i<index ; i++)
            {
                System.out.print(queue[i] + " ");
                numberOfMovement += Math.abs(current - queue[i]);
                current = queue[i];
            }
        }
        System.out.println("\nTotal number of movement : " + numberOfMovement + "\n");
    }


    public void copy(int[] original , int[] instance) {
        for(int i=0 ; i<original.length ; i++) instance[i] = original[i];
    }

}
