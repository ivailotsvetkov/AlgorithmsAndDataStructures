package ex2point1;


public class LinkedQueue<T> implements QueueADT<T>
{
   private int count;
   private LinearNode<T> rear;
   private LinearNode<T> tail;

   public LinkedQueue()
   {
      count = 0;
      rear = null;
      tail = null;
   }

   public String toString()
   {
      {
         String output = "{";
         LinearNode<T> current = rear;
         for (int i = 0; i < size(); i++)
         {
            output += current.getElement();
            if (i != (size() - 1))
            {
               output += ", ";
            }
            current = current.getNext();
         }
         output += "}";
         return output;
      }
   }

   @Override
   public void enqueue(T element)
   {
      if (count == 0)
      {
         rear = new LinearNode<>(element, null);
         tail = new LinearNode<>(element, null);
      }
      else
      {

         LinearNode<T> newNode = new LinearNode<T>(element, rear);
         rear = new LinearNode<>(element, newNode);
         rear = newNode;
      }
      count++;

   }

   @Override
   public T dequeue()
   {
      LinearNode<T> itemDeleted = tail;
      if (!isEmpty())

         itemDeleted = tail = getNode(count - (count - 1));

      tail = null;
      count--;

      return itemDeleted.getElement();
   }

   @Override
   public T last()
   {
      return tail.getElement();
   }

   public T first()
   {
      return rear.getElement();
   }

   @Override
   public int indexOf(T element)
   {
      for (int i = 0; i < size(); i++)
      {
         if (element.equals(rear))
         {
            return i;
         }

      }
      return -1;
   }

   @Override
   public boolean isEmpty()
   {
      if (count == 0)
      {
         return true;
      }
      else
      {
         return false;
      }
   }

   @Override
   public int size()
   {
      return count;
   }

   private LinearNode<T> getNode(int index)
   {
      LinearNode<T> current = rear;
      for (int i = -1; i < index; i++)
      {
         current = current.getNext();
      }
      return current;
   }
}
