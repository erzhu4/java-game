import derp.Derp;

import dog.Dog;

public class Base {

	public static void main(String[] args){
		System.out.println("Start Main");

		Derp obj1 = new Derp("derp1");

		Derp obj2 = new Derp("derp2");

		obj1.sayName();
		obj2.sayName();

		obj1.setName("new obj1 name");

		System.out.println(obj1.getName());
	}

}