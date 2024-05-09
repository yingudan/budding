package com.ripper.budding.math;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class HashTest {

	public static void main(String[] args) {
		// Map<User, Integer> map = new HashMap<>();
		User user = new User("1", 15);
		User user2 = new User("1", 15);
		// map.put(user, 233333);
//		System.out.println(user.equals(user2));
		System.out.println(user==user2);
		Key key1 = new Key(1);
		Key key2 = new Key(1);
		// HashMap<Key, String> hm = new HashMap<Key, String>();
		// hm.put(key1, "Key with id is 1");
		// System.out.println(hm.get(key2));
	}

}

class Key {
	private Integer id;

	public Integer getId() {
		return id;
	}

	public Key(Integer id) {
		super();
		this.id = id;
	}

	// public boolean equals(Object o) {
	// if (o == null || !(o instanceof Key)) {
	// return false;
	// } else {
	// return this.getId().equals(((Key) o).getId());
	// }
	// }
	//
	// public int hashCode() {
	// return id.hashCode();
	// }
}

class User {

	private String name;

	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public User(String name, Integer age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public int hashCode() {
		final int prime = 31; // 31是个神奇的数字，因为任何数n * 31就可以被JVM优化为 (n << 5)
								// -n,移位和减法的操作效率要比乘法的操作效率高的多。
		int result = 0;
		result = prime * result + name.hashCode();
		result = prime * result + age;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		// 如果为同一对象的不同引用,则相同
		if (this == obj) {
			return true;
		}
		// 如果传入的对象为空,则返回false
		if (obj == null) {
			return false;
		}
		// 如果两者属于不同的类型,不能相等
		if (getClass() != obj.getClass()) {
			return false;
		}
		// 类型相同, 比较内容是否相同
		User other = (User) obj;
		return Objects.equals(name, other.name) && age == other.age;
	}

}