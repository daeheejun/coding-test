import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    모듈러 곱셈
    (a * b) % c = (a % c * b % c) % c
    (temp * temp * A) % C = ((temp * temp % C) * (A % C)) % C
					  = (((temp * temp % C) % C) * (A % C)) % C 	// (temp * temp % C) = (temp * temp % C) % C
					  = ((temp * temp % C) * A) % C
    */
    static long C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        System.out.print(pow(A, B));
    }
    static long pow(long a, long b) {
        if(b == 0)
            return 1;
        long n = pow(a, b/2);

        if(b % 2 == 1)
            return (n * n % C) * a % C;
        return n * n % C;
    }
}
