package ex2point1;



public class QueueWithLinkedList<T> implements QueueADT<T>
{
   private LinkedListFrontRef<T> elements;
   private int count;

   @Override
   public void enqueue(T element)
   {
      elements.add(element);
      count++;
   }

   @Override
   public T dequeue()
   {

      return elements.remove(count);
   }

   @Override
   public T first()
   {
      return elements.get(count);
   }

   @Override
   public int indexOf(T element)
   {
      for (int i = 0; i < size(); i++)
      {
         if (element.equals(count))
         {
            return i;
         }

      }
      return -1;
   }

   @Override
   public boolean isEmpty()
   {
      return count == 0;
   }

   @Override
   public int size()
   {
      return elements.size();
   }

   @Override
   public T last()
   {
      // TODO Auto-generated method stub
      return null;
   }

   public String toString()
   {
      
         return elements.toString();
      
   }
}
