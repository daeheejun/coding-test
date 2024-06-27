import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int blue = 0, white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursive(0, 0, N);
        System.out.println(white + "\n" + blue);
    }
    static void recursive(int start, int end, int n) {
        int sum = 0;

        for (int i = start; i < start + n; i++) {
            for (int j = end; j < end + n; j++) {
                sum += arr[i][j];
            }
        }

        if (sum == 0) white++;
        else if (sum == n * n) blue++;
        else {
            int half = n/2;

            recursive(start, end, half);
            recursive(start, end + half, half);
            recursive(start + half, end, half);
            recursive(start + half, end + half, half);
        }
    }
}