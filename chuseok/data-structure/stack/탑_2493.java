import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<int[]> stack = new Stack<>();
        for(int i = 1; i <= cnt; i++) {
            int input = Integer.parseInt(st.nextToken());
            while (!stack.isEmpty()) {
                if(stack.peek()[1] >= input) {
                    sb.append(stack.peek()[0]).append(" ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()) {
                sb.append("0").append(" ");
            }
            stack.push(new int[] {i, input});
        }

        System.out.println(sb);
    }
}
