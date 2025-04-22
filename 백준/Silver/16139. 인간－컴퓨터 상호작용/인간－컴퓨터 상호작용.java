import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String S = br.readLine(); 
        int N = Integer.parseInt(br.readLine()); 

        int[][] alpha = new int[S.length()+1][26]; 

        for(int i = 1;i<= S.length();i++) {
            int searchChar = S.charAt(i-1)-'a';

            for(int j = 0; j < 26; j++) {
                int beforeValue = alpha[i-1][j];
                alpha[i][j] = ( j == searchChar ? beforeValue+1 : beforeValue);
            }
        }

        while(N --> 0){
            st = new StringTokenizer(br.readLine());

            int findIdx = st.nextToken().charAt(0)-'a'; 
            int start = Integer.parseInt(st.nextToken())+1; 
            int end = Integer.parseInt(st.nextToken())+1;

            bw.write((alpha[end][findIdx]-alpha[start-1][findIdx])+"\n");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}