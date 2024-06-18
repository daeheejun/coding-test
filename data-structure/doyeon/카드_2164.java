import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class 카드2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        // System.out.println(n);

        Queue<String> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.add(Integer.toString(i));
        }
        // System.out.println(queue);

        while (queue.size() > 1) {
            // System.out.println("start: "+queue);
            queue.remove();

            String temp = queue.remove();
            // System.out.println(temp);
            queue.add(temp);
            // queue.remove();
            // System.out.println("end: "+queue);
        }
        // System.out.println(queue);
        bw.write(queue.element());
        bw.flush(); // 버퍼 강제 출력
        bw.close();
        br.close();

    }
}