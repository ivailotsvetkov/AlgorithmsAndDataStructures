package ex2point1;

public class LinearNode<T>
{
   private LinearNode<T> next;
   private T element;

   public LinearNode(T element, LinearNode<T> next)
   {
      this.next = next;
      this.element = element;
   }

   public LinearNode(T element)
   {
      this.next = null;
      this.element = element;
   }

   public LinearNode()
   {
      next = null;
      element = null;
   }

   public LinearNode<T> getNext()
   {
      return next;
   }

   public void setNext(LinearNode<T> node)
   {
      next = node;
   }

   public T getElement()
   {
      return element;
   }

   public void setElement(T elem)
   {
      element = elem;
   }
}
