import derp.Derp;

import dog.Dog;

import coolgame.*;

import javax.swing.*;

public class Base {

	public static JFrame createFrame(String header, String body){
        JFrame frame = new JFrame(header);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel(body);
        frame.add(label);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        return frame;
	}

	public static void main(String[] args){
		System.out.println("Start Main");

		// Derp obj1 = new Derp("derp1");

		// Derp obj2 = new Derp("derp2");

		// obj1.sayName();
		// obj2.sayName();

		// obj1.setName("new obj1 name");

		// System.out.println(obj1.getName());

		// JFrame frame = createFrame("This is the header!!!!", "THIS IS THE BODYYY!!!");

		CoolGame game1 = new CoolGame();

		game1.start();

	}

}