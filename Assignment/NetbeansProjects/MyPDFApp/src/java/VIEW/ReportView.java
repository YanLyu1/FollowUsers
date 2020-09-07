package VIEW;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTMLDocument;
import org.springframework.web.servlet.view.document.AbstractPdfView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
public class ReportView extends AbstractPdfView{

    /**
     *
     * @param map
     * @param pdfdoc
     * @param writer
     * @param hsr
     * @param hsr1
     * @throws Exception
     */
    @Override
    protected void buildPdfDocument(Map<String, Object> map, com.lowagie.text.Document pdfdoc, com.lowagie.text.pdf.PdfWriter writer, HttpServletRequest hsr, HttpServletResponse hsr1) throws Exception {
        Chunk c1 = new Chunk("chukn 1");
        Phrase p1 = new Phrase("phrase 1");
        Paragraph g1 = new Paragraph("graph q");
                
        pdfdoc.add(c1);
        pdfdoc.add(p1);
        pdfdoc.add(g1);
    }
}
