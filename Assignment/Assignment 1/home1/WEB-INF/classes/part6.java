import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.text.MessageFormat;


public class part6 extends HttpServlet{
    
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Part</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p><h3>Part6:  </h3>");
        


        Map<String,String[]> map = request.getParameterMap();
        for(String key: map.keySet()){
            out.print("Your children's names are  =  ");
            out.write("<br/>");
            for(int i = 0; i < map.get(key).length; i++){
                out.print(map.get(key)[i] +" ");
                out.write("<br/>");
            }
           out.write("<br/>");
        }

        out.println("</body>");
        out.println("</html>");
    }
    
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        response.setHeader("content-type", "text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();
        
        if( request.getParameter("numchild") != null){
            String numchild = request.getParameter("numchild");
            request.setAttribute("num", numchild);
        
            response.sendRedirect("/home1/part6.html?num="+numchild);
        }
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Part</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<p><h3>Part6:  </h3>");
        out.println("<form method = 'GET' action = 'child.do' >");
        out.print("<p align='center'>How many children do you have?<input  type='text' name = 'numchild' /> </br></p>");
        
        out.println(" <p align='center'><input type='submit' name='submit' value='Submit Querry' />");
        out.println("</form>");
       
        
        
        out.println("</body>");
        out.println("</html>");
        
       
        
    }
    
}
