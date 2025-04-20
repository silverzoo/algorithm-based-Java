import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static char[][] chessBoard;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        chessBoard = new char[N][M];

        char[] tmp;

        for(int i = 0; i < N; i++){
            tmp = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) {
                chessBoard[i][j] = tmp[j];
            }
        }

        int[][] prefixSumBlack = prefixSum('B');
        int[][] prefixSumWhite = prefixSum('W');

        System.out.println(Math.min(cutChessBoard(prefixSumBlack), cutChessBoard(prefixSumWhite)));
    }

    //체스판 KxK로 자르기
    private static int cutChessBoard(int[][] prefixSum){
        int result = Integer.MAX_VALUE;
        for(int i = 1; i <= N-K+1; i++){
            for(int j = 1; j <= M-K+1; j++){
                int num = prefixSum[i+K-1][j+K-1] - prefixSum[i-1][j+K-1] - prefixSum[i+K-1][j-1] + prefixSum[i-1][j-1];

                result = Math.min(num, result);
            }
        }
        return result;
    }

    //체스 누적합 구하기
    private static int[][] prefixSum(char color){
        int[][] tmp = new int[N+1][M+1];

        for(int i = 0; i < N; i++){
            for(int j = 0;  j < M; j++){
                
                int currentValue = 0;

                if((i+j) % 2 == 0){
                    currentValue = chessBoard[i][j] == color ? 0 : 1;
                }else{
                    currentValue =  chessBoard[i][j] != color ? 0 : 1;
                }

                tmp[i+1][j+1] = tmp[i+1][j] + tmp[i][j+1] - tmp[i][j] + currentValue;
            }
        }
        return tmp;
    }
}