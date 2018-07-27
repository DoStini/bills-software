package main;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.nio.charset.Charset;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;

public class PrinterService implements Printable{

	   @Override
	    public int print(Graphics g, PageFormat pf, int page)
	            throws PrinterException {
	        if (page > 0) { /* We have only one page, and 'page' is zero-based */
	            return NO_SUCH_PAGE;
	        }

	        /*
	         * User (0,0) is typically outside the imageable area, so we must
	         * translate by the X and Y values in the PageFormat to avoid clipping
	         */
	        Graphics2D g2d = (Graphics2D) g;
	        g2d.translate(pf.getImageableX(), pf.getImageableY());
	        /* Now we perform our rendering */

	        g.setFont(new Font("Roman", 0, 30));
	        g.drawString("Hello world !", 0, 10);

	        return PAGE_EXISTS;
	    }

	    public void printString(PrintService printer, String text) {

	        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
	    	
	        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();
	        
	        
	        
	        PrintService service = printer;

	        DocPrintJob job = service.createPrintJob();

	        try {

	            byte[] bytes;

	            // important for umlaut chars
	            bytes = text.getBytes(Charset.forName("UTF-8"));

	            Doc doc = new SimpleDoc(bytes, flavor, null);

	            
	            job.print(doc, null);

	        } catch (Exception e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }

	    }

	    public void printBytes(PrintService printer, byte[] bytes) {

	        DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
	        PrintRequestAttributeSet pras = new HashPrintRequestAttributeSet();

	        PrintService printService[] = PrintServiceLookup.lookupPrintServices(
	                flavor, pras);
	        PrintService service = printer;

	        DocPrintJob job = service.createPrintJob();

	        try {

	            Doc doc = new SimpleDoc(bytes, flavor, null);

	            job.print(doc, null);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
}
