using System;
using System.Collections.Generic;
using System.Threading;

public class BinarySearchTree<T> where T : IComparable<T>
{
    private class Node
    {
        public T Value { get; set; }
        public Node Left { get; set; }
        public Node Right { get; set; }

        public Node(T value)
        {
            this.Value = value;
        }
    }

    private Node root;

    public BinarySearchTree()
    {

    }

    private BinarySearchTree(Node node)
    {
        this.Copy(node);
    }

    private void Copy(Node node)
    {
        if (node == null)
        {
            return;
        }

        this.Insert(node.Value);
        this.Copy(node.Left);
        this.Copy(node.Right);
    }

    public void Insert(T element)
    {
        if (this.root == null)
        {
            this.root = new Node(element); // insert the root
            return;
        }
        Node parent = null;
        Node current = this.root;

        while (current != null)
        {
            parent = current;
            if (current.Value.CompareTo(element) > 0)
            {
                current = current.Left;
            }
            else if (current.Value.CompareTo(element) < 0)
            {
                current = current.Right;
            }
            else
            {
                return;
            }
        }

        current = new Node(element);
        if (parent.Value.CompareTo(element) < 0)
        {
            parent.Right = current;
        }
        else
        {
            parent.Left = current;
        }

    }

    public bool Contains(T element)
    {
        Node current = FindElement(element);
        return current != null;    // returns TRUE/FALSE depends on the current value
    }

    private Node FindElement(T element)
    {
        Node current = this.root;

        while (current != null)
        {

            if (current.Value.CompareTo(element) > 0)
            {
                current = current.Left;       // if element is smaller, we search in left
            }
            else if (current.Value.CompareTo(element) < 0)
            {
                current = current.Right;    // if element is bigger, we search in right
            }
            else
            {
                break;    // if element is equal to current element, we break the cycle
            }
        }

        return current;
    }

    public void DeleteMin()
    {
        Node current = this.root;
        Node parent = null;
        if (this.root == null)
        {
            return;
        }
        while (current.Left != null)
        {
            parent = current;
            current = current.Left;
        }
        if (parent == null)
        {
            this.root = this.root.Right;
        }
        else
        {
            parent.Left = current.Right;
        }
    }

    public BinarySearchTree<T> Search(T item)
    {
        Node current = this.FindElement(item);

        return new BinarySearchTree<T>(current);
    }

    public IEnumerable<T> Range(T startRange, T endRange)
    {
        Queue<T> range = new Queue<T>();

        this.Range(startRange, endRange, range, this.root);

        return range;
    }

    private void Range(T startRange, T endRange, Queue<T> range, Node node)
    {
        if (node == null)
        {
            return;
        }
                        //    4                10
        int compareLow = startRange.CompareTo(node.Value); // -1

                        // 37                    10
        int compareHigh = endRange.CompareTo(node.Value); // +1

        if (compareLow < 0)  // If node.value is bigger than startRange, then we go to the left child
        {
            this.Range(startRange, endRange, range, node.Left);
        }
        if (compareLow <= 0 && compareHigh >= 0)
        {
           range.Enqueue(node.Value); 
        }
        if (compareHigh > 0)  // If node.value is smaller than endRange, then we go to the right child
        {
            this.Range(startRange, endRange, range, node.Right);
        }
}

    public void EachInOrder(Action<T> action)
    {
        this.EachInOrder(this.root, action);
    }

    private void EachInOrder(Node node, Action<T> action)
    {
        if (node == null)
        {
            return;
        }
        this.EachInOrder(node.Left, action);
        action(node.Value);
        this.EachInOrder(node.Right, action);

    }
}

public class Launcher
{
    public static void Main(string[] args)
    {
     
    }
}
