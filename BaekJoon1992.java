import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1992 {

  public static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int[][] arr = new int[N][N];
    for (int i = 0; i < N; i++) {
      String str = br.readLine();
      for (int j = 0; j < N; j++) {
        arr[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
      }
    }
    recur(N, arr);
    System.out.println(sb);
    ;

  }

  public static StringBuilder recur(int n, int[][] arr) {
    int temp = arr[0][0];
    boolean flag = false;
    out:
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (temp != arr[i][j]) {
          flag = true;
          break out;
        }

      }
    }
    if (!flag) {
      sb.append(arr[0][0]);
    }

    if (flag) {
      sb.append("(");
      int[][] arr1 = new int[n / 2][n / 2];
      for (int i = 0; i < n / 2; i++) {
        for (int j = 0; j < n / 2; j++) {
          arr1[i][j] = arr[i][j];
        }
      }
      recur(n / 2, arr1);

      int[][] arr2 = new int[n / 2][n / 2];
      for (int i = 0; i < n / 2; i++) {
        for (int j = 0; j < n / 2; j++) {
          arr2[i][j] = arr[i][j + n / 2];  // x,y가 아니라 행렬인데 바보같이 생각했다.
        }
      }
      recur(n / 2, arr2);

      int[][] arr3 = new int[n / 2][n / 2];
      for (int i = 0; i < n / 2; i++) {
        for (int j = 0; j < n / 2; j++) {
          arr3[i][j] = arr[i + n / 2][j];
        }
      }
      recur(n / 2, arr3);

      int[][] arr4 = new int[n / 2][n / 2];
      for (int i = 0; i < n / 2; i++) {
        for (int j = 0; j < n / 2; j++) {
          arr4[i][j] = arr[i + n / 2][j + n / 2];
        }
      }
      recur(n / 2, arr4);
      sb.append(")");
    }

    return sb;

  }
}

//      배열확인
//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N; j++){
//                sb.append(arr[i][j]);
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);