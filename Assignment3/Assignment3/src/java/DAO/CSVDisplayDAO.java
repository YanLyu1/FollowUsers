package DAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import Pojo.FileObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author root
 */
public class CSVDisplayDAO {
    DAO_CSV dao;
    Connection connection;
    Statement stmt;
    ResultSet results;
    String query;
    
    public CSVDisplayDAO() throws SQLException{
        dao = new DAO_CSV();
        connection = dao.getConnection();
        stmt = connection.createStatement();
    }
    public ArrayList<FileObject> query(String fileName) throws SQLException{
        ArrayList<FileObject> list = new ArrayList<>();
        query = "SELECT * FROM " + fileName;
        results = stmt.executeQuery(query);
        //ResultSetMetaData rsmd = results.getMetaData();
        //int colCount = rsmd.getColumnCount();
        
        while(results.next()){
            FileObject fo = new FileObject();
            //ArrayList<String> sb = new ArrayList<>();
            fo.setSalesOrderID(Integer.parseInt(results.getString(1)));
            fo.setRevisionNumber(Integer.parseInt(results.getString(2)));
            fo.setOrderDate(results.getString(3));
            fo.setDueDate(results.getString(4));
            fo.setShipDate(results.getString(5));
            fo.setStatus(Integer.parseInt(results.getString(6)));
            fo.setOnlineOrderFlag(Integer.parseInt(results.getString(7)));
            fo.setSalesOrderNumber(results.getString(8));
            fo.setPurchaseOrderNumber(results.getString(9));
            fo.setAccountNumber(results.getString(10));
            fo.setCustomerID(Integer.parseInt(results.getString(11)));
            fo.setSalesPersonID(results.getString(12));
            fo.setTerritoryID(Integer.parseInt(results.getString(13)));
            fo.setBillToAddressID(Integer.parseInt(results.getString(14)));
            fo.setShipToAddressID(Integer.parseInt(results.getString(15)));
            fo.setShipMethodID(Integer.parseInt(results.getString(16)));
            fo.setCreditCardID(results.getString(17));
            fo.setCreditCardApprovalCode(results.getString(18));
            fo.setCurrencyRateID(results.getString(19));
            fo.setSubTotal(Float.parseFloat(results.getString(20)));
            fo.setTaxAmt(Float.parseFloat(results.getString(21)));
            fo.setFreight(Float.parseFloat(results.getString(22)));
            fo.setTotalDue(Float.parseFloat(results.getString(23)));
            fo.setComment(results.getString(24));
            fo.setModifiedDate(results.getString(5));
//            for(int j = 1; j <= colCount; j++){
//                //sb.add(results.getString(j));
//                sb.append(results.getString(j));
//                sb.append(" ");
//            }
            list.add(fo);
        }
        
        try {
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                dao.close();
            }
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
    return list;
    }
}
