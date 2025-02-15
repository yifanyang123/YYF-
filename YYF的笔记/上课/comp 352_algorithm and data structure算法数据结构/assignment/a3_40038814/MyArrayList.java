package assignment3;

public class MyArrayList<E> {
	private Object a[];
	private int last;
	
	public MyArrayList() {
		a= new Object[2];
		last =-1;
	}
	

	public E get(int i) {
		if (i> a.length) return null;
		return (E) a[i];
	}
	
	public E set(int i, E e){
		if (i> last) {
			return null;
		}
		E temp = (E) a[i];
		a[i] = e;
		return temp;
	}
	
	public void resize(int i) {
		Object temp[] = a;
		int len = a.length;
		if (i>0) {
			a = new Object[(len+len)];
		}
		else {
			len =len/2;
			if (len<2) {
				a = new Object[2];
			}
			else{
				a = new Object[len];
			}
			
		}
		for (int j=0; j<=last;j++) {
			a[j] = temp[j];
		}
		 return;
		
	}
	
	
	public boolean add(E e) {
		
		if (last== a.length-1) resize(1);
		last++;
		a[last] = e;
		return true;
	}

	
	public void add(int index, E element) {
		
		if (index>last) return;
		
		if (last== a.length-1) resize(1);
		last++;
		for (int i= last; i>=index; i--) {
			a[i] = a[i-1];
		}
		a[index] = element;
		return;
		
	}

	
	public void clear() {
		last = -1;
		a = new Object[2];
	}
	
	public boolean remove(Object o) {
		int i = 0;
		while( i<=last && !o.equals(a[i])) {
			i++;
		}
		if (i>last) return false;
		last--;
		for (; i<=last; i++) {
			a[i] = a[i+1];
		}
		if (last+1== a.length/2) resize(-1);
		return true;
	}

	
	public E remove(int index) {
		if (index>last|| index<0) 
			return null;
		Object hold = a[index];
		last--;
		for (int i =index; i<=last; i++) {
			a[i] = a[i+1];
		}
		if (last+1== a.length/2) 
			resize(-1);		
		return (E) hold;
	}

	
	public String toString() {
		if (last == -1) 
			return "empty list";	
		String s = "";
		for (int i = 0; i<=last; i++) {
			s+= i+": "+a[i].toString()+" | \n";
		}
		return s;
	}

	
	public int size() {
		return last+1;
	}
}