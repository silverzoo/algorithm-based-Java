import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int N = scanner.nextInt();
        for(int i = 0; i < N; i++) {
            int n = scanner.nextInt();
            switch (n) {
                case 1:
                    stack.push(scanner.nextInt()); 
                    break;
                case 2:
                    sb.append((stack.isEmpty()?-1:stack.pop())+"\n"); 
                    break;
                case 3:
                    sb.append(stack.size()+"\n"); 
                    break;
                case 4:
                    sb.append((stack.isEmpty()?1:0)+"\n"); 
                    break;
                case 5:
                    sb.append((stack.isEmpty()?-1:stack.peek())+"\n");
            }
        }
        System.out.println(sb.toString());
    }

}