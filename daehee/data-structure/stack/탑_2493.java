import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    String str = br.readLine();
    Stack<Character> stack = new Stack<>();
    int value = 1;
    int result = 0;

    boolean isValid = true;  // 추가: 입력이 유효한지 여부를 나타내는 플래그

    for (int i = 0; i < str.length(); i++) {
      char c = str.charAt(i);
      switch (c) {
        case '(':
          stack.push(c);
          value *= 2;
          break;
        case ')':
          if (stack.isEmpty() || stack.peek() != '(') {
            isValid = false;
            break;
          }
          if (str.charAt(i - 1) == '(') {
            result += value;
          }
          stack.pop();
          value /= 2;
          break;
        case '[':
          stack.push(c);
          value *= 3;
          break;
        case ']':
          if (stack.isEmpty() || stack.peek() != '[') {
            isValid = false;
            break;
          }
          if (str.charAt(i - 1) == '[') {
            result += value;
          }
          stack.pop();
          value /= 3;
          break;
        default:
          isValid = false;  // 추가: 잘못된 문자에 대해 입력이 유효하지 않다고 표시
          break;
      }
      if (!isValid) {  // 추가: 입력이 유효하지 않으면 더 이상 검사하지 않음
        result = 0;
        break;
      }
    }

    if (!isValid || !stack.isEmpty()) {  // 추가: 입력이 유효하지 않거나 스택이 비어 있지 않으면 0 반환
      sb.append(0).append("\n");
    } else {
      sb.append(result).append("\n");
    }
    System.out.println(sb);
  }
}