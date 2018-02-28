package tree;

public class Main
{

   public static void main(String[] args)
   {
      NodeImplementation node6 = new NodeImplementation(14, null, null);
      NodeImplementation node5 = new NodeImplementation(9, null, null);
      NodeImplementation node4 = new NodeImplementation(4, null, null);
      NodeImplementation node3 = new NodeImplementation(1, null, null);
      NodeImplementation node2 = new NodeImplementation(12, node5, node6);
      NodeImplementation node1 = new NodeImplementation(2, node3, node4);
      NodeImplementation node = new NodeImplementation(7, node1, node2);
      node.preorder(node);
      System.out.println("");
      node.inOrder(node);
      System.out.println("");
      node.postOrder(node);
   }

}
