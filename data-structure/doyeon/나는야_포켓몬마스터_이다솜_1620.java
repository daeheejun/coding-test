// test
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 나는야_포켓몬마스터_이다솜_1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();

        Map<String, Integer> poketmonMap = new HashMap<>();
        Map<Integer, String> poketmonMap2 = new HashMap<>();
        Stack<String> poketmonCheckArr = new Stack<>();

        String[] numList = str.split(" ");

        int numberOfPoketmons = Integer.parseInt(numList[0]);
        int numberOfQueries = Integer.parseInt(numList[1]);

        for (int i = 0; i < numberOfPoketmons; i++) {
            String temp = br.readLine();
            poketmonMap.put(temp, i + 1);
            poketmonMap2.put(i + 1, temp);
        }

        for (int i = 0; i < numberOfQueries; i++) {
            poketmonCheckArr.push(br.readLine());
        }

        // System.out.println(poketmonCheckArr);
        // System.out.println("포켓몬맵1" + poketmonMap);
        // System.out.println("포켓몬맵2" + poketmonMap2);
        // System.out.println("---");

        // Stack을 List로 변환한 후 역순으로 반복
        for (int i = 0; i < poketmonCheckArr.size(); i++) {
            String answer = poketmonCheckArr.get(i);
            if (Character.isDigit(answer.charAt(0))) {
                bw.write(poketmonMap2.get(Integer.parseInt(answer)) + System.lineSeparator());
            } else {
                bw.write(poketmonMap.get(answer) + System.lineSeparator());
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}