/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ilab;

/**
 *
 * @author chrismkhontwana
 */
public class Properties
{   
    public  String careerTab()
    {
        return "//nav[@class ='navigation-right text-right']//a[text()='CAREERS']";
    }
    
    public  String SelectCountry()
    {
        return "//a[text() = 'South Africa']";
    }
    
    public  String messageTxtArea()
    {
        return "//textarea[@name='message']";
    }
    
    public  String applicationNameTxtbox()
    {
        return "//input[@id='applicant_name']";
    }
    
    public  String emailTxtBox()
    {
        return "//input[@name='email']";
    }
   
    public  String phoneTxtBox()
    {
        return "//input[@name='phone']";
    }
    public  String sendButton()
    {
        return "//input[@value = 'Send Application']";
    }
    
    public  String jobLinktext()
    {
        return "//span[@class='wpjb-line-major']/a";
    }
    
   public  String applyButton()
    {
        return "//a[text() ='Apply Online ']";
    }
    
     
    
}
