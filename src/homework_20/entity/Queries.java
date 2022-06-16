package homework_20.entity;

public enum Queries {

    SAVE_CHOCOLATE ("insert into chocolates (brand, name, weight, id) values(?, ?, ?, ?)"),
    GET_ID ("select max(id)+1 as id from chocolates;"),
    UPDATE_CHOCOLATE ("update chocolates set brand = ?,name = ?, weight = ? where id = ?"),
    SELECT_BY_ID ("select * from chocolates where id = ?"),
    SELECT_BY_BRAND ("select * from chocolates where brand = ?"),
    SELECT_ALL("select * from chocolates"),
    DELETE_BY_ID("delete from chocolates where id = ");

    public final String query;

    Queries(String query){
        this.query=query;
    }

}
