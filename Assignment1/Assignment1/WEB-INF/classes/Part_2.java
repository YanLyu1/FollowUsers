import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*;
/** Shows all the request headers sent on the current request. */
public class Part_2 extends HttpServlet { public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    response.setContentType("text/html"); 
    PrintWriter out = response.getWriter(); 
    String title = "Displays Request Headers"; 
    String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + 
    "Transitional//EN\">\n"; 
    out.println(docType + "<HTML>\n" + 
    "<HEAD><TITLE>" + title + 
    "</TITLE></HEAD>\n" + 
    "<BODY BGCOLOR=\"#FFCCCC\">\n" + 
    "<H1 ALIGN=\"CENTER\">" + title + 
    "</H1>\n" + 
    "<TABLE BORDER=1 ALIGN=\"CENTER\">\n" + 
    "<TR BGCOLOR=\"#CC3333\">\n" + 
    "<TH>Header Name<TH>Header Value"); 
    Enumeration headerNames = request.getHeaderNames(); 
    while(headerNames.hasMoreElements()) { 
        String headerName = (String)headerNames.nextElement(); 
        Enumeration headers = request.getHeaders(headerName);
        while(headers.hasMoreElements()){
            String value = (String)headers.nextElement();
            out.println("<TR><TD>" + headerName); 
            out.println(" <TD>" + value); 
        }
    } 
    out.println("</TABLE>\n</BODY></HTML>"); 
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        doGet(request, response); 
    } 
}