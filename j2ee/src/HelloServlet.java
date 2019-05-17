import java.io.IOException;
import java.util.Date;
 
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class HelloServlet extends HttpServlet{
    public void init(ServletConfig config){
        System.out.println("init of Hello Servlet");
    }
 
    public void doGet(HttpServletRequest request, HttpServletResponse response){

         
        try {
        	response.setContentType("text/html; charset=UTF-8");
            response.getWriter().println("<h1>ÄãºÃServlet!</h1>");
            response.getWriter().println(new Date().toLocaleString());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
     
}