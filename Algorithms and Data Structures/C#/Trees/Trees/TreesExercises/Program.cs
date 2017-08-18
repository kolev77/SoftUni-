using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace TreesExercises
{
    class Program
    {
        private static Dictionary<int, Tree<int>> nodes = new Dictionary<int, Tree<int>>();

        static void Main(string[] args)
        {
            ReadTree();
            Tree<int> root = GetRootNode();
            //Console.WriteLine("Root node: "+root.Value);
            //root.Print();
            //Console.WriteLine("Deepest node: " + GetDeepestNode(root).Value);
            // Console.WriteLine(string.Join(" ",GetSubTreeWithSum(root).Select(x => x.Value)));
            foreach (var node in GetSubTreeWithSum(root))
            {
                PrintPreOrder(node);
                Console.WriteLine();
            }
        }

        private static void PrintPreOrder(Tree<int> node)
        {
            Console.Write(node.Value + " ");
            foreach (var child in node.Children)
            {
               PrintPreOrder(child);
            }
        }

        private static void PrintPath(Tree<int> leaf)
        {
            var stack = new Stack<int>();
            var current = leaf;
            while (current != null)
            {
                stack.Push(current.Value);
                current = current.Parent;
            }
            Console.WriteLine(string.Join(" ", stack));
        }


        private static void ReadTree()
        {
            int nodes_count = int.Parse(Console.ReadLine());
            for (int i = 0; i < nodes_count - 1; i++)
            {
                int[] edge = Console.ReadLine()
                    .Split(' ')
                    .Select(int.Parse)
                    .ToArray();
                Tree<int> parent = GetNode(edge[0]);
                Tree<int> child = GetNode(edge[1]);
                parent.Children.Add(child);
                child.Parent = parent;
            }
        }

        private static Tree<int> GetRootNode()
        {
            return nodes.Values.Where(x => x.Parent == null).FirstOrDefault();
        }

        private static Tree<int> GetNode(int value)
        {
            if (!nodes.ContainsKey(value))
            {
                nodes[value] = new Tree<int>(value);
            }
            return nodes[value];
        }

        //private static Tree<int> GetDeepestNode(Tree<int> root)
        //{
        //    int maxLevel = 0;
        //    Tree<int> deepest = null;
        //    DFS(root, 1, ref maxLevel, ref deepest);
        //    return deepest;
        //}

        private static List<Tree<int>> GetSubTreeWithSum(Tree<int> root)
        {
            int target = int.Parse(Console.ReadLine());
            Console.WriteLine("Subtrees of sum {0}:", target);
            List<Tree<int>> roots = new List<Tree<int>>();

            var sum = DFS(root, target, 0, roots);

            return roots;
        }

        public static int DFS(Tree<int> node, int target, int current, List<Tree<int>> roots)
        {
            if (node == null)
            {
                return 0;
            }

            current = node.Value;

            foreach (var child in node.Children)
            {
                current +=  DFS(child, target, current, roots);
            }
            // this If statement will execute after recursion
            if (current == target)
            {
                roots.Add(node);
            }

            return current;
        }
    }
}
