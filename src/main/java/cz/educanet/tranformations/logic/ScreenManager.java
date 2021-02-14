package cz.educanet.tranformations.logic;

import cz.educanet.tranformations.logic.models.Coordinate;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ScreenManager {

    private Set<Coordinate> selectedPoints = new HashSet<>();

    public void select(Coordinate coordinate) {
        selectedPoints.add(coordinate);
    }

    public void unselect(Coordinate coordinate) {
        selectedPoints.remove(coordinate);
    }

    public boolean isSelected(Coordinate coordinate) {
        return selectedPoints.contains(coordinate);
    }

    public Set<Coordinate> getSelectedPoints() {
        return selectedPoints;
    }

    public boolean isFilledIn(Coordinate coordinate) { // TODO: Implement this
        ArrayList<Coordinate> list = new ArrayList<>(selectedPoints);
        if(list.size()==3) return (jeVUhlu(list.get(2), list.get(1), list.get(0), coordinate)|| jeVUhlu(list.get(0), list.get(1), list.get(2), coordinate)) && (jeVUhlu(list.get(2), list.get(0), list.get(1), coordinate)|| jeVUhlu(list.get(1), list.get(0), list.get(2), coordinate));
        return false;
    }

    public static boolean jeVUhlu(Coordinate a, Coordinate b, Coordinate c, Coordinate bod) {
        return (((a.getX()-bod.getX())*(b.getY()-bod.getY())-(a.getY()- bod.getY())*(b.getX()- bod.getX()))>0) && !(((a.getX()-bod.getX())*(c.getY()-bod.getY())-(a.getY()- bod.getY())*(c.getX()- bod.getX()))>0);
    }
}