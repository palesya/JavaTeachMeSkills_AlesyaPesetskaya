package preparing;

public class iFillingImpl implements iFilling {

    @Override
    public void fillWithWater(Container container) {
        System.out.println(container.getClass().getName());
    }

}
