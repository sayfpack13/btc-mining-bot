import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class captcha {
private static String result;

	public static String resolve_captcha(WebElement element,WebDriver browser) {
		File screen = ((TakesScreenshot) browser).getScreenshotAs(OutputType.FILE);
		
		int ImageWidth = element.getSize().getWidth();
		int ImageHeight=element.getSize().getHeight();
		
		Point point=element.getLocation();
		
		int xcord=point.getX();
		int ycord=point.getY();
		
		BufferedImage img = null;
		try {
			img = ImageIO.read(screen);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		BufferedImage dest=img.getSubimage(xcord, ycord, ImageWidth, ImageHeight);
		
		try {
			ImageIO.write(dest, "png", screen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		
		Date date=new Date();
		String date1=dateFormat.format(date);
		
		
		
		try {
			FileUtils.copyFile(screen,new File("..\\images\\"+date1+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Tesseract instance=new Tesseract();
		
		instance.setDatapath("..\\"); 
		instance.setLanguage("eng");
		
		
		try {
			result=instance.doOCR(screen).trim();
		} catch (TesseractException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
}
