package fr222cy_assign1.Queue;
/**
 * @author Filip Rydberg
 *
 */
import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Queue queue = new Queue();
		
		queue.enqueue("1");
		queue.enqueue("2");
		queue.enqueue("3");
		queue.enqueue("4");
		queue.enqueue("5");

		Iterator<Object> iterator = queue.iterator();
		System.out.print("Values in queue:");
		while(iterator.hasNext()){
			System.out.print(iterator.next()+", ");
		}
		System.out.println();
		System.out.println("-----");
		
		System.out.println("Size:"+queue.size());
		System.out.println("-----");
		System.out.println("First:"+queue.first());
		System.out.println("-----");
		System.out.println("Last:"+queue.last());
		System.out.println("-----");
		System.out.println("dequeue() | response :"+queue.dequeue());
		System.out.println("-----");
		System.out.println("First:"+queue.first());
		System.out.println("-----");
		System.out.println("Last:"+queue.last());
		System.out.println("-----");
		System.out.println("queue.contains('3') Found object:" + queue.contains("3"));
		System.out.println("-----");
		System.out.println("queue.contains('1') Found object:" + queue.contains("1"));
		System.out.println("-----");
		System.out.println("Dequeue till empty |dequeue value and size");
		while(!queue.isEmpty()){
			System.out.println("Dequeue response:"+queue.dequeue());
			System.out.println("Queue Size after dequeue ="+queue.size() );
		}
		System.out.println("queue.isEmpty =" + queue.isEmpty());
		
	}

}
