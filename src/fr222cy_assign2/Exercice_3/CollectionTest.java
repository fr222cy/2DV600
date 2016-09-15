package fr222cy_assign2.Exercice_3;

import static org.junit.Assert.*;

import java.nio.file.attribute.AclEntry.Builder;
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

public class CollectionTest {
	private static int testID;
	
	@Before
	public void setUp(){
		testID++;
		System.out.println("Running test:" +testID);
	}
	
	@After
	public void tearDown() {
		System.out.println("Complete");
		
	}
	
	
	@Test
	public void testAdd(){
		//Builds two intLists with the specified size.
		//Check if the list has the specified size.
		ArrayIntList list1 = buildIntList(5);
		ArrayIntList list2 = buildIntList(10000);
		assertTrue(list1.size() == 5);
		assertTrue(list2.size() == 10000);
		
	}
	
	@Test
	public void testAddAt(){
	
		ArrayIntList list = buildIntList(10);
		//Add val 100 at index 9
		list.addAt(100, 9);
		//Check if size has been changed +1.
		assertTrue(list.size() == 11);
		list.addAt(101, 9);
		//Add val 101 at index 9
		//Check if size has been changed +1.
		assertTrue(list.size() == 12);
		//Check if previous value at index 9 has shifted right to index 10.
		assertTrue(list.get(10) == 100);
		
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
		
		for(int i = 0; i < list.size(); i++){
			assertEquals(list.indexOf(i), i);
		}
		//If the index doesn't exist, the method should return -1.
		assertTrue(list.indexOf(10001) == -1);
	}
	
	private ArrayIntList buildIntList(int size){
		ArrayIntList list = new ArrayIntList();
		for(int i = 0; i < size; i++){
			list.add(i);
		}
		return list;
	}
	
}
