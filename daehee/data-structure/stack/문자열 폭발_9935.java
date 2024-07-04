import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String str = br.readLine();
    String bomb = br.readLine();

    Stack<Character> stack = new Stack<>();


    for(int i =0 ; i<str.length(); i++) {
      stack.push(str.charAt(i));

//
      if (stack.size() >= bomb.length()) {
        boolean isBomb = true;
        for (int j = 0; j < bomb.length(); j++) {
          if (stack.get(stack.size() - bomb.length() + j) != bomb.charAt(j)) {
            isBomb = false;
            break;
          }
        }
        // bomb 문자열과 일치하면 pop 처리
        if (isBomb) {
          for (int j = 0; j < bomb.length(); j++) {
            stack.pop();
          }
        }
      }
    }
    if (stack.isEmpty()) {
      sb.append("FRULA");
    }
    else{
      while(!stack.isEmpty())
      {
        sb.append(stack.pop());
      }
      sb.reverse();
    }
    System.out.println(sb);
  }
}
