/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Entitys.AccidentsEntity;
import Entitys.Place;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.DAO;
import modele.DataSourceFactory;

/**
 *
 * @author Ehsan
 */
@WebServlet(name = "AccidentSurTrajet", urlPatterns = {"/AccidentSurTrajet"})
public class AccidentSurTrajet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
        try {
            DAO dao = new DAO(DataSourceFactory.getDataSource());
            
             String[] get = request.getParameterValues("json[]");
              ArrayList<Point2D.Float> pointstosend = new ArrayList<Point2D.Float>();
              List<AccidentsEntity> points = dao.listAccidents();

             for (String str : get) {
                 String[] xy = str.split(",");
                 float y = Float.valueOf(xy[0]);
                 float x = Float.valueOf(xy[1]);
                 Point2D.Float p = new Point2D.Float(x,y);
                 for (AccidentsEntity ac_point : points) {
  
                     if (distFrom(p,ac_point.getPoint())<500) {
                         pointstosend.add(ac_point.getPoint());
                     }
                 }
             }
             
             try (PrintWriter out = response.getWriter()) {
			// On spécifie que la servlet va générer du JSON
			
			// Générer du JSON
			// Gson gson = new Gson();
			// setPrettyPrinting pour que le JSON généré soit plus lisible
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			out.println(gson.toJson(pointstosend));
		}
             
             
             
             
            
             
            
        } catch (SQLException ex) {
            Logger.getLogger(AccidentSurTrajet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
       
        
    }

public int distFrom(Point2D.Float p1,Point2D.Float p2) {//float lat1, float lng1, float lat2, float lng2) {
    double earthRadius = 6371000; //meters
    double dLat = Math.toRadians(p2.y-p1.y);
    double dLng = Math.toRadians(p2.x-p1.x);
    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
               Math.cos(Math.toRadians(p1.y)) * Math.cos(Math.toRadians(p2.y)) *
               Math.sin(dLng/2) * Math.sin(dLng/2);
    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
    int dist = (int) (earthRadius * c);

    return dist;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
