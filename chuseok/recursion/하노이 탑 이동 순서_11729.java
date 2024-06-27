import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int cnt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        Hanoi(input, 1, 2, 3);
        bw.write(String.valueOf(cnt) + "\n");
        bw.write(sb.toString());

        bw.flush();
        bw.close();
        br.close();
    }

    static void Hanoi(int N, int from, int tmp, int to) {
        if(N == 1) {
            sb.append(from + " " + to + "\n");
            cnt++;
        }
        else {
            Hanoi(N-1, from, to, tmp); //A -> B
            sb.append(from + " " + to + "\n"); // A -> C
            cnt++;
            Hanoi(N-1, tmp, from, to); //B -> C
        }
    }
}