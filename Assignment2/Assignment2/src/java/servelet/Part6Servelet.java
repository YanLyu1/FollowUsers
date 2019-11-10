package servelet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author root
 */
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.*;
import javax.servlet.http.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;

public class Part6Servelet extends  HttpServlet {
    
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        ArrayList<StringBuffer> list = new ArrayList<>();
        String path = "/Library/store.xls";
        File file = new File(path);
        //HttpSession session = request.getSession();
        String redirectPage = null;
        //判断文件是否存在
        if (file.isFile() && file.exists()) {
            String[] split = file.getName().split("\\.");
            Workbook wb = null;
            if ("xls".equals(split[1])) {
                FileInputStream inputStream = new FileInputStream(file);
                wb = new HSSFWorkbook(inputStream);
            }else if ("xlsx".equals(split[1])){
                try {
                    wb = new XSSFWorkbook(file);
                } catch (InvalidFormatException ex) {
                    Logger.getLogger(Part6Servelet.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else {
                System.out.println("文件类型错误");
            }

            int sheetNumber = wb.getNumberOfSheets();
            //开始解析
            for(int sheetIndex = 0; sheetIndex < sheetNumber; sheetIndex++){
                Sheet sheet = wb.getSheetAt(sheetIndex);
                //第一行是列名，所以从第二行开始遍历
                int firstRowNum = sheet.getFirstRowNum() + 1;
                int lastRowNum = sheet.getLastRowNum();
                //遍历行
                for (int rIndex = firstRowNum; rIndex <= lastRowNum; rIndex++) {
                    //StringBuffer sb = new StringBuffer();
                    Map map =new HashMap();
                    //获取当前行的内容
                    Row row = sheet.getRow(rIndex);
                    StringBuffer sb = new StringBuffer();
                    if (row != null) {
                        int first = row.getFirstCellNum();
                        int last = row.getLastCellNum();
                        for (int i = first; i < last; i++) {
                            row.getCell(i).setCellType(CellType.STRING);
                            //获取单元格的值
                            String value = row.getCell(i).getStringCellValue();
                            sb.append(value);
                            sb.append(" ");
                        }
                    }
                    list.add(sb);
                }
            }
        }
        request.setAttribute("list", list);
        redirectPage = "./part6Results.jsp";
        request.getRequestDispatcher(redirectPage).forward(request,response);
    }
}
