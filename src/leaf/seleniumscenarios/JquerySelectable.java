package leaf.seleniumscenarios;

import leaf.homeworksweek2.WrapperCode;

public class JquerySelectable extends WrapperCode {
	
	
	public static void main(String args[]){
		
		
		JquerySelectable s = new JquerySelectable();
		
		s.startBrowser("chrome", "https://www.irctc.co.in/eticketing/loginHome.jsf");
		
		s.clickWebLink("Sign up");
		
		s.selectByVisualText("userRegistrationForm:occupation", "Private");
		
		s.selectByIndex("userRegistrationForm:countries", 1);
		
		//s.colseBrowser();
	}

}
