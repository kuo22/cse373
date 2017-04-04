// Kuo Hong
// Section AF

import java.util.LinkedList;
import java.util.Queue;

// This program tests the ListQueue implementation to check if its
// functions are producing the same result as the Java implementation.
public class QueueTest {
	/*Your functions (on the left) correspond to the following java Queue functions (on the right)
	 * toTest.enqueue(String a) = toCompare.add(String a)
	 * toTest.dequeue() = toCompare.poll()
	 * toTest.front() = toCompare.peek()
	 * 
	 * This private class performs this interface for you.
	 */
    private static class JavaQueue{
    	//DO NOT EDIT THIS CLASS
    	Queue<String> queue;
    	protected JavaQueue(){
    		queue = new LinkedList<String>();
    	}
    	protected void enqueue(String a){
    		queue.add(a);
    	}
    	protected String dequeue(){
    		return queue.poll();
    	}
    	protected String front(){
    		return queue.peek();
    	}
    }
    
	public static void main(String[] args){
		
		testEmpty(new ListQueue(),new JavaQueue());
		testOne(new ListQueue(),new JavaQueue());
		testMany(new ListQueue(),new JavaQueue());			
	}
	
	// Takes an empty ListQueue and an empty JavaQueue as parameters.
	// Compares the behaviors between ListQueue and JavaQueue when the queues
	// are empty. Returns true if there are no difference and false if ListQueue
	// behaves differently than JavaQueue.
	public static boolean testEmpty(ListQueue yourQueue, JavaQueue correctQueue){
		//TODO implement a test of the three functions when the queues are empty
		//Compare the result of your queue  against the java implementation
		if (yourQueue.front() != correctQueue.front())
			return false;
		if (yourQueue.dequeue() != correctQueue.dequeue())
			return false;
		
		yourQueue.enqueue("Testing");
		correctQueue.enqueue("Testing");
		if (yourQueue.front() != correctQueue.front())
			return false;
		if (yourQueue.dequeue() != correctQueue.dequeue())
			return false;
		
		System.out.println(yourQueue.front());
		System.out.println("passed testEmpty");
		return true;
	}
	
	// Takes an empty ListQueue and an empty JavaQueue as parameters.
	// Compares the behaviors between the two queues when both hold one element.
	// Returns true if there are no difference, and false if there are.
	public static boolean testOne(ListQueue a, JavaQueue b){
		//TODO implement a test of the three functions when the queues have one element
		//Compare the result of your queue  against the java implementation
		if (a.front() != b.front())
			return false;
		
		a.enqueue("a");
		b.enqueue("a");
		
		if (a.front() != b.front())
			return false;
		
		a.enqueue("b");
		b.enqueue("b");
		
		if (!a.dequeue().equals(b.dequeue()))
			return false;
		
		a.dequeue();
		b.dequeue();
		System.out.println(a.front());
		System.out.println("passed testOne");
		return true;
	}
	
	// Takes an empty ListQueue and an empty JavaQueue as parameters.
	// Compares the behaviors between the two queues when both hold many elements.
	// Returns true if there are no difference, and false if there are.
	public static boolean testMany(ListQueue a, JavaQueue b){
		//TODO implement a test of the three functions when the queues have many elements
		//Compare the result of your queue  against the java implementation
		//More than one test may be necessary
		if (a.front() != b.front())
			return false;
		
		a.enqueue("a");
		b.enqueue("a");
		a.enqueue("123!");
		b.enqueue("123!");
		a.enqueue("b");
		b.enqueue("b");
		a.enqueue("c");
		b.enqueue("c");
		a.enqueue("");
		b.enqueue("");
		a.enqueue("dog");
		b.enqueue("dog");
		
		if (a.front() != b.front())
			return false;
		
		while (b.front() != null) {
			if (!a.dequeue().equals(b.dequeue()))
				return false;
		}
		
		for (int i = 1; i <= 12; i++) {
			a.enqueue("_");
			b.enqueue("_");
		}
		
		while (b.front() != null) {
			if (!a.dequeue().equals(b.dequeue()))
				return false;
		}
		
		System.out.println(a.front());
		System.out.println("passed testMany");
		return true;
	}
}
