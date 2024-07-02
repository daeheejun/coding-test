import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int sum = 0;
        int weight = 1;

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if(isOpenCharacter(ch)){
                stack.push(ch);
                weight *= getWeight(ch);
            } else {
                if(!stack.isEmpty() && isMatch(stack.peek(), ch)) {
                    if (ch == ')') {// 바로 직전 괄호 처리
                        if (input.charAt(i - 1) == '(') 
                            sum += weight;
                    } else {
                        if (input.charAt(i - 1) == '[')
                            sum += weight;
                    }
                    stack.pop();
                    weight /= getWeight(ch);
                } else {
                    sum = 0;
                    break;
                }
            }
        }
        System.out.println(!stack.isEmpty() ? 0 : sum);
    }
    private static boolean isOpenCharacter(char c) {
        return c == '(' || c == '[';
    }

    private static int getWeight(char c) {
        return c == '(' || c == ')' ? 2 : 3;
    }

    private static boolean isMatch(Character peek, char c) {
        if (peek == '(' && c == ')')
            return true;
        if (peek == '[' && c == ']')
            return true;
        return false;
    }
}
