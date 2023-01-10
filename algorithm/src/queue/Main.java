package queue;

import java.util.Scanner;

/**
 * @author: MaoYanDong
 * @create: 2023-01-04 10:52
 * @Version 1.0
 * @description: 主测试程序
 */
public class Main {
    public static void main(String[] args) {
        // 创建长度为5的循环队列，但是会有1个不存储元素，实际只能存4个元素
        CircularQueue circularQueue = new CircularQueue(5);
        Scanner scanner = new Scanner(System.in);
        System.out.println("====请输入操作，出队输入：'-'，入队输入：'+元素'====");
        while (scanner.hasNext()) {
            String input = scanner.nextLine();
            char[] chars = input.toCharArray();
            char operation = chars[0];
            char enqueue = '+';
            char dequeue = '-';
            if (dequeue == operation) {
                System.out.println(circularQueue.dequeue());
            } else if (enqueue == operation) {
                String item = input.substring(1);
                System.out.println(circularQueue.enqueue(item));
            }
        }
    }
}
