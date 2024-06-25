import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> list = new ArrayList<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            isPalindrome(br.readLine());
        }
    }
    static int isPalindrome(String s) {
        return recursion(s, 0, s.length()-1);
    }

    static int recursion(String s, int l, int r){
        cnt++;
        if(l >= r) {
            System.out.println("1 "+ cnt);
            cnt = 0;
            return 1;
        }
        else if(s.charAt(l) != s.charAt(r)) {
            System.out.println("0 "+ cnt);
            cnt = 0;
            return 0;
        }
        else return recursion(s, l+1, r-1);
    }
}
