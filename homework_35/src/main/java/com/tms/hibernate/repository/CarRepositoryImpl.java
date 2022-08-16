package com.tms.hibernate.repository;

import com.tms.hibernate.model.Car;
import com.tms.hibernate.model.Region;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Service
public class CarRepositoryImpl implements CarRepository {

    @Autowired
    private SessionFactory factory;

    @Override
    public void save(Car car) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        List<Region> regions = car.getRegions();
        if (regions!= null) {
            regions.forEach(session::save);
        }
        session.save(car);
        if (regions!= null) {
            car.setRegions(regions);
        }
        transaction.commit();
        session.close();
    }

    @Override
    public void remove(Integer id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Car carForDelete = session.get(Car.class, id);
        session.delete(carForDelete);
        transaction.commit();
        session.close();
    }

    @Override
    public void changeAvailability(Integer id) {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        Car carFromDB = session.get(Car.class, id);
        boolean available = carFromDB.isAvailable();
        carFromDB.setAvailable(!available);
        transaction.commit();
        session.close();
    }

    @Override
    public List<Car> getAllCars() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Car> query = builder.createQuery(Car.class);
        Root<Car> rootEntry = query.from(Car.class);
        CriteriaQuery<Car> all = query.select(rootEntry);
        TypedQuery<Car> allQuery = session.createQuery(all);
        List<Car> resultList = allQuery.getResultList();
        transaction.commit();
        return resultList;
    }

    @Override
    public List<Integer> getAllIds() {
        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();
        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Integer> criteriaQuery = builder.createQuery(Integer.class);
        Root<Car> root = criteriaQuery.from(Car.class);
        CriteriaQuery<Integer> id = criteriaQuery.select(root.get("id"));
        List<Integer> resultList = session.createQuery(id).getResultList();
        transaction.commit();
        return resultList;
    }

}
