import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args)throws IOException{

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    //Hashmap<key,value>형태
    Map<String,Integer> Poketmon1 = new HashMap<>();  //이름,index
    Map<Integer,String> Poketmon2 = new HashMap<>();  //index, 이름

    //도감에 수록되어있는 포켓몬 숫자 1<=N<=100000
    int N = Integer.parseInt(st.nextToken());

    // 문제수 1<=N<=100000
    int M = Integer.parseInt(st.nextToken());

    for(int i = 1; i<=N; i++)
    {
      String p_name = br.readLine();
      Poketmon1.put(p_name,i);
      Poketmon2.put(i,p_name);
    }


    while(M-->-0)
    {
      String tmp = br.readLine();
      if(Character.isDigit(tmp.charAt(0))) //숫자이면
      {
        System.out.println(Poketmon2.get(Integer.parseInt(tmp)));
      }
      else                                        // 숫자가 아니면
      {
        System.out.println(Poketmon1.get(tmp));  //value 값출력
      }

    }
  }
}