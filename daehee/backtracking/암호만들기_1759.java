import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  static int consonantCount = 0;
  static int vowelCount = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    StringBuilder sb = new StringBuilder();

    int L = Integer.parseInt(st.nextToken());
    int C = Integer.parseInt(st.nextToken());

    List<List<Character>> result = new ArrayList<>();
    st = new StringTokenizer(br.readLine(), " ");

    char[] list = new char[C];
    for (int i = 0; i < C; i++) {
      list[i] = st.nextToken().charAt(0);
    }
    Arrays.sort(list);

    backtrack(L,list, new ArrayList<>(), 0, result);

    for (int i = 0; i < result.size(); i++) {
      for(int j =0 ; j< result.get(i).size(); j++){
        sb.append(result.get(i).get(j));
      }
      if(!(i == result.size()-1)){
        sb.append("\n");
      }

    }
    System.out.println(sb);
//    System.out.println(result.size());
  }

  // 3<=L,C<=15
  // C개중에 L개 뽑는 조합
  // 최소 한개의 모음(a,e,i,o,u) , 최소 2개의 자음
  // 모음 자음 카운트 해서 개수 맞을 때 넘김 OR
  // 조합 구한다음 각 조합에서 모음 개수 , 자음 개수 체크  -> 이게 더오래걸릴것같은데
  static void backtrack(int L,char[] list, List<Character> curr, int start,
      List<List<Character>> result) {

    if (curr.size() == L && consonantCount >= 1 && vowelCount >= 2) {

      result.add(new ArrayList<>(curr));
      return;
    }

    for (int i = start; i < list.length; i++) {
      if (list[i] == 'a' || list[i] == 'e' || list[i] == 'i' || list[i] == 'o' || list[i] == 'u') {
        consonantCount++;
      } else {
        vowelCount++;
      }
      curr.add(list[i]);
      backtrack(L,list, curr, i + 1, result);
      if (list[i] == 'a' || list[i] == 'e' || list[i] == 'i' || list[i] == 'o' || list[i] == 'u') {
        consonantCount--;
      } else {
        vowelCount--;
      }
      curr.remove(curr.size() - 1);
    }

  }
}
