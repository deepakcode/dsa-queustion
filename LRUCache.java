
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache {

    private Deque<Integer> doublyQueue;
    private HashSet<Integer> hashSet;

    private static Integer CACHE_SIZE;

    public LRUCache(int capacity) {
        doublyQueue = new LinkedList<>();
        hashSet = new HashSet<>();
        CACHE_SIZE = capacity;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(4);
        cache.refer(1);
        cache.refer(2);
        cache.refer(3);
        cache.refer(1);
        cache.refer(4);
        cache.refer(5);
        cache.display();
    }

    private void display() {
        for (int page:doublyQueue) {
            System.out.println(" "+page);
        }
    }

    private void refer(int page) {
        if(hashSet.contains(page)){
            doublyQueue.remove(page);
        }else {
            if(doublyQueue.size()==CACHE_SIZE){
                int last = doublyQueue.removeLast();
                hashSet.remove(last);
            }
        }
        doublyQueue.push(page);
        hashSet.add(page);
    }
}
