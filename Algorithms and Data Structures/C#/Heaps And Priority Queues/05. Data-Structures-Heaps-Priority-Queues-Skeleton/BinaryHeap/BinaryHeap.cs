using System;
using System.CodeDom.Compiler;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;

public class BinaryHeap<T> where T : IComparable<T>
{
    private List<T> heap;

    public BinaryHeap()
    {
        this.heap = new List<T>();
    }

    public int Count
    {
        get { return this.heap.Count; }
    }

    public void Insert(T item) // max heap
    {
        this.heap.Add(item); // add item to the end
        this.HeapifyUp(this.heap.Count - 1); // heapify up the last added element
    }

    private void HeapifyUp(int index)
    {
        int parent = (index - 1) / 2;

        while (IsGreater(index, parent))
        {
            Swap(index, parent);
            index = parent;
            parent = (index - 1) / 2;
        }
    }

    private void Swap(int a, int b)
    {
        T current = this.heap[a];
        this.heap[a] = this.heap[b]; // We change the positions of parent and child, because child is bigger
        this.heap[b] = current;
    }

    private bool IsGreater(int i, int parent)
    {
        return this.heap[i].CompareTo(this.heap[parent]) > 0;
    }

    public T Peek()
    {
        if (this.Count <= 0)
        {
            throw new InvalidOperationException();
        }
        return this.heap[0];
    }

    public T Pull()
    {
        if (this.Count <= 0)
        {
            throw new InvalidEnumArgumentException();
        }

        T result = this.heap[0];  // take the biggest element
        Swap(0, this.Count - 1);  // swap it with  last element

        this.HeapifyDown(0); // heapify down the NEW first element 
        this.heap.RemoveAt(this.Count - 1);

        return result;

    }

private void HeapifyDown(int index)
    {
        while (index < this.Count / 2)  
        {
            int child = 2 * index + 1;   // gets the left child

            // check if right child exists and if it`s 
            // greater than the left one
            if (child + 1 < this.Count && IsGreater(child+1,child))
            {
                child++; // Gets the right child, if it`s  the bigger one.
            }

            if (IsGreater(index,child))
            {
                break; // If the current value is bigger than the child`s, 
                        // then we break the cycle and don`t swap again
            }

            Swap(child,index);  // if` the child`s value is bigger, then we swap them
            index = child;  // Index gets child`s index and the while cycle will countinue
        }
    }
}
