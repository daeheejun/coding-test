import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < str.length(); j++) {
                arr[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        recursive(0, 0, N);
//        System.out.println(white + "\n" + blue);
    }
    static void recursive(int start, int end, int n) {
        int sum = 0;

        for (int i = start; i < start + n; i++) {
            for (int j = end; j < end + n; j++) {
                sum += arr[i][j];
            }
        }

        if (sum == 0) {//0출력
            System.out.print("0");
        }
        else if (sum == n * n) {//1출력
            System.out.print("1");
        }
        else {
            int half = n/2;

            System.out.print("(");
            recursive(start, end, half);
            recursive(start, end + half, half);
            recursive(start + half, end, half);
            recursive(start + half, end + half, half);
            System.out.print(")");
        }
    }
}