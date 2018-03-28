package derp;

public class Derp {

	private String name = "default name";

	public Derp(String constructName){
		name = constructName;
	}

	public void sayName(){
		System.out.println(name);
	}

	public String getName(){
		return name;
	}

	public String setName(String newName){
		name = newName;
		return name;
	}

}