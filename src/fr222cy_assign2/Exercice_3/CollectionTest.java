package fr222cy_assign2.Exercice_3;

import static org.junit.Assert.*;

import java.nio.file.attribute.AclEntry.Builder;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.accessibility.AccessibleRelation;
import javax.imageio.ImageTypeSpecifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.model.TestTimedOutException;

import fr222cy_assign2.Exercise_1.ArrayIntList;
import fr222cy_assign2.Exercise_1.ArrayIntStack;
/*
 * Tests the all the methods in following classes:
 * fr222cy_assign2.Exercise2.ArrayIntList
 * fr222cy_assign2.Exercise2.ArrayIntStack
 */
public class CollectionTest {
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
	public void testAdd(){
		//Builds two intLists with the specified size.
		//Check if the list has the specified size.
		ArrayIntList emptyList = buildIntList(0);
		ArrayIntList list2 = buildIntList(10000);
		assertEquals(10000,list2.size());
		assertTrue(emptyList.isEmpty());
		//Adds one to the previous empty list, to ensure that it is not empty anymore.
		emptyList.add(1);
		assertTrue(!emptyList.isEmpty());
	}
	
	@Test
	public void testAddAt(){
		ArrayIntList list = buildIntList(10);
		//Add val 100 at index 9
		list.addAt(100, 9);
		//Check if size has been changed +1.
		assertEquals(11,list.size());
		list.addAt(101, 9);
		//Add val 101 at index 9
		//Check if size has been changed +1.
		assertEquals(12,list.size());
		//Check if previous value at index 9 has shifted right to index 10.
		assertEquals(100,list.get(10));
		
		try{
			list.addAt(10,13);
			fail("Should throw IndexOutOfBoundsException");
		}
		catch(IndexOutOfBoundsException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testRemove(){
		ArrayIntList list = buildIntList(10000);
		//Remove element at index 0
		list.remove(0);
		//Check if size has been reduces by 1;
		assertEquals(9999,list.size());
		//Check if element that was at index 0 (0)...
		//Now is removed and replaced with the element that was on index 1 (1).
		assertEquals(1,list.get(0));
		
		try{
			list.remove(10000);
			fail("Should throw IndexOutOfBoundsException");
		}
		catch(IndexOutOfBoundsException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testGet(){
		ArrayIntList list = buildIntList(10000);
		
		for(int i = 0; i < list.size(); i++){
			assertEquals(i,list.get(i));
		}
		
		try{
			list.get(10001);
			fail("Should throw IndexOutOfBoundsException");
		}
		catch(IndexOutOfBoundsException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testIndexOf(){
		ArrayIntList list = buildIntList(10000);
		ArrayIntStack intStack = new ArrayIntStack();
		for(int i = 0; i < list.size(); i++){
			assertEquals(i,list.indexOf(i));
		}
		//If the index doesn't exist, the method should return -1.
		assertEquals(-1,list.indexOf(10001));
	}
	
	@Test
	public void testPush(){
		ArrayIntStack lIntStack = buildIntStack(10000);
		ArrayIntStack emptyStack = buildIntStack(0);
		//Check if the size of the stack is the amount sent in. 
		assertEquals(10000,lIntStack.size());
		assertTrue(emptyStack.isEmpty());
	}
	
	@Test
	public void testPop(){
		ArrayIntStack liStack = buildIntStack(10000);
		ArrayIntStack emptyStack = buildIntStack(0);
		//Check if its possible to remove the top of the stack.
		//And see if the value is returned. (in this case 9999).
		assertEquals(9999,liStack.pop());
		//Ensure that the value that was popped was removed.
		assertNotEquals(9999,liStack.pop());
		for(int val : liStack){
			assertNotEquals(9999, val);
		}
		//Check if the next value to pop is the next value in the list.
		assertEquals(9997, liStack.pop());
		
		try{
			emptyStack.pop();
			fail("Should throw IndexOutOfBoundsException");
		}
		catch(IndexOutOfBoundsException e){
			assertTrue(true);
		}
	}
	
	@Test
	public void testPeek(){
		//Adds a large stack with an size of 100001
		ArrayIntStack liStack = buildIntStack(100001);
		ArrayIntStack emptyStack = buildIntStack(0);
		//Peek should now return and not remove the top(100000)
		assertEquals(100000,liStack.peek());
				
		try{
			emptyStack.peek();
			fail("Should throw IndexOutOfBoundsException");
		}
		catch(IndexOutOfBoundsException e){
			assertTrue(true);
		}
	}
	
	private ArrayIntStack buildIntStack(int size){
		ArrayIntStack lIntStack = new ArrayIntStack();
		for(int i = 0; i < size; i++){
			lIntStack.push(i);
		}
		return lIntStack;
	}
	
	private ArrayIntList buildIntList(int size){
		ArrayIntList list = new ArrayIntList();
		for(int i = 0; i < size; i++){
			list.add(i);
		}
		return list;
	}
}
