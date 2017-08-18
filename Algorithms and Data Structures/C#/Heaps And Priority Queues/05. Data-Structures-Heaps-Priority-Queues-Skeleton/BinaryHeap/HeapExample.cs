using System;

public class HeapExample
{
    static void Main()
    {
        int[] arr = new int[] { 5, 2, 4, 1, -2, 0 };
        Heap<int>.Sort(arr);
        Console.WriteLine(string.Join(" ",arr));
    }
}
