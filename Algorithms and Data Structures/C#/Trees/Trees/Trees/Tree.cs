using System;
using System.Collections.Generic;

public class Tree<T>
{
    public T Value { get; set; }
    public List<Tree<T>> Children { get; set; }


    public Tree(T value, params Tree<T>[] children)
    {
        Value = value;
        this.Children = new List<Tree<T>>(children);
    }

    public void Print(int indentation = 0)
    {
        Console.WriteLine(new string(' ', indentation) + this.Value);

        foreach (var child in this.Children)
        {
            child.Print(indentation + 2);
        }
    }

    public void Each(Action<T> action)
    {
        action(this.Value);
        foreach (var child in this.Children)
        {
            child.Each(action);
        }
    }

    public IEnumerable<T> OrderDFS()
    {
        var result = new List<T>();
        this.DFS(this, result);
        return result;
    }

    private void DFS(Tree<T> tree, List<T> result)
    {
        foreach (var child in tree.Children)
        {
            this.DFS(child, result);
        }
        result.Add(tree.Value);
    }

    public IEnumerable<T> OrderBFS()
    {
        var result = new List<T>();
        var queue = new Queue<Tree<T>>();
        queue.Enqueue(this);

        while (queue.Count > 0)
        {
            var current = queue.Dequeue();
            foreach (var child in current.Children)
            {
                queue.Enqueue(child);
            }
            result.Add(current.Value);
        }
        return result;
    }
}
