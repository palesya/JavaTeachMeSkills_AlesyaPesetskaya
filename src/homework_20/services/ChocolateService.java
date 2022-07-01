package homework_20.services;

import homework_20.entity.Chocolate;

import java.util.List;

public interface ChocolateService {

    void save(Chocolate chocolate);

    Chocolate get(Integer id);

    List<Chocolate> getAll();

    List<Chocolate> getByBrand(Chocolate.Brand brand);

    void delete(Integer id);

    void update(Chocolate chocolate);

}
