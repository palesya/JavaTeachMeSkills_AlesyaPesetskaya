package objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class CarContainer {

    private Map<Integer, Car> cars = new TreeMap<>();

    public CarContainer() {
    }

    public Map<Integer, Car> getCars() {
        return cars;
    }

    public void saveCar(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        int id;
        if(cars==null){
            id=1;
        }else{
            id=cars.size() + 1;
        }
        Car car = createCar(req);
        cars.put(id, car);
        writer.println("Id is generated automatically.\nCar with id = " + id + " was created: \n" + car);
    }

    public Car createCar(HttpServletRequest req) {
        String brand = req.getParameter("brand");
        String year = req.getParameter("year");
        String color = req.getParameter("color");
        return new Car(brand, year, color);
    }

    public int getIdFromRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        PrintWriter writer = resp.getWriter();
        int id = Integer.parseInt(req.getParameter("id"));
        if (cars.containsKey(id)) {
            writer.println("Car with id = " + id);
        } else {
            writer.println("Car with id = " + id + "\n was not found");
            id = -1;
        }
        return id;
    }

    public boolean checkIdInRequest(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        boolean isFound = true;
        if (req.getParameter("id") == null) {
            resp.getWriter().println("Id is not defined.");
            isFound = false;
        }
        return isFound;
    }

    @Override
    public String toString() {
        return "CarContainer{" +
                "cars=" + cars +
                '}';
    }
}
