package homework_20.services;

import homework_20.entity.Chocolate;
import homework_20.entity.TypeAction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static homework_20.entity.TypeAction.SAVE;
import static homework_20.entity.TypeAction.UPDATE;

public class ChocolateServiceImpl implements ChocolateService {

    private Connection connection;
    private ChocolateValidator validator;

    public static final String SAVE_CHOCOLATE = "insert into chocolates (brand, name, weight, id) values(?, ?, ?, ?)";
    public static final String GET_ID = "select max(id)+1 as id from chocolates";
    public static final String UPDATE_CHOCOLATE = "update chocolates set brand = ?,name = ?, weight = ? where id = ?";

    public ChocolateServiceImpl(Connection connection, ChocolateValidator validator) {
        this.connection = connection;
        this.validator = validator;
    }

    @Override
    public void save(Chocolate chocolate) {
        prepareAndExecuteStatement(SAVE, chocolate);
    }

    @Override
    public Chocolate get(Integer id) {
        Chocolate chocolate = null;
        if (id != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(
                        "select * from chocolates where id = ?");
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    chocolate = createChocolate(resultSet);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return chocolate;
    }

    @Override
    public List<Chocolate> getAll() {
        List<Chocolate> chocolates = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from chocolates");
            chocolates = getListFromResultSet(preparedStatement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return chocolates;
    }

    @Override
    public List<Chocolate> getByBrand(Chocolate.Brand brand) {
        List<Chocolate> chocolates = null;
        if (brand != null) {
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("select * from chocolates where brand = ?");
                preparedStatement.setString(1, brand.name());
                chocolates = getListFromResultSet(preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return chocolates;
    }

    @Override
    public void delete(Integer id) {
        try {
            Statement statement = connection.createStatement();
            statement.execute("delete from chocolates where id = " + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Chocolate chocolate) {
       prepareAndExecuteStatement(UPDATE,chocolate);
    }

    private Chocolate createChocolate(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String number = resultSet.getString("name");
        String brand = resultSet.getString("brand");
        int weight = resultSet.getInt("weight");
        return new Chocolate(id, number, Chocolate.Brand.valueOf(brand), weight);
    }

    private List<Chocolate> getListFromResultSet(PreparedStatement preparedStatement) throws SQLException {
        List<Chocolate> chocolates = new ArrayList<>();
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            chocolates.add(createChocolate(resultSet));
        }
        return chocolates;
    }

    private void prepareAndExecuteStatement(TypeAction type, Chocolate chocolate) {
        validator.validate(chocolate, type);
        try {
            String query;
            int id = 0;
            if (type == SAVE) {
                query = SAVE_CHOCOLATE;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(GET_ID);
                if (resultSet.next()) {
                    id = resultSet.getInt("id");
                }
            } else {
                query = UPDATE_CHOCOLATE;
                id = chocolate.getId();
            }
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, chocolate.getBrand().name());
            preparedStatement.setString(2, chocolate.getName());
            preparedStatement.setInt(3, chocolate.getWeight());
            preparedStatement.setInt(4, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
