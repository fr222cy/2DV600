package fr222cy_assign2.Exercise_4;



import static org.junit.Assert.*;
import org.junit.*;


public class QueueTest {
	
	private static int testID;
	
	@Before
	public void setUp(){
		testID++;
		System.out.println("Running Test:" +testID);
	}
	
	@After
	public void tearDown() {
		System.out.println("Test:"+testID + "|Completed");	
	}
	
	@Test
	public void testEnqueue(){
		//Creates a queue containing 1 000 000 elements.
		Queue<Integer> bigQueue = build(1000000);
		//Check that the queue has the expected size.
		assertEquals(bigQueue.size(), 1000000);
		//Add one more element to the queue
		bigQueue.enqueue(1000000);
		//Check that the size has increased by one.
		assertEquals(bigQueue.size(), 1000001);
	}
	
	@Test
	public void testDequeue(){
		//Creates a queue containing 1 000 000 elements.
		Queue<Integer> bigQueue = build(1000000);
		//Check that the queue has the expected size.
		assertEquals(bigQueue.size(), 1000000);
		//The first dequeue should return and remove the head element (0)
		assertTrue(bigQueue.dequeue() == 0);
		//Ensure that dequeued value is removed from the queue.
		for(Object val : bigQueue){
			assertNotEquals(val, 0);
			
		}
		//Dequeue all elements in the queue.
		for(int i = 1; i < 1000000; i++){
			assertTrue(i == bigQueue.dequeue());
		}
		//Check if the queue is empty.
		assertTrue(bigQueue.isEmpty());
		//Try to dequeue a empty queue.
		//Should throw IndexOutOfBoundsException.
		try{
			bigQueue.dequeue();
			fail("Should throw IndexOutOfBoundsException!");
		}catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testSize(){
		Queue<Integer> q1 = build(0);
		Queue<Integer> q2 = build(100000);
		Queue<String> q3 = new Queue<>();
		
		assertEquals(q1.size(), 0);
		assertEquals(q2.size(), 100000);
		
		q3.enqueue("1");
		q3.enqueue("5");
		assertEquals(q3.size(), 2);
	}
	
	@Test
	public void testIsEmpty(){
		Queue<Integer> q1 = build(0);
		Queue<Integer> q2 = build(100);
		
		assertTrue(q1.isEmpty());
		assertTrue(!q2.isEmpty());
	}
	
	@Test
	public void testFirst(){
		Queue<String> q1 = new Queue<>();
		Queue<String> q2 = new Queue<>();
		
		//Add four elements to queue 1.
		q1.enqueue("1st Element in");
		q1.enqueue("2nd Element in");
		q1.enqueue("3rd Element in");
		q1.enqueue("4th Element in");
		//The head should be the first element sent in.
		assertEquals(q1.first(), "1st Element in");
		
		try {
			q2.first();
			fail("Should throw IndexOutOfBoundsException!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
	
	@Test
	public void testLast(){
		Queue<String> q1 = new Queue<>();
		Queue<String> q2 = new Queue<>();
		//Add four elements to queue 1.
		q1.enqueue("1st Element in");
		q1.enqueue("2nd Element in");
		q1.enqueue("3rd Element in");
		q1.enqueue("4th Element in");
		//The tail should be the last element sent in.
		assertEquals(q1.last(), "4th Element in");
		
		try {
			q2.last(); 
			fail("Should throw IndexOutOfBoundsException!");
		} catch (IndexOutOfBoundsException e) {
			assertTrue(true);
		}
	}
		
	private Queue<Integer> build(int size){
		Queue<Integer> queue = new Queue<>();
		for(int i = 0; i < size; i++){
			queue.enqueue(i);
		}
		return queue;
	}
	
}
