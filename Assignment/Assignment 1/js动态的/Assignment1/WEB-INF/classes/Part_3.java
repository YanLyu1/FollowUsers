import java.io.*; 
import javax.servlet.*; 
import javax.servlet.http.*; 
import java.util.*;

public class Part_3 extends HttpServlet { 
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
    response.setContentType("text/html"); 
    PrintWriter out = response.getWriter(); 
    String title = " Display information By Parameters"; 
    String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + 
    "Transitional//EN\">\n"; 
    out.println(docType + "<HTML>\n" + 
    "<HEAD><TITLE>" + title + 
    "</TITLE></HEAD>\n" + 
    "<BODY BGCOLOR=\"#FFCCCC\">\n" + 
    "<H1 ALIGN=\"CENTER\">" + title + 
    "</H1>\n" );
    out.println( "<form method = 'post' action = 'information.do'>");
    out.println("Email :" + "<input type = 'email' name = 'email'/>"+ "<br/>");
    out.println("Password :" + "<input type = 'password' name = 'password'/>"+ "<br/>");
    out.println("Confirma Password :" + "<input type = 'password' name = 'cPassword' />"+ "<br/>");
    out.println("Upload Your Picture :" + "<input type = 'file' name = 'picture' value = 'upload'/>" + "<br/>");
    out.println("Gender :" + "<input type = 'radio' name = 'gender' value='male' checked/> "+ "Male" +
        "<input type = 'radio' name = 'gender' value='female' checked />"+ "Female" + "<br/>");
    out.println("Select Country :" + "<select name = 'country'>"+
        "<option value ='UK'>" + "United Kingdom " + "</option>" + 
        "<option value ='US'>" + "United States" + "</option>" + 
        "</select>"+ "<br/>");
    out.println("Hobby :" + "<label>" + "<input type = 'checkbox' name = 'hobby' value = 'Cricket'>"+ "Cricket" + "</label>" +
        "<label>" + "<input type = 'checkbox' name = 'hobby' value = 'Football'>"+ "Football" + "</label>" + "<br/>");
    out.println("Address :" + "<input type = 'text' name = 'address'>"+ "<br/>"); 
    out.println("<input type='submit' value='submit'/>");
    out.println("</form>");
    out.println("</BODY></HTML>"); 
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String cPassword = request.getParameter("cPassword");
        String picture = request.getParameter("picture");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String[] hobbies = request.getParameterValues("hobby");
        String address = request.getParameter("address");

        out.println("<HTML>");
        out.println("<HEAD><title>show information</title></HEAD>");
        out.println("<body bgcolor = '#FFCCCC'>");
        out.println("<TABLE BORDER=1 ALIGN=\"CENTER\">\n" ); 
        out.println("<TR BGCOLOR=\"#CC3333\">\n");
        out.println("<TH>Items <TH>Your Information"); 
        out.println("<TR><TD>" + "Email" + "</TD>" + " <TD>" + email + "</TR>"); 
        out.println("<TR><TD>" + "Picture" + "</TD>" + " <TD>" + picture + "</TR>"); 
        out.println("<TR><TD>" + "Gender" + "</TD>" + " <TD>" + gender + "</TR>"); 
        out.println("<TR><TD>" + "Country" + "</TD>" + " <TD>" + country + "</TR>"); 
        for(String hobby : hobbies){
            out.println("<TR><TD>" + "Hobby" + "</TD>" + " <TD>" + hobby + "</TR>"); 
        }
        out.println("<TR><TD>" + "Address" + "</TD>" + " <TD>" + address + "</TR>"); 
        out.println("</TABLE>\n</BODY></HTML>"); 
        out.println("</body></html>");
    } 
}

