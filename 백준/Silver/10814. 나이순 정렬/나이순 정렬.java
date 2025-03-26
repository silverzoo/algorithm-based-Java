import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Member> members = new ArrayList<>();
        
        int n = sc.nextInt();
        sc.nextLine();
        
        for(int i = 0; i < n; i++) {
            int age = sc.nextInt();
            String name = sc.next();
            members.add(new Member(age, name, i));
        }
        
        Collections.sort(members, (a,b) -> {
            if(a.age == b.age) return a.order - b.order;
            return a.age - b.age;
        });
        
        for(Member m : members) {
            System.out.println(m);
        }
        
    }
}

class Member {
    int age;
    String name;
    int order;

    public Member(int age, String name, int order) {
        this.age = age;
        this.name = name;
        this.order = order;
    }

    public String toString() {
        return age + " " + name;
    }
}