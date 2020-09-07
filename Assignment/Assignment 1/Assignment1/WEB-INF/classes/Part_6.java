import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*;

public class Part_6 extends HttpServlet { 

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    response.setContentType("text/html"); 
    PrintWriter out = response.getWriter(); 
    String title = " How many children"; 
    String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + 
    "Transitional//EN\">\n"; 
    out.println(docType + "<HTML>\n" + 
    "<HEAD><TITLE>" + title + "</TITLE>");
    //JS
    out.println("<script type='text/javascript' src='a.js'>");
    out.println("</script>");
    out.println("</HEAD>\n");
    out.println("<BODY BGCOLOR=\"#FFCCCC\">\n");
    out.println("<H1 ALIGN=\"CENTER\">" + title + "</H1>\n" );
    //form
    out.println("<form method = 'get' action = 'child.do'>");
    out.println("How many children do you hava ?" + "<input type = 'text' id='number' name = 'number'/>"+ "<br/>");
    out.println("<button onclick='myFunction()'>" + "submit query" + "</button>");
    out.println("</form>");
    out.println("</BODY></HTML>"); 
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD><title>show information</title></HEAD>");
        out.println("<body bgcolor = '#FFCCCC'>");
        out.println("<H1>Your children's names are:</H1>" + "<br>"); 
        Map<String, String[]> map=request.getParameterMap();    
        for (String name : map.keySet()) { 
            String[] values = map.get(name);
            for(String value : values){
                out.println( String.valueOf(value) + "<br>" + "<br>");
            }
        }
         
        out.println("</BODY></HTML>"); 
        out.println("</body></html>");
    } 
}

