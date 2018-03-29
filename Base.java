import coolgame.*;

import javax.swing.JFrame;

public class Base {

	public static JFrame createFrame(String header){
        JFrame frame = new JFrame(header);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Display the window.
        return frame;
	}

	public static void main(String[] args){
		System.out.println("Start Main");


		JFrame frame = createFrame("This is the header!!!!");

		CoolGame game1 = new CoolGame(frame);

		game1.start();

	}

}

//delete compiled files
// find . -type f -path "./*" -name "*.class" -delete