import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    a의 max 값이 2^31-1 이라 가정
    지수 법칙
    (a^1 * a^1 * a) % c 의 경우 (2^31-1)^3이라면 long 범위를 초과한다
    따라서 모듈러 곱셈 공식으로 표현한다

    모듈러 곱셈
    (a * b) % c = (a % c * b % c) % c
    (temp * temp * A) % C = ((temp * temp % C) * (A % C)) % C
					  = (((temp * temp % C) % C) * (A % C)) % C
					  // (temp * temp % C) = (temp * temp % C) % C
					  // C로 나눈 나머지를 또 C로 나누어도 값은 같다
					  // temp + temp % C 가 A고
					  // A가 B라면
					  // 모듈러 합동 공식에 의해 아래와 같이 표현할 수 있다
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
        if(b == 1)
            return a;
        long tmp = pow(a, b/2);

        if(b % 2 == 1)
            return (tmp * tmp % C) * a % C;
        return tmp * tmp % C;
    }
}