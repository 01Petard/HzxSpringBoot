package com.hzx.leetcode.util;

class Node<T> {
    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class MyLinkedList<T> {
    private Node<T> head;

    public MyLinkedList() {
        this.head = null;
    }

    // 头插法
    public void addFirst(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.next = head;
        head = newNode;
    }

    // 尾插法
    public void addLast(T data) {
        Node<T> newNode = new Node<>(data);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // 删除元素
    public void delete(T data) {
        if (head == null) {
            return;
        }
        if (head.data.equals(data)) {
            head = head.next;
            return;
        }
        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(data)) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // 修改元素
    public void update(T oldData, T newData) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(oldData)) {
                current.data = newData;
                return;
            }
            current = current.next;
        }
    }

    // 查询元素
    public boolean contains(T data) {
        Node<T> current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // 打印输出链表
    public void print() {
        Node<T> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.print(); // 输出: 3 2 1

        list.addLast(4);
        list.print(); // 输出: 3 2 1 4

        list.delete(2);
        list.print(); // 输出: 3 1 4

        list.update(1, 5);
        list.print(); // 输出: 3 5 4

        System.out.println("Contains 3? " + list.contains(3)); // 输出: Contains 3? true
        System.out.println("Contains 6? " + list.contains(6)); // 输出: Contains 6? false
    }
}
