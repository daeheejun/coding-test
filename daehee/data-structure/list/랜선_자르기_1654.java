import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int K = Integer.parseInt(st.nextToken());  // 랜선 개수
    int N = Integer.parseInt(st.nextToken());  // 필요한 랜선 개수

    int answer =0;
    int[] arr = new int[K];

    for (int i = 0; i < K; i++) {
      arr[i] = Integer.parseInt(br.readLine());
    }
    Arrays.sort(arr);
    long low = 0;
    long high = arr[arr.length - 1];

    high ++;
    while (low < high) {
      long cnt = 0;
      long mid = (low + high) / 2;

      for (int a : arr) {
        cnt += a / mid;
      }

      if (cnt < N) {
        high = mid ;

      }
      else{
        low = mid + 1;
      }

    }
    answer = (int) (low-1);
    System.out.println(answer);
  }
}
