import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        Operations op = new Operations();
        op.addNode(1);
        op.addNode(2);
        op.addNode(3);
        op.addNode(4);
        op.addNode(5);
        //op.addElementsAtPosition(14,0);
        //op.find_middle_term();
        //op.remove_duplicates_from_sortedList();
        //op.delete_element_at_position(0);
        //op.printAndCountElements();
        //Node llist = op.reverse(op.head);
        //op.printSinglyLinkedList(llist," ");
        //op.delete_from_last_occurence();
        //op.printAndCountElements();
        //boolean isPalindrome = op.isPalindrome(op.head);
        // System.out.println(isPalindrome);
        Node llist = op.rotateList(op.head, 2);
        op.printSinglyLinkedList(llist, " ");

    }
}
