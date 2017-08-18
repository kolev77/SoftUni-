using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace LinkedStack
{
    class Launcher
    {
        public static void Main(string[] args)
        {
            LinkedStack<int> stack = new LinkedStack<int>();

            stack.Push(5);
            stack.Push(8);
            stack.Push(12);
            stack.Push(4);

            Console.WriteLine(string.Join(", ", stack.ToArray()));

        }
    }
}
