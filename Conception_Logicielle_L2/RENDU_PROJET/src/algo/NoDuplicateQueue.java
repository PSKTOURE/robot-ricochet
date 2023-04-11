package algo;

import java.util.Collection;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.SortedSet;

public class NoDuplicateQueue<E> extends PriorityQueue<E> {
	
	
	
	public NoDuplicateQueue() {
		super();
	}

	public NoDuplicateQueue(Collection<? extends E> arg0) {
		super(arg0);
	}

	public NoDuplicateQueue(Comparator<? super E> comparator) {
		super(comparator);
	}

	public NoDuplicateQueue(int initialCapacity, Comparator<? super E> comparator) {
		super(initialCapacity, comparator);
	}

	public NoDuplicateQueue(int initialCapacity) {
		super(initialCapacity);
	}

	public NoDuplicateQueue(PriorityQueue<? extends E> c) {
		super(c);
	}

	public NoDuplicateQueue(SortedSet<? extends E> c) {
		super(c);
	}
	
	@Override
	public boolean add(E e) {
		boolean isAdded = false;
		if(!super.contains(e)) {
			isAdded = super.add(e);
		}
		return isAdded;
	}

}
