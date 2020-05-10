package com.WalletHub.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
Properties pro;
	
	public ReadConfig()
	{
		File src = new File("./Configurations/config.properties");
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}
		catch(Exception e) {
			System.out.println("Exception is " + e.getMessage());
			
		}
	}
	
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getUsername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;		
	}

	public String getWalletHubURL()
	{
		String url = pro.getProperty("walletHubLoginURL");
		return url;
	}
	public String getEmail()
	{
		String email = pro.getProperty("email");
		return email;
	}
	public String getPswrd()
	{
		String password = pro.getProperty("pswrd");
		return password;
	}
	public String getReviewNote()
	{
		String reviewNote = pro.getProperty("reviewNote");
		return reviewNote;
	}
	public String getProfileURL()
	{
		String profileURL = pro.getProperty("profileURL");
		return profileURL;
	}
}
