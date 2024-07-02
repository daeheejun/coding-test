import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    /*
    1<=N<=500,000
    맨 위는 버리고 다음 카드는 제일 밑으로
    한 장 남을 때까지 반복
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> cards = new LinkedList<>();
        int cnt = Integer.parseInt(br.readLine());
        for(int i=1; i<=cnt; i++) cards.add(i);

        while(cards.size() > 1) {
            cards.poll();
            int downCard = cards.poll();
            cards.add(downCard);
        }
        System.out.print(cards.poll());
    }
}
