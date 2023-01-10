package queue;

/**
 * @author: MaoYanDong
 * @create: 2023-01-04 10:51
 * @Version 1.0
 * @description: 循环队列
 */
public class CircularQueue {
    /**
     * 数组元素
     */
    private String [] items;
    /**
     * 数组大小
     */
    private int n = 0;
    /**
     * 头节点位置
     */
    private int head = 0;
    /**
     * 尾节点位置
     */
    private int tail = 0;

    /**
     * 指定初始容量构造方法
     * @param capacity 初始容量
     */
    public CircularQueue(int capacity) {
        this.n = capacity;
        this.items = new String[capacity];
    }

    /**
     * 入队
     * @param item 入队元素
     * @return
     */
    public boolean enqueue(String item) {
        // 判断是否队满
        if ((tail + 1) % n == head) {
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    /**
     * 出队
     * @return 出队的元素
     */
    public String dequeue() {
        // 判断是否队空
        if (head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }
}
