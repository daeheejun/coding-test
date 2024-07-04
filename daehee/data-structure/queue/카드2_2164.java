import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    Queue<Integer> q = new LinkedList<>();
    // 1<=N<=500000 카드 갯수
    int N = Integer.parseInt(br.readLine());
    // 제일 마지막에 남게 되는 카드 숫자
    int result = 0;

    for(int i =1; i<= N; i++)
    {
      q.add(i);
    }

    while(q.size()!=1)
    {
      q.remove();
      q.add(q.remove());
    }

    result = q.remove();
    System.out.println(result);
  }
}