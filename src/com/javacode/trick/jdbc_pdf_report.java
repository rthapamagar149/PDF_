package com.javacode.trick;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class jdbc_pdf_report {

	public static void main(String[] args) throws Exception {
		System.out.println("Connection through Database");
		 Class.forName("com.mysql.cj.jdbc.Driver");
		 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/pdf","root","rabin12");
		 Statement stmt=conn.createStatement();
		 //Define the sql query
		 ResultSet query_set=stmt.executeQuery("select * from employee");
		 Document my_pdf_report=new Document();
		 String file_name="F:\\pdf\\test2.pdf";
		 PdfWriter.getInstance(my_pdf_report, new FileOutputStream(file_name));
		 my_pdf_report.open();
		 //we have 5 column in our database table
		 PdfPTable my_report_table=new PdfPTable(5);
			PdfPCell c1=new PdfPCell(new Phrase("Id"));
			my_report_table.addCell(c1);
		    c1=new PdfPCell(new Phrase("First Name"));
		    my_report_table.addCell(c1);
		    c1=new PdfPCell(new Phrase("Last Name"));
		    my_report_table.addCell(c1);
			c1=new PdfPCell(new Phrase("Address"));
			my_report_table.addCell(c1);
			c1=new PdfPCell(new Phrase("age"));
			my_report_table.addCell(c1);
		 
		 PdfPCell table_Cell;
		 while(query_set.next()) {
			 String emp_id=query_set.getString("id");
			 table_Cell=new PdfPCell(new Phrase(emp_id));
			 my_report_table.addCell(table_Cell);
			 String emp_fname=query_set.getString("fname");
			 table_Cell=new PdfPCell(new Phrase(emp_fname));
			 my_report_table.addCell(table_Cell);
			 String emp_lname=query_set.getString("lname");
			 table_Cell=new PdfPCell(new Phrase(emp_lname));
			 my_report_table.addCell(table_Cell);
			 String emp_address=query_set.getString("address");
			 table_Cell=new PdfPCell(new Phrase(emp_address));
			 my_report_table.addCell(table_Cell);
			 String emp_age=query_set.getString("age");
			 table_Cell=new PdfPCell(new Phrase(emp_age));
			 my_report_table.addCell(table_Cell);
		 }
		 /*Attach report table tp PDF*/
		 my_pdf_report.add(my_report_table);
		 my_pdf_report.close();
		 /*Close all Db related objects*/
		 query_set.close();
		 stmt.close();
		 conn.close();
		System.out.println("Done");
	}

}
