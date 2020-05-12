import java.io.IOException;
import java.util.Stack;

public class Operations<T> {

    Node<T> head;

    /*Add a node at the end of the linkedlist*/
    public void addNode(T data) {
        Node<T> newnode = new Node<>(data);
        if (head == null) {
            head = new Node<>(data);
        } else {
            Node<T> curr = head;

            while (curr.getNext() != null) {
                curr = curr.next;
            }
            curr.setNext(new Node<>(data));

        }
    }

    /*Print and count nodes*/
    public void printAndCountElements() {
        if (head == null) {
            System.out.println("No elements present in the linkedlist");
        } else {
            Node<T> curr = head;
            int count = 0;
            //we are using curr and not curr.getNext() because we want to traverse the whole list to get all elements and not just leave the last element without printing
            while (curr != null) {
                System.out.println("Elements are : " + curr.data);
                curr = curr.next;
                count++;

            }
            System.out.println("No of elements is : " + count);
        }
    }

    /*Add nodes at a given position*/
    public void addElementsAtPosition(T data, int position) {
        Node<T> curr = head;
        Node<T> newNode = new Node<>(data);
        if (position == 0) {
            head = newNode;
            //head.setNext(curr); //alternate
            newNode.next = curr;
        } else {
            for (int i = 0; i < position - 1; i++) {
                curr = curr.next;
            }
            newNode.next = curr.next;
            curr.next = newNode;
        }


    }

    /*Finding the middle term - more efficient,complexity-wise*/
    public void find_middle_term() {
        Node<T> slow_ptr = head;
        Node<T> fast_ptr = head;

        while (fast_ptr != null && fast_ptr.getNext() != null) {
            fast_ptr = fast_ptr.next.next;
            slow_ptr = slow_ptr.next;
        }
        System.out.println("The middle term is = " + slow_ptr.data);
    }

    /*remove duplicates from a sorted linked list*/
    public void remove_duplicates_from_sortedList() {
        Node<T> curr = head;
        while (curr.getNext() != null) {
            if (curr.data == curr.next.data) {
                Node<T> temp = curr.next.next;
                curr.next = temp;
            } else {
                curr = curr.next;
            }
        }
    }

    /*delete a node from the given position*/
    public Node delete_element_at_position(int position) {
        if (head == null) {
            return null;
        } else if (position == 0) {
            Node<T> curr = head;
            head = curr.next;
            return curr;
        } else {
            Node<T> curr = head;
            for (int i = 0; i < position - 1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
            return curr;
        }
    }

    /*Reverse a linked list recursively*/
    public Node reverse(Node curr) {
        if (curr == null) {
            return null;
        } else if (curr.next == null) {
            return curr;
        } else {
            Node<T> nextNode = curr.next;
            curr.next = null;
            Node<T> rest = reverse(nextNode);
            nextNode.next = curr;
            return rest;
        }
    }

    public static void printSinglyLinkedList(Node node,
                                             String sep) throws IOException {
        while (node != null) {
            System.out.print(String.valueOf(node.data) + sep);
            node = node.next;
        }
    }

    /*delete from last occurence*/
    public void delete_from_last_occurence() {
        Node<T> curr = head;
        while (curr.getNext() != null) {
            if (curr.next.next == null) {
                curr.next = null;
            } else {
                curr = curr.next;
            }
        }

    }


    /* Todo Recursively check if palindrome */
    /*Check isPalindrome using stack O(n)*/
    public boolean isPalindrome(Node head) {
        Stack<Integer> stack = new Stack<Integer>();
        Node curr = head;
        boolean isPal = true;
        while (curr != null) {
            stack.push((Integer) curr.data);
            curr = curr.next;

        }
        while (head != null) {
            Integer i = stack.pop();
            if (head.data == i) {
                isPal = true;
            } else {
                isPal = false;
                break;
            }
            head = head.next;
        }
        return isPal;
    }

    /*Rotate a list after its specified position*/
    public Node rotateList(Node head, int pos) {
        Node<T> curr = head;

        //Node<T> curr1 = head;

        for (int i = 0; i <= pos - 1; i++) {
            curr = curr.next;

        }
        Node<T> newhead = curr.next;
        curr.next = null;
        Node<T> curr1 = newhead;
        while (curr1.next != null) {
            curr1 = curr1.next;
        }
        curr1.next = head;
        return newhead;
    }

}



