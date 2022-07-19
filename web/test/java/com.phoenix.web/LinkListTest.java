package com;

/**
 * @author tianFeng
 * @version 1.0, 2018/08/14
 */

public class LinkListTest {

    private static Node head;

    static class Node {

        private int data;

        private Node next;

        public Node() {
        }

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {

        head = new Node(1);

        head.setNext(new Node(2));



    }

}
