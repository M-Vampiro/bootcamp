import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class DemoArrayDeque {
    public static void main(String[] args) {
        Queue<String> qs = new ArrayDeque<>();

        qs.add("JJJ");
        qs.add("KKK");
        qs.add("XXX");
        qs.poll();
        System.out.println(qs.peek());

        Deque<String> ds = new ArrayDeque<>();

        ds.addFirst("ABC");
        ds.addFirst("DEF");
        ds.addLast("XXX");
        ds.removeLast();
        System.out.println(ds.peekLast());

        

        



        
            
        };







    }

