import java.util.Scanner;
 
/* Class SkipNode */
class SkipNode        
{
    int element;
    SkipNode right;
    SkipNode down;
 
    /* Constructor */
    public SkipNode(int x)
    {
        this(x, null, null);
    }
    /* Constructor */
    public SkipNode(int x, SkipNode rt, SkipNode dt)
    {
        element = x;
        right = rt;
        down = dt;
    }
}
 
/* Class SkipList */
class SkipList
{
    private SkipNode header;
    private int infinity;
    private SkipNode bottom = null;
    private SkipNode tail = null;
 
    /* Constructor */
    public SkipList(int inf)
    {
        infinity = inf;
        bottom = new SkipNode(0);
        bottom.right = bottom.down = bottom;
        tail = new SkipNode(infinity);
        tail.right = tail;
        header = new SkipNode(infinity, tail, bottom);
    }
    /* Function to insert element */
    public void insert(int x)
    {
        SkipNode current = header;
        bottom.element = x;
        while (current != bottom)
        {
            while (current.element < x)
            current = current.right;
            /*  If gap size is 3 or at bottom level and must insert, then promote middle element */
            if (current.down.right.right.element < current.element)
            {
                current.right = new SkipNode(current.element, current.right, current.down.right.right);
                current.element = current.down.right.element;
            }
            else
                current = current.down;
        }
        /* Raise height of skiplist if necessary */
        if (header.right != tail)
            header = new SkipNode(infinity, tail, header);
    }
}