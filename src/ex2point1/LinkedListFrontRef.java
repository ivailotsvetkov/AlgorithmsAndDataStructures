package ex2point1;

public class LinkedListFrontRef<T> implements ListADT<T>
// Adding at the end of the list -> time consuming
// Insert and remove at index 0 are special cases

{
   private LinearNode<T> front;

   private int count;

   public LinkedListFrontRef()
   {
      front = null;
      count = 0;

   }

   private LinearNode<T> getNode(int index)
   {
      LinearNode<T> current = front;
      for (int i = 0; i <= index; i++)
      {
         current = current.getNext();
      }
      return current;
   }

   public String toString()
   {
      String output = "{";
      LinearNode<T> current = front;
      for (int i = 0; i < count; i++)
      {
         output += current.getElement();
         if (i != count - 1)
         {
            output += ", ";
         }
         current = current.getNext();
      }
      output += "}";
      return output;
   }

   @Override
   public void add(int index, T element)
   {
      if (index < 0 || index > count)
      {
         throw new IndexOutOfBoundsException();
      }
      if (index == 0)
      {
         front = new LinearNode<T>(element, front);
      }
      else
      {
         LinearNode<T> previous = getNode(index - 1);
         LinearNode<T> newNode = new LinearNode<T>(element, previous.getNext());
         previous.setNext(newNode);
      }
      count++;

   }

   @Override
   public void add(T element)
   {
      add(count, element);

   }

   @Override
   public void set(int index, T element)
   {
      if (index < 0 || index > count)
      {
         throw new IndexOutOfBoundsException();
      }
      getNode(index).setElement(element);
   }

   @Override
   public T get(int index)
   {
      if (index < 0 || index > count)
      {
         throw new IndexOutOfBoundsException();
      }
      return getNode(index).getElement();
   }

   @Override
   public T remove(int index)
   {
      LinearNode<T> forDelete = null;
      if (index == 0)
      {
         forDelete = front;
         front = front.getNext();
         count--;
      }
      else
      {
         LinearNode<T> previous = front;
         for (int i = 0; i < index - 1; i++)
         {
            previous = previous.getNext();
         }

         forDelete = previous.getNext();
         LinearNode<T> nextNote = forDelete.getNext();
         previous.setNext(nextNote);
         count--;
      }
      return forDelete.getElement();
   }

   @Override
   public T remove(T element)
   {
      return remove(indexOf(element));
   }

   @Override
   public int indexOf(T element)
   {
      LinearNode<T> current = front;
      for (int i = 0; i < count; i++)
      {
         if (element.equals(current.getElement()))
         {
            return i;
         }
         current = current.getNext();
      }
      return -1;
   }

   @Override
   public boolean contains(T element)
   {
      LinearNode<T> current = front;
      for (int i = 0; i < count; i++)
      {
         if (element.equals(current.getElement()))
         {
            return true;
         }
         current = current.getNext();
      }
      return false;
   }

   @Override
   public boolean isEmpty()
   {
      return count == 0;
   }

   @Override
   public int size()
   {
      return count;
   }
}
