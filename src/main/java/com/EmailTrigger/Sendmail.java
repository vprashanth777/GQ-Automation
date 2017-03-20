package com.EmailTrigger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class Sendmail 
{
  
	public  void mail( ) throws Exception
    {
    	Properties P,TestDataproperties = new Properties();
    	 FileInputStream fis;
    	 //Data From Test Config
    	try {
			fis = new FileInputStream("Data/TestProperties.xml");
			TestDataproperties.loadFromXML(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	String BrowserType=TestDataproperties.getProperty("BrowserType");
    	String URL=TestDataproperties.getProperty("GQWebURL");
    	P = new Properties();
		try {
			fis = new FileInputStream("Data/EmailProperties.xml");
			 P.loadFromXML(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date date = new Date();
		SimpleDateFormat sdf =new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
		String timeStamp = sdf.format(date);
		
    	
    	String subject = P.getProperty("subject")+" - "+timeStamp;
         String to = P.getProperty("recipients");//change accordingly  
         final String from = P.getProperty("from"); 
         String host = P.getProperty("SMTP_HOST_NAME");//or IP address  
         String Port = P.getProperty("SMTP_PORT");
       
         
       
  
         
         Properties props = new Properties();
 		props.put("mail.smtp.auth", "true");
 		props.put("mail.smtp.starttls.enable", "true");
 		props.put("mail.smtp.host", host);
 		props.put("mail.smtp.port", Port);
 		//props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
         
        Session session = Session.getDefaultInstance(props,  
        		   new javax.mail.Authenticator() {  
        		   protected PasswordAuthentication getPasswordAuthentication() {  
        		   return new PasswordAuthentication(from,"!password005");//change accordingly  
        		   }  
        		  });  
         
        // Session session = Session.getDefaultInstance(props);
      //   Session session = Session.getDefaultInstance(properties);  
        //compose the message  
         try{  
        	 Message  message = new MimeMessage(session);  
            message.setFrom(new InternetAddress(from));  
            
            String[] recipientList = to.split(",");
            InternetAddress[] recipientAddress = new InternetAddress[recipientList.length];
            int counter = 0;
            for (String recipient : recipientList) {
                recipientAddress[counter] = new InternetAddress(recipient.trim());
                counter++;
            }
            message.setRecipients(Message.RecipientType.TO, recipientAddress);
            
           // message.addRecipient(Message.RecipientType.TO,new InternetAddress(to));  
            message.setSubject(subject); 
            
            String content="Hi All,"  + System.lineSeparator() + System.lineSeparator() +
            		"Please find the Automation execution summary for as an attachment and Below are the Execution Details" + System.lineSeparator() +System.lineSeparator() + 
            		"Browser Name =" +BrowserType 
            		+ System.lineSeparator() + System.lineSeparator() +"URL =" +URL + System.lineSeparator() + System.lineSeparator() +"Thank you," + System.lineSeparator() + System.lineSeparator() + "GQA Automation team."
            		+ System.lineSeparator() + System.lineSeparator() + "Note: Please Use Chrome browser for attached result view for better experiance";
            
        
            BodyPart messageBodyPart = new MimeBodyPart();
          
            // Now set the actual message
            messageBodyPart.setText(content);
                     
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart);
            
          
            
         //   DataSource source;
            File dir = new File("target/");
            String list[] = dir.list();
         
            for (int i=0, n=list.length; i<n; i++) {
              File f = new File(list[i]);
              
              if (f.toString().contains("html") ) {
            	  messageBodyPart = new MimeBodyPart();
            	  System.out.println(f);
                  DataSource source = new FileDataSource("target/"+f);
                  messageBodyPart.setDataHandler(new DataHandler(source));
                  messageBodyPart.setFileName(f.toString());
                  multipart.addBodyPart(messageBodyPart);
              }
            }
          
         
            message.setContent(multipart,"text/html");

            // Send the complete message parts
          
            
            Transport.send(message);  
            System.out.println("message sent successfully....");  
     
         }catch (MessagingException mex) {mex.printStackTrace();}  
      }  
		
		
    }

