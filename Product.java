/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;

public class Product {

	public void menu() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
                int x;
		LoginDAO logindao=new LoginDAO();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		do
		{
			System.out.println("1.Add Product");
			System.out.println("2.Display");
			System.out.println("3.Logout");
			x=Integer.parseInt(br.readLine());	
		switch(x)
		{
		case 1:
			System.out.println("Enter the Product ID");
			int id=Integer.parseInt(br.readLine());
			System.out.println("Enter the Product Name");
			String product_name=br.readLine();
			System.out.println("Enter the Minimum Selling Quantity");
			int minsell=Integer.parseInt(br.readLine());
			System.out.println("Enter the Price");
			float price=Float.parseFloat(br.readLine());
			ProductPojo productpojo=new ProductPojo();
			productpojo.setProductid(id);
			productpojo.setProduct_name(product_name);
			productpojo.setMinsell(minsell);
			productpojo.setPrice(price);
			logindao.addProduct(productpojo);
			break;
		case 2:
			logindao.displayProduct();
			break;
		case 3:
			Main.main(null);
			break;
		}
		}while(x>0 && x<=3);
	}
        public void menu2() throws NumberFormatException, IOException, ClassNotFoundException, SQLException {
                int x;
                int hid=0;
		LoginDAO logindao=new LoginDAO();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		do
		{
			System.out.println("1.Buy/Sell");
			System.out.println("2.ShowHistory");
			System.out.println("3.Logout");
			x=Integer.parseInt(br.readLine());	
		switch(x)
		{
		case 1:
                        System.out.println("Enter the Product ID");
			int id=Integer.parseInt(br.readLine());
                        logindao.displayProduct2(id);
                        System.out.println("Buy or Sell?");
                        String option=br.readLine();
                        ProductPojo productpojo=new ProductPojo();
			productpojo.setProductid(id);
                        String product_name=logindao.getProductName(id);
			productpojo.setProduct_name(product_name);
                        productpojo.setTrans(option);
                        System.out.println("Quantity?");
                        int q=Integer.parseInt(br.readLine());
                        productpojo.setHistoryId(++hid);
                        int m=logindao.getMinSellQuantity(id);
                        if(q>m)
                        {
                            System.out.println("Product not available");
                            
                        }
                        else
                        {
                            productpojo.setQuantity(q);
                            float costperitem=logindao.getPrice(id);
                            float total=costperitem*q;
                            productpojo.setTotal(total);
                            System.out.println(total);
                        }
                        logindao.addHistory(productpojo);
			break;
                case 2:
                    logindao.showHistory();
                    break;
                case 3:
                   Main.main(null);
                    break;
                }
                }while(x>0 && x<=3);
                    
                    
                    
        }
	
	
}
