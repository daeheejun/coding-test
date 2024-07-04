import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static int bluePaper = 0 ;
  public static int whitePaper = 0 ;

  public static boolean isBlue(int[][] arr){
    return arr[0][0] == 1;  //파란색(1)이면 true반환
  }
  public static boolean isWhite(int[][] arr){
    return arr[0][0] == 0;  //흰색(0)이면 true반환
  }
  public static boolean isAllSame(int[][]arr, int n){
    int targetValue = arr[0][0];
    for(int i=0; i<n; i++){
      for(int j=0; j<n; j++){
        if(targetValue != arr[i][j]){
          return false;
        }
      }
    }
    return true;
  }
  public static void func(int [][]arr , int n){
    if(isAllSame(arr,n)){
      if(isBlue(arr))
        bluePaper++;
      else if (isWhite(arr))
        whitePaper++;
    }
    else{
      int [][]newArr = new int[n/2][n/2];
      for(int i=0; i<n/2; i++){
        for(int j=0; j<n/2; j++){
          newArr[i][j] = arr[i][j];
        }
      }
      func(newArr,n/2);

      for(int i=0; i<n/2; i++){
        for(int j=0; j<n/2; j++){
          newArr[i][j] = arr[i][j+n/2];

        }
      }
      func(newArr,n/2);
      for(int i=0; i<n/2; i++){
        for(int j=0; j<n/2; j++){
          newArr[i][j] = arr[i+n/2][j];

        }
      }
      func(newArr,n/2);
      for(int i=0; i<n/2; i++){
        for(int j=0; j<n/2; j++){
          newArr[i][j] = arr[i+n/2][j+n/2];

        }
      }
      func(newArr,n/2);

    }

  }
  public static void main(String[] args)throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st ;
    int N = Integer.parseInt(br.readLine());
    int [][]arr = new int[N][N];
    for(int i = 0;i < N;i++){
      st = new StringTokenizer(br.readLine());
      for(int j = 0;j < N;j++){
        arr[i][j] = Integer.parseInt(st.nextToken());
      }
    }

//        StringBuilder sb1 = new StringBuilder();
//        for(int i = 0; i < N; i++){
//            for(int j = 0; j < N; j++){
//                sb1.append(arr[i][j]);
//            }
//            sb1.append("\n");
//        }
//        System.out.println(sb1);
    func(arr,N);
    sb.append(whitePaper).append("\n").append(bluePaper).append("\n");
    System.out.println(sb);
  }
}
