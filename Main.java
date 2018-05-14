/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainapp;

/**
 *
 * @author USER
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
		System.out.println("1.Admin");
		System.out.println("2.Agent");
		System.out.println("3.Exit");
		int x;
                int hid=0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		x=Integer.parseInt(br.readLine());
		LoginPojo loginpojo=new LoginPojo();
		LoginDAO logindao=new LoginDAO();
		switch(x)
		{
		case 1:
			System.out.println("Enter the username");
			String username=br.readLine();
			System.out.println("Enter the password");
			String password=br.readLine();
			loginpojo.setUsername(username);
			loginpojo.setPassword(password);
                        int r=1;
                        loginpojo.setRole(r);
                        if(logindao.validate(loginpojo)==true)
			{
				Product product=new Product();
				product.menu();
			}
			break;
	       case 2:
			System.out.println("Enter the username");
			String user=br.readLine();
			System.out.println("Enter the password");
			String pass=br.readLine();
			loginpojo.setUsername(user);
			loginpojo.setPassword(pass);
                        int r2=2;
                        loginpojo.setRole(r2);
			if(logindao.validate(loginpojo)==true)
			{
				Product product=new Product();
				product.menu2();
			}
			break;
	       case 3:
                   System.exit(0);
                   break;
		}
		}
		
	}




