package homework_20.services;

import homework_20.entity.Chocolate;

import java.util.List;

public interface PrintService {

    void getAllAndPrint(ChocolateServiceImpl chocolateService);

    void print(List<Chocolate> chocolates);

}
