import java.util.*;

 class Main {
     public static void main(String[] args) {
         
         Scanner sc = new Scanner(System.in);
         int a = sc.nextInt();
         int b = sc.nextInt();
         int c = sc.nextInt();
         int d = sc.nextInt();
         int e = sc.nextInt();
         int f = sc.nextInt();
     
         for(int i = -999; i <= 999; i++) { 
             for(int j = -999; j <= 999; j++) {
                 if(a*i + b*j  == c){ // ax + by 가 C이고(x = i, y = j)
                     if(d*i + e*j  == f) { // dx + ey가 f일 때(x = i, y = j)
                         System.out.println(i+" "+j+"\n");
                     }
                 }
             }
         }
     }
 }