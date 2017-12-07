/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modele.DAO;
import modele.DataSourceFactory;
import Entitys.LatLng;
import Entitys.Place;
import java.sql.SQLException;
import modele.DAOException;

/**
 *
 * @author max
 */
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
            throws ServletException, IOException, SQLException, DAOException {
        DAO dao = new DAO(DataSourceFactory.getDataSource());
        
            String lat = request.getParameter("lat");
            String lon = request.getParameter("long");
            double lat_double = Double.parseDouble(lat);
            double lon_double = Double.parseDouble(lon);
            LatLng current_latlng = new LatLng(lat_double,lon_double);
            Place current_place = new Place("moi",current_latlng);
            ArrayList<Place> result_list = dao.getNearestPlaces(current_place, 30.00);
            try (PrintWriter out = response.getWriter()) {
                response.setContentType("application/json;charset=ANSI");

                Gson gson = new Gson();
                String gsonData = gson.toJson(result_list);
                //on affiche la collection dans la console pour vérifier
                System.out.println(gsonData);
                out.println(gsonData);
            }
        }
    }