



import java.io.*;
public class Main {
    public static void main(String[] args)throws IOException{
        // Scanner sc = new Scanner((System.in));
        // int a = sc.nextInt();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int a = Integer.parseInt(br.readLine());
        int[] b = new int [a*2];
        for(int i=0;i<a;i++){
            b[i] = i+1;
        }

        int index = 0;
        int l_index = a;
        while(index+1 < l_index){
            b[l_index] = b[index+1];
            index = index+2;
            l_index++;
        }
        //System.out.println(b[index]);
        bw.write(String.valueOf(b[index]));
        bw.flush();
        //bw.close();
    }
}



