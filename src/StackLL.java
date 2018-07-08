
public class StackLL<T> implements Stack<T> {
	LinkedList<T> list;

	public StackLL(){
		list = new LinkedList<T>();
	}
	public void push(T data) {
		list.add(0, data);
		
	}
	public T pop() {
		T data = list.get(0);
		list.delete(0);
		return data;
	}

	public T peek() {
		T data = list.get(0);
		return data;
	}

	public boolean isEmpty() {
		return list.isEmpty();
	
	}
}
