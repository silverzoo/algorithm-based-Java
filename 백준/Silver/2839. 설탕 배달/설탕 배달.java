import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        br.close();

        int basket =  0; 

        while(N > 0){
            if(N % 5  == 0){ 
                basket += N/5;
                break;
            }else { 
                N -= 3;
                basket++;
            }
            if(N < 0){ 
                basket = -1;
            }
        }
        bw.write(basket + "");
        bw.flush();
        bw.close();

    }
}