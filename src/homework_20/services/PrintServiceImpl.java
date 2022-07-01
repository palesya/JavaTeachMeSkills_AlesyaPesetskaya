package homework_20.services;

import homework_20.entity.Chocolate;

import java.util.List;

public class PrintServiceImpl implements PrintService{

    @Override
    public void getAllAndPrint(ChocolateServiceImpl chocolateService) {
        List<Chocolate> all = chocolateService.getAll();
        for (Chocolate el : all) {
            System.out.println(el);
        }
        System.out.println();
    }

    @Override
    public void print(List<Chocolate> chocolates) {
        for (Chocolate el : chocolates) {
            System.out.println(el);;
        }
        System.out.println();
    }

}
