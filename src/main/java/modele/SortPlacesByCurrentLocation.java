package modele;


import Entitys.LatLng;
import Entitys.Place;
import java.util.ArrayList;
import java.util.Collections;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author max
 */
public class SortPlacesByCurrentLocation {
    public static ArrayList<Place> sort(Place current_place, ArrayList<Place> list) {
        ArrayList<Place> sorted_list = list;
        LatLng current_latlng = current_place.getL();
        Collections.sort(sorted_list, new SortPlaces(current_latlng));
        return sorted_list;
    }
}
