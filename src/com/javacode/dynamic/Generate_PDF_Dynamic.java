package com.javacode.dynamic;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Generate_PDF_Dynamic {

	public static void main(String[] args) {
		try {
			String file_name="F:\\pdf\\test.pdf";
			Document document=new Document();
			PdfWriter.getInstance(document, new FileOutputStream(file_name));
			document.open();
			DBConnection onJDBConnection=new DBConnection();
			Connection connection=onJDBConnection.getConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			PdfPTable table=new PdfPTable(5);
			PdfPCell c1=new PdfPCell(new Phrase("Id"));
			table.addCell(c1);
		    c1=new PdfPCell(new Phrase("First Name"));
		    table.addCell(c1);
		    c1=new PdfPCell(new Phrase("Last Name"));
			table.addCell(c1);
			c1=new PdfPCell(new Phrase("Address"));
			table.addCell(c1);
			c1=new PdfPCell(new Phrase("age"));
			table.addCell(c1);
			//document.add(table);
			String query="select * from employee";
			ps=connection.prepareStatement(query);
			rs=ps.executeQuery();
			while(rs.next()){
			    Paragraph para=new Paragraph();
				document.add(para);
				document.add(new Paragraph(" "));
				table.setHeaderRows(5);
				table.addCell(rs.getString("id"));
				table.addCell(rs.getString("fname"));
				table.addCell(rs.getString("lname"));
				table.addCell(rs.getString("address"));
				table.addCell(rs.getString("age"));
			    document.add(table);
			    
			}
			
			System.out.println("Done");
			document.close();
		}
		catch(Exception e) {
			System.err.println(e);
		}
 
	}

}
