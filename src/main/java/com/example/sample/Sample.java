package com.example.sample;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/dhinesh")
public class Sample {

	@GetMapping(value = "/Hello")
	public String getHi() {
		return "Hello World";
	}

	@GetMapping(value = "/Num")
	public int getNum() {
		return 1130;
	}

	@GetMapping(value = "/square/{num}")
	public int findSquare(@PathVariable int num) {
		return num * num;
	}

	@GetMapping(value = "/even/{num}")
	public List<Integer> findEven(@PathVariable int num) {
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			if (i % 2 == 0) {
				nums.add(i);
			}
		}
		return nums;
	}

	@GetMapping(value = "/fibo/{num}")
	public List<Integer> findFibonici(@PathVariable int num) {
		List<Integer> nums = new ArrayList<>();
		int a = 0;
		int b = 1;
		int c = 0;

		for (int i = 0; i <= num; i++) {
//			System.out.println(a);
			nums.add(c = a);
			a = b;
			b = a + c;
//			c = a;

		}
		return nums;
	}

	@RequestMapping(value = "/odd/{num}")
	public List<Integer> findOdd(@PathVariable int num) {
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			if (i % 2 != 0) {
				nums.add(i);
			}
		}
		return nums;
	}

	@RequestMapping(value = "/fact/{num}")
	public String findFactorial(@PathVariable int num) {
		int fact = 1;
		for (int i = 1; i <= num; i++) {
			fact = fact * i;
		}
		return "" + num + " factorial is " + fact;
	}
	
	@RequestMapping(value = "/issquare/{num}")
	public String isSquare(@PathVariable int num) {
		
		int div = 0;
		boolean square = false;
		for(int i = 1;i<=num;i++) {
			div = num/i;
			if(div == i) {
				square = true;
			}
		}
		if(square == true) {
			return ""+num+" is a Square Number";
		}
		else {
			return ""+num+" is Not Square Number";
			
		}
	}
	
	@GetMapping(value="/getCar")
	public List<Car> getCar(@RequestBody List<Car> c) {
		return c;
	}
	@GetMapping(value="/getBran")
	public List<Car> getColor(@RequestBody List<Car> c) {
		List<Car> bran = new ArrayList<>();
		for (Car x : c) {
			if(x.getBrand().equalsIgnoreCase("Ford")) {
				bran.add(x);
			}
		}
		return bran;
	}
	@GetMapping(value="/getPri")
	public List<Car> getPrice(@RequestBody List<Car> c) {
		List<Car> bran = new ArrayList<>();
		for (Car x : c) {
			if(x.getBrand().equalsIgnoreCase("Ford")) {
				bran.add(x);
			}
		}
		return bran;
	}
	
	@GetMapping(value="/getMode/{model}")
	public List<Car> getModel(@RequestBody List<Car> c, @PathVariable String model) {
		List<Car> mode = new ArrayList<>();
		for (Car x : c) {
			if(x.getModel().contains(model)){
				mode.add(x);
			}
		}
		return mode;
	}
	
	
//	@GetMapping(value="/getPr")
//	public Car getPrice1(@RequestBody List<Car> c) {
//	Car car = c.stream().max(Comparator.comparing(Car :: getPrice)).get();
//	
//	List<Car> collect = c.stream().limit(1).collect(Collectors.toList());
//	
//	return collect;
//	}

}
