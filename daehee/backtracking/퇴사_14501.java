import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int N = Integer.parseInt(br.readLine());  // 1<= N <= 15

    int[] T = new int[N];   // 상담할 때 걸리는 기간
    int[] P = new int[N];   // 상담할 때 벌수있는 돈

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      T[i] = Integer.parseInt(st.nextToken());
      P[i] = Integer.parseInt(st.nextToken());
    }

    List<List<Integer>> list = new ArrayList<>();

    backtrack(new ArrayList<>(), list, T, N, 0);

    int max = 0;
    for (int i = 0; i < list.size(); i++) {
      int temp = 0;
      for (int j = 0; j < list.get(i).size(); j++) {
        temp += P[list.get(i).get(j) - 1];
      }
      if (temp > max) {
        max = temp;
      }
    }
    System.out.println(max);
//    System.out.println(list);

  }

  static void backtrack(List<Integer> currList, List<List<Integer>> list, int[] T,  int N, int start) {
    if (!(currList.isEmpty())) {
      list.add(new ArrayList<>(currList));
    }
    for (int i = start; i < N; i++) {
      if (i + T[i] <= N) {
        currList.add(i + 1);
        backtrack(currList, list, T, N, i+T[i]);
        currList.remove(currList.size()-1);
      }
    }
  }
}
