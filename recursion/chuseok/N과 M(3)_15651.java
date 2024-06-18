import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] results;
    static int n;
    static int r;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        results = new int[r];
        backTracking(0);
        System.out.print(sb);
    }

    static void backTracking(int cnt) {
        if(cnt == r) {//숫자의 갯수
            for(int num: results) sb.append(num).append(" ");
            sb.append("\n");
            return;
        }
        for(int i=0; i<n; i++) {//반복 횟수
            results[cnt] = i+1;
            backTracking(cnt+1);//다음
        }
    }
}
