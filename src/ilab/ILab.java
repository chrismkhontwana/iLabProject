/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilab;

import com.relevantcodes.extentreports.LogStatus;
import org.junit.Test;
import org.openqa.selenium.By;

/**
 *
 * @author chrismkhontwana
 */
public class ILab extends SeleniumActions
{
    Properties  prop = new Properties(); 
    //TestData    data = new TestData();

    public void ApplyOnline()
    {
          startBrowser("Chrome");
          if(!navigate("http://www.ilabquality.com"))
          {
              test.log(LogStatus.FAIL, "Failed to navigate to ilab website");
              return;
          }
          test.log(LogStatus.PASS, "Successfully navigated to the ilab website");
          
          if(!userClick(By.xpath(prop.careerTab())))
          {
              test.log(LogStatus.FAIL, "Failed to click career tab");
              return;
          }
          test.log(LogStatus.PASS, "Successfully clicked thr career tab");
          
          if(!scrollToElement(By.xpath(prop.SelectCountry())))
          {
              test.log(LogStatus.FAIL, "Failed to click career tab");
              return;
          }
          test.log(LogStatus.PASS, "Successfully clicked the career tab");
          
          if(!userClickByActions(By.xpath(prop.SelectCountry())))
          {
              test.log(LogStatus.FAIL, "Failed to click South Africa");
              return;
          }
          test.log(LogStatus.PASS, "Successfully clicked South Africa");
          
          if(!userClickByActions(By.xpath(prop.jobLinktext())))
          {
              test.log(LogStatus.FAIL, "Failed to click the 1st job link");
              return;
          }
          test.log(LogStatus.PASS, "Successfully clicked the 1st job link");
          
          
          if(!scrollToElement(By.xpath(prop.applyButton())))
          {
              test.log(LogStatus.FAIL, "Failed to scroll to apply button");
              return;
          }
          test.log(LogStatus.PASS, "Successfully scrolled to apply button");
          
          
          if(!userClick(By.xpath(prop.applyButton())))
          {
             test.log(LogStatus.FAIL, "Failed to click apply button");
             return;
          }
          test.log(LogStatus.PASS, "Successfully clicked apply button");
          
          
          if(!enterText(By.xpath(prop.applicationNameTxtbox()),TestData.applicationName))
          {
             test.log(LogStatus.FAIL, "Failed to enter the applicant name");
             return;
          }
         test.log(LogStatus.PASS, "Successfully entered the applicant name");
          
          if(!enterText(By.xpath(prop.emailTxtBox()),TestData.emailaddress))
          {
             test.log(LogStatus.FAIL, "Failed to enter the email address");
             return;
          }
         test.log(LogStatus.PASS, "Successfully entered email address");
        
          
          if(!enterText(By.xpath(prop.phoneTxtBox()), data.generatePhoneNumber()))
          {
             test.log(LogStatus.FAIL, "Failed to enter the phone number");
             return;
          }
         test.log(LogStatus.PASS, "Successfully entered phone number");
  
          
          if(!enterText(By.xpath(prop.messageTxtArea()), TestData.message))
          {
             test.log(LogStatus.FAIL, "Failed to enter the message");
             return;
          }
         test.log(LogStatus.PASS, "Successfully entered the message");
      
              
          if(!userClickByActions(By.xpath(prop.sendButton())))
          {
             test.log(LogStatus.FAIL, "Failed to click the send button");
             return;
          }
         test.log(LogStatus.PASS, "Successfully clicked the send button");
         test.log(LogStatus.PASS, "Successfully applied to iLab via online");
    }
    
    
}
