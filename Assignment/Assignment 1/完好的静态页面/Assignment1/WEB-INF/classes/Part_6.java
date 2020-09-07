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
    "<HEAD><TITLE>" + title + 
    "</TITLE></HEAD>\n" + 
    "<BODY BGCOLOR=\"#FFCCCC\">\n" + 
    "<H1 ALIGN=\"CENTER\">" + title + 
    "</H1>\n" );
    out.println("<form method = 'post' action = 'number.html'>");
    out.println("How many children do you hava :" + "<input type = 'text' name = 'number'/>"+ "<br/>");
    out.println("<button type='submit'>" + "submit query" + "</button>");
    out.println("</form>");
    out.println("</BODY></HTML>"); 
    //response.sendRedirect("/number.jsp");
    //request.setAttribute("number", request.getParameter("number"));
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<HTML>");
        out.println("<HEAD><title>show information</title></HEAD>");
        out.println("<body bgcolor = '#FFCCCC'>");
        out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">\n" ); 
        out.println("<TR BGCOLOR=\"#CC3333\">\n");
        out.println("<TH>Items <TH>Your Information"); 
        Map<String, String[]> map=request.getParameterMap();    
        for (String name : map.keySet()) { 
            String[] values = map.get(name);
            
            for(String value : values){
                out.println("<TR><TD>" + name + "</TD>" + " <TD>" + String.valueOf(value) + "</TR>");
            }
        }
         
        out.println("</TABLE>\n</BODY></HTML>"); 
        out.println("</body></html>");
    } 
}

