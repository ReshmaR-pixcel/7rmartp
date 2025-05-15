package utilities1;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUploadUsingSendKeys(WebElement element, String path){
		element.sendKeys(path);
		}

	public void fileUploadUsingRobotClass(WebElement element, String path) throws AWTException{
		
		
		StringSelection select=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select,null); //copy file in obj select to clipboard
		Robot obj =new Robot(); 
		obj.delay(2500);//delay for some time to copy and paste
		obj.keyPress(KeyEvent.VK_CONTROL);//pressed keyboard control+
		obj.keyPress(KeyEvent.VK_V);//keyboard V-paste
		obj.keyRelease(KeyEvent.VK_CONTROL);
		obj.keyRelease(KeyEvent.VK_V);
		obj.keyPress(KeyEvent.VK_ENTER);
		obj.keyRelease(KeyEvent.VK_ENTER);
		
		
	}

}
