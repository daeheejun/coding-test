import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    /*
    입력
    도감에 수록된 포켓몬 개수 N, 문제 개수 M
    1~N: 이름
    1~M: 문제 if 알파벳: 번호 / 숫자: 이름

    조건
    1 <= N과 M <=100,000
    이름은 영어
    첫글자 대문자, 일부는 마지막 글자만 대문자
    2 <=이름 길이 <= 20
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int poketmonCount = Integer.parseInt(st.nextToken()),
                questionCount = Integer.parseInt(st.nextToken());

        Map<String, String> poketmonGuide = new HashMap<>();

        for(int i=1; i<=poketmonCount; i++) {
            String inputStr = br.readLine();
            poketmonGuide.put(inputStr, Integer.toString(i));
            poketmonGuide.put(Integer.toString(i), inputStr);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<questionCount; i++) {
            sb.append(poketmonGuide.get(br.readLine()));
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
