package BinaryTree;
//Задание №6
//Дано двоичное дерево. Проверьте, является ли двоичное дерево деревом бинарного поиска или нет
class Node

{ int data;

    Node left, right;

    public Node(int item)

    {
        data = item;

        left = right = null;

    }

}
public class BinaryTree

{
    Node root;

    boolean isBST()  {

        return isBSTUtil(root, Integer.MIN_VALUE,

                Integer.MAX_VALUE);

    }


    boolean isBSTUtil(Node node, int min, int max)

    {

        if (node == null)

            return true;



        if (node.data < min || node.data > max)

            return false;


        return (isBSTUtil(node.left, min, node.data-1) &&

                isBSTUtil(node.right, node.data+1, max));

    }


    public static void main(String args[])

    {

        BinaryTree tree = new BinaryTree();

        tree.root = new Node(11);

        tree.root.left = new Node(9);

        tree.root.right = new Node(12);

        tree.root.left.left = new Node(8);

        tree.root.left.right = new Node(10);



        if (tree.isBST())

            System.out.println("Это дерево бинарного поиска");

        else

            System.out.println("Это НЕ дерево бинарного поиска");

    }

}