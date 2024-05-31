// 시간초과 나서 안됨;;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class myAnswer {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder(br.readLine()); // 답 문자열
        int n = Integer.parseInt(br.readLine()); // 받을 명령 수

        int cursorPosition = answer.length();
        // answer.insert(0, 't');
        // answer.deleteCharAt(cursorPosition);
        // System.out.println("answer: " + answer);
        // System.out.println("cursorPostion: "+cursorPosition);

        // for () {
        //     orderStack.push(br.readLine());
        // }
        // System.out.println("orderStack: "+orderStack);

        for (int i = 0; i < n; i++) {
            // System.out.println("answer: " + answer);
            // System.out.println("cursorPosition: "+ cursorPosition);
            String element = br.readLine();
            switch (element.charAt(0)) {
                case 'L':
                    if (cursorPosition > 0) {
                        cursorPosition--;
                    }

                    break;
                case 'D':
                    if (cursorPosition < answer.length()) {
                        cursorPosition++;
                    }

                    break;

                case 'B':

                    if (cursorPosition > 0) {
                        answer.deleteCharAt(cursorPosition - 1);
                        cursorPosition--;
                    }
                    break;

                default:
                    answer.insert(cursorPosition, element.charAt(2));
                    cursorPosition++;
                    break;
            }
        }

        bw.write(answer.toString());

        // bw.flush(); // 버퍼 강제 출력
        bw.close();
        br.close();

    }
}
