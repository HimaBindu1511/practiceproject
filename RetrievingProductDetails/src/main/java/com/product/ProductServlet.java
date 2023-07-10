package com.product;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    String DB_URL = "jdbc:mysql://localhost:3306/productddetails";
    String DB_USER = "root";
    String DB_PASSWORD = "Divya@112531";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Get the product ID from the request parameter
        String productId = request.getParameter("product_ID"); // Updated parameter name

        // Initialize the database connection and prepared statement
        Connection conn = null;
        PreparedStatement stmt = null;

        // Create a PrintWriter to write the response
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try {
            // Load the JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the database connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/productddetails","root","Divya@112531");


            // Prepare the SQL query to retrieve product details using the product ID
            String sql = "SELECT * FROM product WHERE product_ID = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, productId);

            // Execute the query and retrieve the result set
            ResultSet rs = stmt.executeQuery();

            // Check if the product is found
            if (rs.next()) {
                int productID = rs.getInt("product_ID");
                String productName = rs.getString("product_Name");
                double productPrice = rs.getDouble("product_Price");
                String productDescription = rs.getString("product_Description");

                // Display the product details
                out.println("<h2>Product Details:</h2>");
                out.println("<p>Product ID: " + productID + "</p>");
                out.println("<p>Product Name: " + productName + "</p>");
                out.println("<p>Product Price: " + productPrice + "</p>");
                out.println("<p>Product Description: " + productDescription + "</p>");
            } else {
                // Product not found, display an error message
                out.println("<h2>Error:</h2>");
                out.println("<p>Product not found.</p>");
            }

            // Close the result set, statement, and connection
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            // Handle any errors that occur during the database connection or query execution
            out.println("<h2>Error:</h2>");
            out.println("<p>Failed to retrieve product details.</p>");
        } finally {
            out.close();
        }
    }

	}


