import java.util.*;
 
public class Main {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		
		int N = in.nextInt();
		
		
		int[][] time = new int[N][2];
		
		
		for(int i = 0; i < N; i++) {
			time[i][0] = in.nextInt();	
			time[i][1] = in.nextInt();	
		}
		
		
		Arrays.sort(time, new Comparator<int[]>() {
			
			@Override
			public int compare(int[] o1, int[] o2) {
				
				if(o1[1] == o2[1]) {
					return o1[0] - o2[0];
				}
				
				return o1[1] - o2[1];
			}
 
		});
		
		int count = 0;
		int prev_end_time = 0;
		
		for(int i = 0; i < N; i++) {
			
			if(prev_end_time <= time[i][0]) {
				prev_end_time = time[i][1];
				count++;
			}
		}
		
		System.out.println(count);
	}
 
}