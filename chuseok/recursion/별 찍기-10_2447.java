import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /*
    N * N
    가운데 공백
    3^1 -> 3*3크기 arr[1][1]= 공백
    3^2 -> 9*9크기 arr[1][1]= 공백
    3^3 -> 27*27크기
        공백이 아닌 블럭 재귀호출
    */
    static char[][] stars;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        stars = new char[N][N];
        drawStar(0, 0, N, false);

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                sb.append(stars[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    static void drawStar(int x, int y, int N, boolean blank) {
        if(blank) {
            for(int i=x; i<x + N; i++) {
                for(int j=y; j<y + N; j++) {
                    stars[i][j] = ' ';
                }
            }
            return;
        }

        //더이상 쪼개지지 않는다.
        if(N <= 1) {
            stars[x][y] = '*';
            return;
        }

        int blockSize = N/3;
        int blockCnt = 0;
        for(int i=x; i<x + N; i += blockSize) {
            for(int j=y; j<y + N; j += blockSize) {
                blockCnt++;
                //9개의 block에서 5번째는 공백
                if(blockCnt == 5) {
                    drawStar(i, j, blockSize, true);
                } else {
                    drawStar(i, j, blockSize, false);
                }
            }
        }
    }
}
