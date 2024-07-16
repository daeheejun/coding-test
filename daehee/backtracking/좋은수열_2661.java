import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  static String[] nums = {"1", "2", "3"};
  static boolean found = false;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());  // 1<=N<=80 , 수열의 길이
    backtrack(0, "", N);
  }

  static void backtrack(int start, String makeCheckStr, int N) {
    if(found)
      return;
    if (start == N) {
      System.out.println(makeCheckStr);
      found = true;
      return;
    }
    for (int i = 0; i < nums.length; i++) {
      if (checkGoodSequece(makeCheckStr+nums[i])) {
        backtrack(start + 1, makeCheckStr + nums[i], N);
      }
    }
  }

  public static boolean checkGoodSequece(String checkStr) {
    for (int i = 1; i <= checkStr.length() / 2; i++) {
      for (int j = 0; j <= checkStr.length() - i * 2; j++) {
        if (checkStr.substring(j, j + i).equals(checkStr.substring(j + i, j + i * 2))) {
          return false;
        }
      }
    }
    return true;
  }
}
