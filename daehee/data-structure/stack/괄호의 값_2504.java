import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    Stack<String> stack1 = new Stack<>();
    Stack<String> stack2 = new Stack<>();

    //문자열 입력
    String str = br.readLine();
    String[]arr = str.split("");

    for(String s : arr)
    {
      stack1.push(s);
    }

    // 명령어의 갯수 입력
    int M = Integer.parseInt(br.readLine());

    while(M-->0)
    {
      st = new StringTokenizer(br.readLine()," ");

      char command = st.nextToken().charAt(0);


      switch(command)
      {
        case 'L':
          if(stack1.empty()==true)
            break;
          else
          {
            stack2.push(stack1.pop());
            break;
          }

        case 'D':
          if(stack2.empty()==true)
            break;
          else
          {
            stack1.push(stack2.pop());
            break;
          }

        case 'B':
          if(stack1.empty()==true)
            break;
          else
          {
            stack1.pop();
            break;
          }
        case 'P':
          stack1.push(st.nextToken());
          break;
      }

    }

    int s1size = stack1.size();

    for(int i =0 ; i< s1size;i++)
    {
      stack2.push(stack1.pop());
    }

    int s2size = stack2.size();

    for(int i =0 ; i< s2size; i++)
    {
      sb.append(stack2.pop());

    }
    System.out.println(sb);

  }

}
