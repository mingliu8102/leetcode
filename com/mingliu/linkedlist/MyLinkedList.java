class MyLinkedList {
    public static void main(String[] args) {
        String str1 =
                "\"MyLinkedList\",\"addAtHead\",\"addAtTail\",\"addAtTail\",\"get\",\"get\",\"addAtTail\",\"addAtIndex\",\"addAtHead\",\"addAtHead\",\"addAtTail\",\"addAtTail\",\"addAtTail\",\"addAtTail\",\"get\",\"addAtHead\",\"addAtHead\",\"addAtIndex\",\"addAtIndex\",\"addAtHead\",\"addAtTail\",\"deleteAtIndex\",\"addAtHead\",\"addAtHead\",\"addAtIndex\",\"addAtTail\",\"get\",\"addAtIndex\",\"addAtTail\",\"addAtHead\",\"addAtHead\",\"addAtIndex\",\"addAtTail\",\"addAtHead\",\"addAtHead\",\"get\",\"deleteAtIndex\",\"addAtTail\",\"addAtTail\",\"addAtHead\",\"addAtTail\",\"get\",\"deleteAtIndex\",\"addAtTail\",\"addAtHead\",\"addAtTail\",\"deleteAtIndex\",\"addAtTail\",\"deleteAtIndex\",\"addAtIndex\",\"deleteAtIndex\",\"addAtTail\",\"addAtHead\",\"addAtIndex\",\"addAtHead\",\"addAtHead\",\"get\",\"addAtHead\",\"get\",\"addAtHead\",\"deleteAtIndex\",\"get\",\"addAtHead\",\"addAtTail\",\"get\",\"addAtHead\",\"get\",\"addAtTail\",\"get\",\"addAtTail\",\"addAtHead\",\"addAtIndex\",\"addAtIndex\",\"addAtHead\",\"addAtHead\",\"deleteAtIndex\",\"get\",\"addAtHead\",\"addAtIndex\",\"addAtTail\",\"get\",\"addAtIndex\",\"get\",\"addAtIndex\",\"get\",\"addAtIndex\",\"addAtIndex\",\"addAtHead\",\"addAtHead\",\"addAtTail\",\"addAtIndex\",\"get\",\"addAtHead\",\"addAtTail\",\"addAtTail\",\"addAtHead\",\"get\",\"addAtTail\",\"addAtHead\",\"addAtTail\",\"get\",\"addAtIndex\"";
        String[] arr1 = str1.split(",");
        
        String str2 = "[],[84],[2],[39],[3],[1],[42],[1,80],[14],[1],[53],[98],[19],[12],[2],[16],[33],[4,17],[6,8],[37],[43],[11],[80],[31],[13,23],[17],[4],[10,0],[21],[73],[22],[24,37],[14],[97],[8],[6],[17],[50],[28],[76],[79],[18],[30],[5],[9],[83],[3],[40],[26],[20,90],[30],[40],[56],[15,23],[51],[21],[26],[83],[30],[12],[8],[4],[20],[45],[10],[56],[18],[33],[2],[70],[57],[31,24],[16,92],[40],[23],[26],[1],[92],[3,78],[42],[18],[39,9],[13],[33,17],[51],[18,95],[18,33],[80],[21],[7],[17,46],[33],[60],[26],[4],[9],[45],[38],[95],[78],[54],[42,86]";
        String[] arr2 = str2.split("],");
        System.out.println(arr1);
        System.out.println(arr2);
    }

    private class Node {
        int val;
        Node next;
//        Node pre;

        public Node(int val) {
            this.val = val;
        }
    }

    Node first;
    Node last;
    int size;

    public MyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size) return -1;
        Node tmp = first;
        for (int i = 0; i < index; i++) {
            tmp = tmp.next;
        }
        return tmp.val;
    }

    public void addAtHead(int val) {
        Node oldfirst = first;
        first = new Node(val);
        if (last == null) {
            last = first;
        } else {
            first.next = oldfirst;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node oldLast = last;
        last = new Node(val);
        if (first == null) {
            first = last;
        } else {
            oldLast.next = last;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index == size) {
            addAtTail(val);
        } else if (index > size) {
            return;
        } else if (index <= 0) {
            addAtHead(val);
        } else {
            Node tmp = first;
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.next;
            }
            Node next = tmp.next;
            Node insert = new Node(val);
            tmp.next = insert;
            insert.next = next;
            size++;
        }
    }

    public void deleteAtIndex(int index) {

        if (index < 0) {
            return;
        } else if (index >= size) {
            return;
        } else if (index == 0) {

            first = first.next;
            size--;
            if (size == 0) {
                last = null;
            }
        } else {
            Node tmp = first;
            for (int i = 0; i < index - 1; i++) {
                tmp = tmp.next;
            }

            tmp.next = tmp.next.next;
            size--;
        }
    }
}

