using System;
using System.Xml;

public class BinaryTree<T>
{
    public T Value { get; set; }
    public BinaryTree<T> Left { get; set; }
    public BinaryTree<T> Right { get; set; }
     
    public BinaryTree(T value, BinaryTree<T> leftChild = null, BinaryTree<T> rightChild = null)
    {
        this.Value = value;
        this.Left = leftChild;
        this.Right = rightChild;
    }

    public void PrintIndentedPreOrder(int indent = 0)
    {
        Console.WriteLine(new string(' ', indent) + this.Value);

        if (this.Left != null)
        {
            this.Left.PrintIndentedPreOrder(indent + 2);
        }
        if (this.Right != null)
        {
            this.Right.PrintIndentedPreOrder(indent + 2);
        }
    }

    public void EachInOrder(Action<T> action)
    {
        this.EachInOrder(this, action);

    }


    public void EachPostOrder(Action<T> action)
    {
        this.EachPostOrder(this, action);
    }


    private void EachInOrder(BinaryTree<T> current, Action<T> action)
    {
        if (current == null)
        {
            return;
        }
        EachInOrder(current.Left, action);
        action(current.Value);
        EachInOrder(current.Right, action);


    }

    private void EachPostOrder(BinaryTree<T> current, Action<T> action)
    {
        if (current == null)
        {
            return;
        }
        EachPostOrder(current.Left, action);
        EachPostOrder(current.Right, action);
        action(current.Value);
    }
}
