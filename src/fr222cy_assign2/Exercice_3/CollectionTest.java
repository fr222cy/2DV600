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
		assertEquals(list2.size(),10000);
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
		assertEquals(list.size(), 11);
		list.addAt(101, 9);
		//Add val 101 at index 9
		//Check if size has been changed +1.
		assertEquals(list.size(),12);
		//Check if previous value at index 9 has shifted right to index 10.
		assertEquals(list.get(10),100);
		
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
		assertEquals(list.size(), 9999);
		//Check if element that was at index 0 (0)...
		//Now is removed and replaced with the element that was on index 1 (1).
		assertEquals(list.get(0), 1);
		
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
			assertEquals(list.get(i), i);
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
			assertEquals(list.indexOf(i), i);
		}
		//If the index doesn't exist, the method should return -1.
		assertEquals(list.indexOf(10001),-1);
	}
	
	@Test
	public void testPush(){
		ArrayIntStack lIntStack = buildIntStack(10000);
		ArrayIntStack emptyStack = buildIntStack(0);
		//Check if the size of the stack is the amount sent in. 
		assertEquals(lIntStack.size() , 10000);
		assertTrue(emptyStack.isEmpty());
	}
	
	@Test
	public void testPop(){
		ArrayIntStack liStack = buildIntStack(10000);
		ArrayIntStack emptyStack = buildIntStack(0);
		//Check if its possible to remove the top of the stack.
		//And see if the value is returned. (in this case 9999).
		assertEquals(liStack.pop(), 9999);
		//Ensure that the value that was popped was removed.
		assertNotEquals(liStack.pop(), 9999);
		for(int val : liStack){
			assertNotEquals(val, 9999);
		}
		//Check if the next value to pop is the next value in the list.
		assertEquals(liStack.pop(), 9997);
		
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
		assertEquals(liStack.peek(), 100000);
				
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
