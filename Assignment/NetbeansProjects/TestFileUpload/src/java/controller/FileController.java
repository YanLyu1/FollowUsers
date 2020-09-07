package controller;
 
 
import com.jspsmart.upload.File;
import com.jspsmart.upload.SmartUpload;
import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.springframework.web.context.ServletConfigAware;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

 
public class FileController extends AbstractController implements ServletConfigAware{

    private ServletConfig servletConfig;
    
    public FileController() {
        
    }

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        SmartUpload mySmartUpload = new SmartUpload();
            String myFileName = "";
            String filename = ""; 
            String fileext = "";
            int filesize = 0;
            String trace = null;
            int number = 199;
            try{
                mySmartUpload.initialize(getServletConfig(), request, response);
                mySmartUpload.setMaxFileSize(1*512*1024);  
                mySmartUpload.setTotalMaxFileSize(1*1024*1024);  
                mySmartUpload.setDeniedFilesList("exe,bat");  
                mySmartUpload.upload();
                File myFile = mySmartUpload.getFiles().getFile(0);
                if (!myFile.isMissing()){
                    int t1;
                    myFileName = myFile.getFileName();
		    filename = myFileName.substring(0,myFileName.lastIndexOf('.'));
		    t1 = myFileName.lastIndexOf('.')+1;
		    fileext = myFileName.substring(t1,myFileName.length());
		    filesize = myFile.getSize();
		}
                trace= this.getServletContext().getRealPath("/")+"upload"+java.io.File.separator + myFileName;
//                myFile.saveAs(trace,SmartUpload.SAVE_PHYSICAL);
                number = mySmartUpload.save(trace);
                trace = "success";
                }catch(Exception e){
                    e.printStackTrace();
		}
            return new ModelAndView("index","message",number);
	}

    @Override
    public void setServletConfig(ServletConfig sc) {
        this.servletConfig = sc;
    }

    public ServletConfig getServletConfig() {
        return servletConfig;
    }

    public static String getMETHOD_GET() {
        return METHOD_GET;
    }

    public static String getMETHOD_HEAD() {
        return METHOD_HEAD;
    }

    public static String getMETHOD_POST() {
        return METHOD_POST;
    }

    public Log getLogger() {
        return logger;
    }
    
    
}