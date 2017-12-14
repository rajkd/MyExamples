package com.example.util;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class LamdaTest {

	public interface One{
		public void test();
	}
	
	public interface Two{
		public void test(String name);
	}

	public interface Three{
		public void test(String name, int age);
	}
	
	public static void main(String args[]){
		One o = () -> {System.out.println("One");};
		o.test();
		
		Two t = System.out::println;
		t.test("John");	
		
		Three tr = (p,q) -> {System.out.println("One" + p + q);};
		tr.test("John", 10);	
		
/*		List<String> list = new LinkedList<>();
		IntStream.range(1, 1000000).forEach(p -> list.add("Test"+p));
		long start = System.currentTimeMillis();
		System.out.println("######" + list.get(999998));
		System.out.println(System.currentTimeMillis() - start);*/
	}
}
