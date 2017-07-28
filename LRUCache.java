package Interview;
import java.util.HashMap;
class DLinkedList{
    public int key;
    public int value;
    public int freq;
    public DLinkedList pre;
    public DLinkedList next;
    public DLinkedList(int key,int value,int freq){
        this.key = key;
        this.value = value;
        this.freq = freq;
    }
}
public class LRUCache {

	public static void main(String[] args){
		LRUCache obj = new LRUCache(2);
		obj.put(3,1);
		obj.put(2,1);
		obj.put(2,2);
		obj.put(4,4);
		int param_1 = obj.get(2);
	}
	
    private static HashMap<Integer,DLinkedList> map;
    private static DLinkedList head;
    private static DLinkedList tail;
    private static int capacity;
    private static int count;
    
    private static void addNode(DLinkedList node){
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        node.pre = head;
    }

    private static void removeNode(DLinkedList node){
        node.next.pre = node.pre;
        node.pre.next = node.next;
    }
    
    private static DLinkedList selectLeastUsedNode(){
        DLinkedList tmp = tail.pre;
        DLinkedList result = tmp;
        int min_freq = tmp.freq;
        while(tmp!=head){
            if(tmp.freq<min_freq){
                min_freq = tmp.freq;
                result = tmp;
            }
            tmp = tmp.pre;
        }
        return result;
    }
    
    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = new DLinkedList(-1,-1,-1);
        tail = new DLinkedList(-1,-1,-1);
        head.pre=null;
        head.next = tail;
        tail.pre = head;
        tail.next = null;
        this.capacity = capacity;
        this.count = 0;
    }
    
    public static int get(int key) {
        if(map.containsKey(key)){
            map.get(key).freq++;
            return map.get(key).value;
        }else{
            return -1;
        }
    }
    
    public static void put(int key, int value) {
        if(capacity==0){
            return;
        }
        if(count>=capacity){
            DLinkedList tmpNode = selectLeastUsedNode();
            removeNode(tmpNode);
            map.remove(tmpNode.key);
            count--;
        }
        if(map.containsKey(key)){
            DLinkedList tmpNode = map.get(key);
            tmpNode.value = value;
            tmpNode.freq++;
            removeNode(tmpNode);
            addNode(tmpNode);
        }else{
            DLinkedList tmpNode = new DLinkedList(key,value,1);
            addNode(tmpNode);
            map.put(key,tmpNode);
        }
        count++;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */