/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorpdf;

import java.awt.Desktop;
import java.io.File;
import java.util.Calendar;

/**
 *
 * @author MCISITLUG
 */
public class GeneradorPdf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            GenerarPDF g = new GenerarPDF();
            Calendar fecha = Calendar.getInstance();
            String hola = fecha.getTime().toString();
            hola = hola.replace(" ", "");
            hola = hola.replace(":", "");
            System.out.println(hola);
            String nombreSistema = System.getProperty("user.name");
            System.out.println("Nombre Sistema: " + nombreSistema);

            String urlImagen = "C:\\Users\\" + nombreSistema + "\\Desktop\\GeneradoPdf\\GeneradorPdf\\src\\generadorpdf\\img\\Logo Mis ofertas.png";
            String urlGuardar = "C:\\Users\\" + nombreSistema + "\\Downloads\\" + hola;
            String formato = ".pdf";
            System.out.println("Ruta: " + urlImagen);
            g.generarPDF("***********************", "CUPON", "DESCUENTO", "Pagina Mis Ofertas", "Alimentos\nRopa\nLinea Blancan\nElectronica", "Valido hasta 11/11/11", urlImagen, urlGuardar + formato, "1234327");
            File path = new File(urlGuardar+formato);
            Desktop.getDesktop().open(path);
        } catch (Exception e) {

        }
    }

    
   

}
