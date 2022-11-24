package com.br.api.Views;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class pdf {
	public static void gerarPDF() throws DocumentException, IOException {
		Document pdf = new Document();
		String name = "relatório.pdf";
		PdfWriter.getInstance(pdf,new FileOutputStream(name));
		pdf.open();
		
		Paragraph p = new Paragraph("DiscoLivraria do DUDU");
		p.setAlignment(1);
		pdf.add(p);
		p = new Paragraph ("Relatório Dos alugueis");
		pdf.add(p);
		p = new Paragraph(" ");
		pdf.add(p);
		pdf.close();
		Desktop.getDesktop().open(new File(name));
	}
		 public static void main(String[] args) {
			try {
				gerarPDF();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}