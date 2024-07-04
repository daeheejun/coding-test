import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baekjoon25501 {

  public static int cnt = 0;

  public static int recursion(String s, int l, int r) {
      if (l >= r) {
          return 1;
      } else if (s.charAt(l) != s.charAt(r)) {
          return 0;
      } else {
          cnt++;
          return recursion(s, l + 1, r - 1);
      }
  }

  public static int isPalindrome(String s) {
    cnt = 0;
    return recursion(s, 0, s.length() - 1);
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int T = Integer.parseInt(br.readLine());
    String[] S = new String[T];

    for (int i = 0; i < T; i++) {
      S[i] = br.readLine();
    }

    for (int i = 0; i < S.length; i++) {
      sb.append(isPalindrome(S[i])).append(" ").append(cnt + 1).append("\n");
    }

    System.out.println(sb);
  }
}