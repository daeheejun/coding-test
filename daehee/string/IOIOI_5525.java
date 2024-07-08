package string;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1<=N<=1000000  N을 OI의 개수라고 생각
    int N = Integer.parseInt(br.readLine());

    // 2N+1 <= M <= 1000000
    int M = Integer.parseInt(br.readLine());

    // S는 I랑 O만 있음
    String S = br.readLine();

    int cnt = 0, answer = 0;

    // i=0인경우 무조건 Pn이 I로 시작해서 의미 없음
    // M-1은 조건에서 i+1의 경우도 검사하기 때문에 의미 없음
    for (int i = 1; i < M - 1; ) {
      if (S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
        cnt++;
        if (cnt == N) {
          if (S.charAt(i - (cnt * 2 - 1)) == 'I')
            answer++;
          cnt--;
        }
        i += 2;
      } else {
        cnt = 0;
        i++;
      }
    }
    System.out.println(answer);

  }
}
