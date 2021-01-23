package com.javacode.net;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Generate_PDF {
	public static void main(String[] args) {
		try {
		String file_name="F:\\pdf\\test.pdf";
		Document document=new Document();
		
		//simple paragraph
		PdfWriter.getInstance(document, new FileOutputStream(file_name));
		document.open();
		Paragraph para=new Paragraph("Employee Record");
		document.add(para);
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		document.add(new Paragraph(" "));
		
		//table
		PdfPTable table=new PdfPTable(3);
		PdfPCell c1=new PdfPCell(new Phrase("Heading 1"));
		table.addCell(c1);
	    c1=new PdfPCell(new Phrase("Heading 2"));
	    table.addCell(c1);
	    c1=new PdfPCell(new Phrase("Heading 3"));
		table.addCell(c1);
		table.setHeaderRows(1);
		table.addCell("Rabin");
		table.addCell("Sudha");
		table.addCell("Rohit");
		table.addCell("Karan");
		table.addCell("Deepak");
		table.addCell("Shyam");
		document.add(table);
		//add image in pdf
		document.add(Image.getInstance("F:\\pdf\\logo.png"));
		
		document.close();
		System.out.println("Done");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
