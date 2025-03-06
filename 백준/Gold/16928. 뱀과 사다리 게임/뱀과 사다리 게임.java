import java.util.*;
import java.io.*;

public class Main {
	static int N, M, res;
	static int start=1, end=100;
	static boolean[] visited;
	static Map<Integer, Integer> gameThings;	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[101];		
		gameThings = new HashMap<>();
		
		for(int i=0; i<N; i++) {		
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			gameThings.put(x, y);
		}
		
		for(int i=0; i<M; i++) {	
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			gameThings.put(x, y);
		}
		
		bfs();
		bw.write(res + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		visited[start] = true;
		
		while(!q.isEmpty()) {
			res++;
			for(int i=0,qSize=q.size(); i<qSize; i++) {
				int now = q.poll();
				
				for(int j=1; j<=6; j++) {		
					int move = now + j;
					if(move==end) return;
					
					if(move > end) continue;
					if(visited[move]) continue;
					
					visited[move] = true;
					if(gameThings.containsKey(move)) {		
						move = gameThings.get(move);
					}
					q.add(move);
				}
			}
		}
	}
}