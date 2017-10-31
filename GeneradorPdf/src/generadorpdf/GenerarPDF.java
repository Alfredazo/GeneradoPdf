/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorpdf;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import static javafx.scene.text.Font.font;

/**
 *
 * @author MCISITLUG
 */
public class GenerarPDF {
    
    private Font fuenteBold = new Font(Font.FontFamily.COURIER,12,Font.BOLD);
    private Font fuenteNormal = new Font(Font.FontFamily.COURIER,12,Font.NORMAL);
    private Font fuenteItalic = new Font(Font.FontFamily.COURIER,14,Font.ITALIC);
    
    
    
    public void generarPDF(String header,String info,String footer,String rutaImagen,
            String salida,String codigo){
        try {
            Document document = new Document(PageSize.A7,36,36,10,10);
            PdfWriter pw = PdfWriter.getInstance(document,new FileOutputStream(salida));
            document.open();
            document.add(getHeader(header));
            Image imagen=Image.getInstance(rutaImagen);
            imagen.scaleAbsolute(50, 50);
            imagen.setAlignment(Element.ALIGN_CENTER);
            document.add(imagen);
            document.add(getInfo(info));
            document.add(getInfo(""));
            document.add(getInfo(""));
            document.add(getInfo(""));
            document.add(getBarcode(document,pw,codigo));
            document.add(getInfo(""));
            document.add(getFooter(footer));
            document.close();
            
         
            
            
        } catch (Exception e) {
        }
         
        
        
        
        }
    
    private  Paragraph getHeader(String texto){
    
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_CENTER);
        c.append(texto);
        c.setFont(fuenteBold);
        p.add(c);
        return p;
    }

     private  Paragraph getInfo(String texto){
    
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_JUSTIFIED_ALL);
        c.append(texto);
        c.setFont(fuenteNormal);
        p.add(c);
        return p;
    }

    
    
     private  Paragraph getFooter(String texto){
    
        Paragraph p = new Paragraph();
        Chunk c = new Chunk();
        p.setAlignment(Element.ALIGN_RIGHT);
        c.append(texto);
        c.setFont(fuenteItalic);
        p.add(c);
        return p;
    }

    
     private Image getBarcode(Document document,PdfWriter pw,String codigo){
     
     PdfContentByte cimg=pw.getDirectContent();
     Barcode128 code128=new Barcode128();
     code128.setCode(formatearCodigo(codigo));
     code128.setCodeType(Barcode.CODE128);
     code128.setTextAlignment(Element.ALIGN_CENTER);
     
    Image image = code128.createImageWithBarcode(cimg, BaseColor.BLACK, BaseColor.BLACK);
    float scaler = ((document.getPageSize().getWidth() - document.leftMargin()- document.rightMargin()-0)/image.getWidth()*60);
    image.scalePercent(scaler);
    image.setAlignment(Element.ALIGN_CENTER);
    return image;
     
     
     }
     
     private String formatearCodigo(String num){
         
         NumberFormat form = new DecimalFormat("0000000");
         return form.format((num != null)? Integer.parseInt(num) : 0000000);
     
     
     }
     
     
     
     
     
     
}
