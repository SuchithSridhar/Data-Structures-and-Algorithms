import java.util.Iterator;

class LinkedList<T> implements Iterable {

    class Node {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private class LinkedListIterator implements Iterator<T> {
        Node current;

        public LinkedListIterator(LinkedList<T> list) {
            current = list.getHeadNode();
        }

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            T data = current.data;
            current = current.next;
            return data;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private int count;
    private Node head;

    public LinkedList() {
        count = 0;
        head = null;
    }

    public boolean contains(T data) {
        Node cur = this.head;
        while (cur.next != null) {
            if (cur.data.equals(data)) return true;
            cur = cur.next;
        }
        return false;
    }

    public T getHead() {
        if (head == null) return null;
        return this.head.data;
    }

    public Node getHeadNode() {
        return this.head;
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public void startIteration() {
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator(this);
    }

    public void insert(T data) {
        Node tmp = new Node(data, this.head);
        this.head = tmp;
        this.count++;
    }

    public void insert(T data, int index) {
        if (index > this.count || index < 0) throw new IndexOutOfBoundsException();

        if (index == 0) {
            this.insert(data);
            return;
        }

        int curIndex = 0;
        Node curNode = head;

        while (curIndex != index - 1) {
            curNode = curNode.next;
            curIndex++;
        }

        Node newNode = new Node(data, curNode.next);
        curNode.next = newNode;
        this.count++;
    }

    public T delete() {
        if (head == null) return null;
        
        T data = this.head.data;
        this.head = this.head.next;
        this.count--;
        return data;
    }

    public T delete(int index) {
        if (index >= this.count || index < 0) throw new IndexOutOfBoundsException(); 

        if (index == 0) {
            return delete();
        }

        int curIndex = 0;
        Node curNode = head;

        while (curIndex != index - 1) {
            curNode = curNode.next;
            curIndex++;
        }

        T deleted = curNode.next.data;
        curNode.next = curNode.next.next;
        this.count--;
        return deleted;
    }

    @Override
    public String toString() {
        String newString = "";
        Iterator iter = iterator();
        boolean first = true;
        while (iter.hasNext()) {
            if (first) {
                newString += "-> " + iter.next();
                first = false;
            } else {
                newString += " -> " + iter.next();
            }
        }
        return newString;
    }

}

