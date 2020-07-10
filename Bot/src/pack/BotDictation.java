package pack;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;



public class BotDictation {
	public static void main(String[] args) {
		tape("");
	}
	
	private static void tape(String s) {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}
	    for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        
	        
	        
	        if (Character.isUpperCase(c)) {
	            robot.keyPress(KeyEvent.VK_SHIFT);
	        }
	        robot.keyPress(Character.toUpperCase(c));
	        robot.keyRelease(Character.toUpperCase(c));

	        if (Character.isUpperCase(c)) {
	            robot.keyRelease(KeyEvent.VK_SHIFT);
	        }
	    }
	    robot.keyPress(KeyEvent.VK_TAB);
        robot.keyRelease(KeyEvent.VK_TAB);
	    robot.delay(80);
	}
	
}
/*
//1
tape("arrested");
tape("the");
tape("prime");
tape("suspect");
//2
tape("According");
tape("to");
tape("conventional");
tape("wisdom");
//3
tape("the");
tape("final");
tape("decision");
tape("was");
tape("made");
//4
tape("marketing");
tape("campaign");
tape("focus");
tape("on");
//5
tape("health");
tape("problem");
tape("is");
tape("being");
tape("studied");
//6
tape("dont");
tape("think");
tape("they");
tape("were");
tape("relevant");
//7
tape("reduce");
tape("the");
tape("inflammation");
tape("in");
tape("my");
tape("knee");
//8
tape("honour");
tape("all");
tape("of");
tape("the");
tape("honest");
tape("people");
//9
tape("wait");
tape("for");
tape("two");
tape("and");
tape("a");
tape("half");
tape("hours");
//10
tape("the");
tape("food");
tape("was");
tape("mentioned");
tape("by");
tape("every");
tape("customer");
*/
