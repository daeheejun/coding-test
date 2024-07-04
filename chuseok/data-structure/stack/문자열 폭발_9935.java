import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        String bomb = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            stack.push(input.charAt(i));

            if(stack.size() >= bomb.length()) {
                boolean isSame = true;
                for(int j = 0; j < bomb.length(); j++) {
                    //새로 input이 들어오기 전까지 같지 않음을 확인했음
                    if(stack.get(stack.size()-bomb.length() + j) != bomb.charAt(j)) {
                        isSame = false;
                    }
                }
                if(isSame) {
                    for(int j = 0; j < bomb.length(); j++)
                        stack.pop();
                }
            }
        }
        for(char ch: stack)
            sb.append(ch);
        System.out.println(sb.length()>0?sb:"FRULA");
    }
}
