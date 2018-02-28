package tree;

public interface Node<T>
{
   T getValue();

   boolean isLeaf();

   Node<T> getLeft();

   Node<T> getRight();
   
}
