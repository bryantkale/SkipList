import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

// Used https://en.wikipedia.org/wiki/Skip_list as reference
// Used https://dl.acm.org/citation.cfm?doid=78973.78977 for reference
// Worked with Rachel Swoap


//Skip Node Class
public class SkipList {

//Node Class
private class Node {

    private int item;
    private Node[] next;

    public Node(int value, int level) {
        this.item = value;
        next = new SkipList.Node[level+1];
    }

    public int level(){

        return next.length-1;
    }
}

private  Node head;
private int size;

//Constructor for SkipList
public SkipList() {
    head = new Node(0, 0);
    size = 0;
}

//Adds a key value pair to the skiplist
//If the key already exists, then we want to replace it with a new value.
public void add(int item) {
    int maxLevel = head.level();

    Node current = head;

    Node[] nodePath = new SkipList.Node[maxLevel + 1];

    for (int level = maxLevel; level >= 0; level--) {
        while (current.next[level] != null && item > current.next[level].item) {
            current = current.next[level];
        }

        nodePath[level] = current;
    }
}

//Search for a key. If the key is not found, then print the value our to stdout
private int search(Node t) {
    Node t = top; //our starting place
    boolean located = false;
    while (! located) //run this loop until we locate t
    {
        node = node.down; //move onto next node
    }
    return node.elem; //node is found, so we return the value
}

//Deletes a key value pair. This won't print anything
private int delete(Node t){
    Node cur = search(t); //finds key of t
    if (cur.elem != t){
      return 0; //element was not there
    }
    while (cur != null){
      cur.down.right = cur.right; //reassigns node fields
      cur.right.down = cur.down;
      cur.top = cur; //moves onto the next node

    }
    return 0;
  } //end delete function


private static final Scanner scanner = new Scanner(System.in);

// Not sure if this the correct input for the main function
public static void main(String[] args) {
    int n = scanner.nextInt();

    for (int nItr = 0; nItr < n; nItr++) {
        String[] opContact = scanner.nextLine().split(" ");

        String op = opContact[0];

        String contact = opContact[1];
    }

    scanner.close();
}
}
