import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    Stack<Character> stack1 = new Stack<>();
    Stack<Character> stack2 = new Stack<>();

    String[] str = new String[N];

    for (int i = 0; i < N; i++) {
      str[i] = br.readLine();
    }

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < str[i].length(); j++) {
        switch (str[i].charAt(j)) {
          // 커서 위치 오른쪽으로 이동
          case '>':
            if(!stack2.empty())
              stack1.push(stack2.pop());
            break;
          // 커서 위치 왼쪽으로 이동
          case '<':
            if(!stack1.empty())
              stack2.push(stack1.pop());
            break;
          case '-':
            if(!stack1.empty())
              stack1.pop();
            break;
          default:
            stack1.push(str[i].charAt(j));
        }
      }
      while(!stack1.empty())
      {
        stack2.push(stack1.pop());
      }
      while(!stack2.empty())
      {
        sb.append(stack2.pop());
      }
      sb.append("\n");
    }


    System.out.println(sb);

  }
}
