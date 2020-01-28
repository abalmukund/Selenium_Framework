package com.test.util;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;
import com.google.common.io.Files;
import com.test.constants.TestConstants;
import com.test.cucumber.TestContext;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TakeScreenShot {
	TestContext testContext;
	WebDriver driver;

	public TakeScreenShot(WebDriver driver) {
		this.driver = driver;
	}

	public void getScreenShot(String stepName, Boolean fullPage) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String newtimestamp = timestamp.toString().replace(":", "-").replace(".", "-");
		String screenshotName = stepName.replaceAll(" ", "_") + "_" + newtimestamp;
		File sourcePath = null;
		File destinationPath = new File(TestConstants.SCREENSHOT_PATH + screenshotName + TestConstants.SCREENSHOT_IMAGE_EXT);
		try {
			if (fullPage.equals(true)) {
				//This takes a screenshot of full page
				Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);               
				ImageIO.write(screenshot.getImage(),"PNG",new File(destinationPath.toString()));
			}
			else {
				//This takes a screenshot of current viewable screen
				sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				Files.copy(sourcePath, destinationPath);
			}
			//This attach the specified screenshot to the test
			Reporter.addScreenCaptureFromPath(destinationPath.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
