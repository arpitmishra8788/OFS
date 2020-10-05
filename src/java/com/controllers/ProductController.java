/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controllers;

import com.beans.Category;
import com.beans.Product;
import com.beans.WearType;
import com.daos.ProductDao;
import com.utilities.FileUploader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author Arpit mishra
 */
public class ProductController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String op = request.getParameter("op");
        //System.out.println("hello");
        if (op != null && op.equalsIgnoreCase("delete")) {
            int id = Integer.parseInt(request.getParameter("id"));
            ProductDao pd = new ProductDao();
            if (pd.removeById(id)){
                response.sendRedirect("admin/allProducts.jsp");
            }
        }
    }
        @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");

        String op = request.getParameter("op");
        if (op != null && op.equalsIgnoreCase("add")) {
            
             try {
                //check the enctype of the incomming request -
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                String encodedPassword = "";
                String photo = "", imagePath = "";
                if (isMultipart) {
                    imagePath = FileUploader.getUploadedPath(getServletContext(), "shopkeeper/media/product", request);
                }
            HttpSession session = request.getSession();
            Product product = (Product) session.getAttribute("product");
            WearType weartype = (WearType) session.getAttribute("weartype");
            Category category = (Category) session.getAttribute("category");
            ProductDao pd = new ProductDao();
            System.out.println("Beans received product " + product);
            System.out.println("wear name=" + weartype.getId());
            System.out.println("cat name=" + category.getId());

            product.setImage(imagePath);
            if (pd.addProduct(product, weartype.getId(), category.getId())) {
                out.println("Product Saved");
                session.removeAttribute("product");
                session.removeAttribute("weartype");
                session.removeAttribute("cate");
            }
        }
              catch(Exception e){}

     
    }
    }
}
