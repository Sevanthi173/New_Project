package org.pages;

import org.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage extends BaseClass{
	public RegistrationPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(id="u_0_0_ay")
	private WebElement btncreate;
	@FindBy(name="firstname")
	private WebElement firstname;
	@FindBy(name="lastname")
	private WebElement lastname;
	@FindBy(name="reg_email__")
	private WebElement email;
	@FindBy(name="reg_passwd__")
	private WebElement password;
	@FindBy(name="birthday_day")
	private WebElement birthday;
	@FindBy(name="birthday_month")
	private WebElement birthmonth;
	@FindBy(name="birthday_year")
	private WebElement birthyear;
	@FindBy(xpath="//label[text()='Female']")
	private WebElement selcectfemale;
	@FindBy(name="websubmit")
	private WebElement singup;
	public WebElement getBtncreate() {
		return btncreate;
	}
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getLastname() {
		return lastname;
	}
	public WebElement getEmail() {
		return email;
	}
	public WebElement getPassword() {
		return password;
	}
	public WebElement getBirthday() {
		return birthday;
	}
	public WebElement getBirthmonth() {
		return birthmonth;
	}
	public WebElement getBirthyear() {
		return birthyear;
	}
	public WebElement getSelcectfemale() {
		return selcectfemale;
	}
	public WebElement getSingup() {
		return singup;
	}
	
	
	
	
	
	
	

}
