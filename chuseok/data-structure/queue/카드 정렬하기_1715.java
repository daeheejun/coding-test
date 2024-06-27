import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    1<=N<=100,000
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        while(T-->0) priorityQueue.add(Integer.parseInt(br.readLine()));

        int sum = 0;
        while(priorityQueue.size() > 1) {
            int tmpSum = priorityQueue.poll() + priorityQueue.poll();
            sum += tmpSum;
            priorityQueue.add(tmpSum);
        }
        System.out.print(sum);
    }
}
