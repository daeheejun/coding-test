import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    /*
    1<=N<=100,000
    */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        List<Character> list = new LinkedList<>();
        for(int i=0; i<inputStr.length(); i++) list.add(inputStr.charAt(i));

        int commandCnt = Integer.parseInt(br.readLine());
        ListIterator<Character> listIterator = list.listIterator(list.size());

        for(int i=0; i<commandCnt; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);

            switch (command) {
                case 'L': {
                    if(listIterator.hasPrevious()) listIterator.previous();
                    break;
                }
                case 'D': {
                    if(listIterator.hasNext()) listIterator.next();
                    break;
                }
                case 'B': {
                    if(listIterator.hasPrevious()) {
                        listIterator.previous();
                        listIterator.remove();
                    }
                    break;
                }
                case 'P': {
                    listIterator.add(st.nextToken().charAt(0));
                }
            }
        }
        StringBuilder result = new StringBuilder();
        for(char c: list) result.append(c);
        System.out.print(result);
    }
}