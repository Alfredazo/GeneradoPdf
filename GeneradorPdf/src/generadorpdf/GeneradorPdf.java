/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package generadorpdf;

/**
 *
 * @author MCISITLUG
 */
public class GeneradorPdf {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        GenerarPDF g = new GenerarPDF();
        g.generarPDF("Cupon de Descuento","Pagina Mis Ofertas","Valido hasta 11/11/11","C:\\Users\\Luciano\\Desktop\\lo.png","C:\\Users\\Luciano\\Desktop\\prueba.pdf","1234567");
    }
    
}
