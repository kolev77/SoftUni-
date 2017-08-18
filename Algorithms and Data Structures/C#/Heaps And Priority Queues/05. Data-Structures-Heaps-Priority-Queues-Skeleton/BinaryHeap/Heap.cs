using System;

public static class Heap<T> where T : IComparable<T>
{
    public static void Sort(T[] arr)
    {
        for (int i = arr.Length / 2; i >= 0; i--)
        {
            HeapifyDown(arr, i, arr.Length);
        }

        for (int i = arr.Length - 1; i > 0; i--)
        {
            Swap(arr, 0, i);
            HeapifyDown(arr, 0, i);
        }

    }

    private static void HeapifyDown(T[] arr, int index, int length)
    {
        while (index < length/2)
        {
            int child = 2 * index + 1; // gets the left child

            // check if right child exists and if it`s 
            // greater than the left one
            if (child + 1 < length && IsGreater(arr, child + 1, child))
            {
                child++; // Gets the right child, if it`s  the bigger one.
            }

            if (IsGreater(arr, index, child))
            {
                break; // If the current value is bigger than the child`s, 
                // then we break the cycle and don`t swap again
            }

            Swap(arr, child, index); // if` the child`s value is bigger, then we swap them
            index = child; // Index gets child`s index and the while cycle will countinue
        }
    }

    private static void Swap(T[] arr, int a, int b)
    {
        T current = arr[a];
        arr[a] = arr[b]; // We change the positions of parent and child, because child is bigger
        arr[b] = current;
    }

    private static bool IsGreater(T[] arr, int a, int b)
    {
        return arr[a].CompareTo(arr[b]) > 0;
    }
}
 