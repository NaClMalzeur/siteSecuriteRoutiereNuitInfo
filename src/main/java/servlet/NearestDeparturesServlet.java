/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import Entitys.LatLng;
import Entitys.Place;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.DAO;
import modele.DataSourceFactory;
import modele.SortPlacesByCurrentLocation;

/**
 *
 * @author Ehsan
 */
@WebServlet(name = "NearestDeparturesServlet", urlPatterns = {"/NearestDeparturesServlet"})
public class NearestDeparturesServlet extends HttpServlet {

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
        DAO dao;
        try {
            dao = new DAO(DataSourceFactory.getDataSource());
            System.out.println("bnjor");
//String lat = request.getParameter("lat");
            String lat = "43.93333";
            String lon = "2.15";
//String lon = request.getParameter("long");
            double lat_double = Double.parseDouble(lat);
            double lon_double = Double.parseDouble(lon);
            LatLng current_latlng = new LatLng(lat_double, lon_double);
            Place current_place = new Place("moi", current_latlng);
//ArrayList<Place> result_list = dao.getNearestPlaces(current_place, 30.00);
            ArrayList<Place> list;
            try {
                list = dao.getAllTrajet();
                list = SortPlacesByCurrentLocation.sort(current_place, list);

//        ArrayList<Place> places = new ArrayList<Place>();
//        places.add(new Place("Albi", new LatLng(43.933333, 2.15)));
//        places.add(new Place("La pougeterie", new LatLng(43.904819, 1.971359)));
//        places.add(new Place("Lombers", new LatLng(43.809756, 2.103195)));
//        places.add(new Place("Toulouse", new LatLng(43.602273, 1.434402)));
                try (PrintWriter out = response.getWriter()) {
                    response.setContentType("application/json;charset=ANSI");

                    Gson gson = new Gson();
                    String gsonData = gson.toJson(list);
                    //on affiche la collection dans la console pour vérifier

                    out.println(gsonData);
                }
            } catch (SQLException ex) {
                Logger.getLogger(NearestDeparturesServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NearestDeparturesServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

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
