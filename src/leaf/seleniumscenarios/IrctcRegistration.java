package leaf.seleniumscenarios;

import org.testng.annotations.Test;

import leaf.homeworksweek2.WrapperCode;

public class IrctcRegistration extends WrapperCode {
	
	
	
	@Test
	
	public void irctcUserRegistration(){
		
		IrctcRegistration regis = new IrctcRegistration();
		
		regis.startBrowser("chrome", "https://www.irctc.co.in/");
		
		regis.clickWebLink("Sign up");
		
		regis.typeText("userRegistrationForm:userName", "lucoszoc12");
		
		regis.clickWebLink("Check Availability");
		
		regis.verifyText("//*[@id='userRegistrationForm:useravail']", "User Id is Available..Please go ahead with the Registration Process...");
		
		regis.typeText("userRegistrationForm:password", "lucoszoc12");
		
		regis.typeText("userRegistrationForm:confpasword", "lucoszoc12");
		
		regis.selectByVisualText("userRegistrationForm:securityQ", "What was the name of your first school?");
		
		regis.typeText("userRegistrationForm:securityAnswer", "SSVN");
		
		regis.selectByIndex("userRegistrationForm:prelan", 1);
		
		regis.typeText("userRegistrationForm:firstName", "Anil");
		
		regis.typeText("userRegistrationForm:lastName", "kumar");
		
		regis.clickButton("userRegistrationForm:gender:0");
		
		
	}
	
	
	
	
	

}
