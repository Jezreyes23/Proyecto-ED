package clases;
public class ColaSimple {
    private Node front, rear;
    private class Node {
        String data;
        Node next;
        Node(String data) {
            this.data = data;
            this.next = null;
        }
    }
    public ColaSimple() {
        this.front = this.rear = null;
    }
    public void push(String item) {
        Node newNode = new Node(item);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }
    public String pull() {
        if (front == null) {
            return null;
        }
        String item = front.data;
        front = front.next;
        if (front == null) {
            rear = null;
        }
        return item;
    }
    public boolean isEmpty() {
        return front == null;
    }
}
