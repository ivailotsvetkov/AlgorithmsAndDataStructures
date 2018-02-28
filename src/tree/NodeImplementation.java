package tree;

public class NodeImplementation<T> implements Node<T>
{
   private T value;
   private Node<T> left, right;

   public NodeImplementation(T value, Node<T> left, Node<T> right)
   {
      this.value = value;
      this.left = left;
      this.right = right;
   }

   @Override
   public T getValue()
   {
      return value;
   }

   @Override
   public boolean isLeaf()
   {
      return left == null && right == null;
   }

   @Override
   public Node<T> getLeft()
   {
      // TODO Auto-generated method stub
      return left;
   }

   @Override
   public Node<T> getRight()
   {
      // TODO Auto-generated method stub
      return right;
   }

   public void preorder(Node<T> root)
   {
      if (root != null)
      {

         System.out.printf("%d ", root.getValue());
         preorder(root.getLeft());
         preorder(root.getRight());
      }
   }

   public void inOrder(Node<T> root)
   {
      if (root != null)
      {
         inOrder(root.getLeft());
         System.out.printf("%d ", root.getValue());
         inOrder(root.getRight());
      }
   }

   public void postOrder(Node<T> root)
   {
      if (root != null)
      {
         postOrder(root.getLeft());
         postOrder(root.getRight());
         System.out.printf("%d ", root.getValue());
      }
   }
}
