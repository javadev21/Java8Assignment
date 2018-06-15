package com.java8.stream;

import java.time.Year;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Java8StreamTest {

	public static void main(String[] args) {
		
	Item itm1= new Item(101,"headphone",2000);
	Item itm2= new Item(101,"radio",2050);
	Item itm3= new Item(101,"TV",20000);
	Item itm4= new Item(101,"Computer",30000);
	Item itm5= new Item(101,"Mobile",10000);
	
	Set<Item> itmSet1 = new HashSet<Item>();
	itmSet1.add(itm1);
	itmSet1.add(itm2);
	
	Set<Item> itmSet2 = new HashSet<Item>();
	itmSet1.add(itm3);
	itmSet1.add(itm4);
	
	Set<Item> itmSet3 = new HashSet<Item>();
	itmSet1.add(itm1);
	itmSet1.add(itm5);
	

	Customer cust1 = new Customer(1001,"sam",itmSet1);
	Customer cust2 = new Customer(1002,"black", itmSet2);
	Customer cust3 = new Customer(1003,"mile" ,itmSet3);
	
	List<Customer> custList= new ArrayList<Customer>();
	custList.add(cust1);
	custList.add(cust2);
	custList.add(cust3);
	
System.out.println(getEachCustTotalPrice(custList));
		
	}
	
	
	public static Map<String, Integer> getEachCustTotalPrice(List<Customer> custList){
		
		/*Stream<Map<String,String>> priceMap= custList.stream().map(x->x.getItems())
				.flatMap(y->y.stream()).collect(Collectors.toMap( Customer::getCustName, Item::getItemPrice));*/
		
		
	Map<String, Integer> priceMap=  custList.stream().collect(Collectors.toMap(Customer::getCustName, x->x.getItems().stream().map(y->y.getItemPrice()).mapToInt(z->z).sum()));
		
		
		return priceMap;		
		
	}

}
