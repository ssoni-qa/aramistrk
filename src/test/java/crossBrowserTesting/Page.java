package crossBrowserTesting;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Page {
	
	
	//Information Page
	@FindBy(id="i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-first-name")
	public WebElement firstName;
	
	@FindBy(id="i-input-81dfe9a6-361c-4606-95f9-119ffd994f15-last-name")
	public WebElement lastName;

	@FindBy(id="i-input-9af4f79d-c77e-4b69-a975-2b46df37610d-default")
	public WebElement emailAddress;
	
	@FindBy(id="i-input-9a9d8356-5ef8-4f0e-aed4-e1fa700307a2-month")
	public WebElement month;
	
	@FindBy(id="i-input-9a9d8356-5ef8-4f0e-aed4-e1fa700307a2-day")
	public WebElement day;
	
	@FindBy(id="i-input-9a9d8356-5ef8-4f0e-aed4-e1fa700307a2-year")
	public WebElement year;
	
	@FindBy(id="i-input-aed8d9b3-04f0-42fa-9d8f-2ae196b0aa66-default")
	public WebElement gender;
	
	@FindBy(name="e2391395-ae36-45cd-ab79-f1330f00c4ff-default")
	public WebElement phoneNo;
	
	@FindBy(id="i-input-ec58cc90-9cc1-448a-a95a-f33ed26163a2-address-1")
	public WebElement streetAdd;
	
	@FindBy(name="ec58cc90-9cc1-448a-a95a-f33ed26163a2-city")
	public WebElement city;
	
	@FindBy(id="i-input-ec58cc90-9cc1-448a-a95a-f33ed26163a2-state")
	public WebElement state;
	
	@FindBy(id="i-input-ec58cc90-9cc1-448a-a95a-f33ed26163a2-zip")
	public WebElement zipCode;
	
	@FindBy(css="span.checkbox-material > span")
	public WebElement iAggree;
	
	@FindBy(css="#i-e071ae69-c557-4da7-9acf-9b395e77e72c-default > div.validation__wrapper > div.checkboxes > label > span.checkbox-material > span")
	public WebElement homeOwner;
	
	@FindBy(id="i-316651b8-b3cb-48bb-93b3-6f16675349ad")
	public WebElement continueBtn;
	
	//Survey Flow Page
	
	@FindBy(xpath="//div[@class='radioButtons']/label[1]")
	public WebElement yesBtn;
	
	@FindBy(css="label.form-label")
	public WebElement lablequest;
	
	
	//Confirm you Information 
	
	@FindBy(id="i-input-35e8359f-517c-44d1-b22c-6b61140e024a-month")
	public WebElement conMonth;
	
	@FindBy(id="i-input-35e8359f-517c-44d1-b22c-6b61140e024a-day")
	public WebElement conDay;
	
	@FindBy(id="i-input-35e8359f-517c-44d1-b22c-6b61140e024a-year")
	public WebElement conYear;
	
	@FindBy(css=".checkbox-material>span")
	public WebElement iConfirm;
	@FindBy(css="div.imageInner.pt > img")
	public WebElement conContinueBtn;
	
	@FindBy(linkText="marketing partners")
	public WebElement mktLink;
	
	@FindBy(xpath="/html/body/div[8]/div/button")
	public WebElement closeWindow;
	
	//Survey Offer Linkout Pages. 
	
	@FindBy(xpath="//button[@class='btn blockFormBtn diabetes-btns btn-raised']")
	public WebElement linkoutBtn;
	
	@FindBy(id="i-3bee30e7-91ed-4eb2-902d-765f0a373ad9")
	public WebElement yesIDoBtn;
	
	@FindBy(xpath="//*[@id='i-c40d54a9-6e8b-46da-8ba6-6086786bfd41']")
	public WebElement imgbtn;
	
	@FindBy(xpath="//button[contains(text(),'Continue')]")
	public WebElement imgbtn1;
	
	//Small Banner Offer Flow.
	@FindBy(xpath="//div[@class='iff-campaign-container-regular']/div[2]/label[1]/input")
	public WebElement radio;
	

}
