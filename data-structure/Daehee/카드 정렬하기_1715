import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
  public static void main(String[] args) throws IOException {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 1<=N<=100000 카드 묵음 갯수
    int N = Integer.parseInt(br.readLine());
    // 최소 비교횟수
    int result = 0;
    // 정렬해서 작은 숫자 끼리 더하면 되겠당
    // PriortyQueue 우선순위가 낮은 숫자가 먼저 나옴

    for(int i = 0; i< N; i++)
    {
      pq.add(Integer.parseInt(br.readLine()));
    }

    while(pq.size()!=1)
    {
      int temp  = pq.remove()+ pq.remove() ;
      pq.add(temp);
      result += temp;
    }


    System.out.println(result);
  }
}
//수정
