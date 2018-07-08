/**
 * 
 * @author LN
 *
 * @param <T>
 */
public class QueueLL<T> implements Queue<T> {
	private LinkedList<T> list;
	/**
	 * Constructor
	 */
	public QueueLL(){
		list = new LinkedList<T>();
	}
	
	/**
	 * Check if the list is empty
	 */

	public boolean isEmpty() {
		return list.isEmpty();
	}
/**
 * peek at the first element of the queue
 */
	public T peek() {
		T data = list.get(0);
		return data;
	}
/**
 * pop the first element of the queue
 */
	public T dequeue() {
		T data = list.get(0);
		list.delete(0);
		return data;
	}
/**
 * add to the last of the queue
 */
	public void enqueue(T data) {
		list.add(list.size(), data);
	}
/**
 * calculate the size of queue
 * @return size int
 */
	public int size() {
		return list.size();
		
	}

}