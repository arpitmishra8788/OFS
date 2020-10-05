
package com.jdbc;
import java.sql.*;
import java.util.*;

public class ConnectionPool {
    static final int MAX_CONNECTIONS= 20;
    static Vector connections = null;
    static ConnectionPool instance = null;
    
    public synchronized void removeAllConnections(){
        try{
            if(connections==null){
                return;
            }
            int sz= connections.size();
            for(int i=0;i<sz;i++){
                Connection c= (Connection) connections.elementAt(i);
                c.close();
            }
            connections.removeAllElements();
            connections= null;
        }
        catch(SQLException sqlE){
            System.out.println(sqlE);
        }
    }
    
    public static synchronized ConnectionPool getInstance(){
        if(instance == null){
            instance = new ConnectionPool();
        }
        return instance;
    }
    
    public synchronized void initialize(){
        if(connections == null){
            try{
                String userName= "root";
                String password= "arpit";
                
                String url= "jdbc:mysql://localhost:3306/ofs";
                
                Class.forName("com.mysql.jdbc.Driver");
                
                connections = new Vector();
                int count = 0;
                while(count< MAX_CONNECTIONS){
                    Connection c=  DriverManager.getConnection(url, userName, password);
                    connections.addElement(c);
                    count++;
                }
            }
            catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
    }
    
    public synchronized Connection getConnection(){
        Connection c = null;
        if(connections ==  null){
            return null;
        }
        if(connections.size() > 0){
            c = (Connection) connections.elementAt(0);
            connections.removeElementAt(0);
        }
        return c;
    }
    
    public synchronized void putConnection(Connection c){
        connections.addElement(c);
        notifyAll();
    }
   
    public static void main(String[] args) {
        ConnectionPool p = ConnectionPool.getInstance();
        p.initialize();
        System.out.println("all is correct");
    }
    
}
