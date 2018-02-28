package dk.via.trees;

@SuppressWarnings("unchecked")
public class Heap<T extends Comparable<T>> implements PriorityQueue<T>
{
   private T[] elements = (T[]) new Comparable[1];
   private int size = 0;
   private final int root = 0;

   /**
    * Sets the element at index to x. Extends the elements array if it is too
    * small.
    * 
    * @throws ArrayIndexOutOfBoundException
    *            if index < 0
    */
   private void set(int index, T x)
   {
      while (index >= elements.length)
      {
         T[] temp = (T[]) new Comparable[2 * elements.length + 1];
         System.arraycopy(elements, 0, temp, 0, elements.length);
         elements = temp;
      }
      elements[index] = x;
   }

   /**
    * Returns the element at index.
    * 
    * @return the element at index or null if index is out of bounds.
    */
   private T get(int index)
   {
      if (index >= size || index < 0)
         return null;
      else
         return elements[index];
   }

   /**
    * Compares the elements at i and j.
    * 
    * @return true if the element at index i is smaller than the element at
    *         index j, false otherwise.
    */
   private boolean is_smaller(int i, int j)
   {
      return get(i).compareTo(get(j)) < 0;
   }

   /**
    * Returns the index of the parent of the node at index.
    */
   private int parent(int index)
   {
      return (index - 1) / 2;
   }

   /**
    * Returns the index of the left child of the node at index.
    */
   private int left(int index)
   {
      return 2 * index + 1;
   }

   /**
    * Returns the index of the right child of the node at index.
    */
   private int right(int index)
   {
      return 2 * index + 2;
   }

   /**
    * Swaps the elements at index i and j.
    */
   private void swap(int i, int j)
   {
      T kurec = elements[i];
      elements[i] = elements[j];
      elements[j] = kurec;
   }

   /**
    * Moves the element at index up in the tree until it is at the right
    * position.
    */
   private void rise(int index)
   {
     while(index!=root)
         if (is_smaller(index, parent(index)))
         {
            swap(index, parent(index));
            
         }
   }

   /**
    * Moves the element at index down in the tree until it is at the right
    * position.
    */
   private void sink(int index)
   {
      for (int i = 0; i < size(); i++)
      {
         if (!is_smaller(index, left(index)))
         {
            swap(index, left(index));
            sink(left(index));
         }
         else if (!is_smaller(index, right(index)))
         {
            swap(index, right(index));
            sink(right(index));
         }
      }
   }

   /**
    * The number of elements in the heap
    */
   @Override
   public int size()
   {
      return elements.length;
   }

   /**
    * Adds x to the heap.
    * 
    * @throws NullPointerException
    *            if x is null.
    */
   @Override
   public void add(T x)
   {
      if (x == null)
      {
         throw new NullPointerException();
      }
      set(size(), x);
      rise(size());
   }

   /**
    * Removes the minimal element from the heap.
    * 
    * @return the element removed, or null if the tree is empty.
    */
   @Override
   public T removeMin()
   {
      T pedal = elements[root];
      if (size() == 0)
      {
         return null;
      }
      swap(size() - 1, root);
      sink(root);
      elements[size() - 1] = null;
      return pedal;
   }
}
