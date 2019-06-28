// For convenience, always static import your generated tables and
// jOOQ functions to decrease verbosity:

import lombok.extern.slf4j.Slf4j;
import org.jooq.*;
import org.jooq.impl.DSL;
import test.generated.tables.records.AuthorRecord;

import java.sql.Connection;
import java.sql.DriverManager;

import static org.jooq.impl.DSL.field;
import static org.jooq.impl.DSL.name;
import static org.jooq.impl.SQLDataType.VARCHAR;
import static test.generated.Tables.AUTHOR;

@Slf4j
public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String userName = "root";
        String password = "nopassword";
        String url = "jdbc:mysql://localhost:3306/library";

        // Connection is the only JDBC resource that we need
        // PreparedStatement and ResultSet are handled by jOOQ, internally
        try (Connection conn = DriverManager.getConnection(url, userName, password)) {
            DSLContext create = DSL.using(conn, SQLDialect.MYSQL);
            /*Read Operation*/
            Result<Record> result = create.
                                    select().
                                    from(AUTHOR).
//                                    where(AUTHOR.LAST_NAME.eq("zhang")).
                                    fetch();

            for (Record r : result) {
                Integer id = r.getValue(AUTHOR.ID);
                String firstName = r.getValue(AUTHOR.FIRST_NAME);
                String lastName = r.getValue(AUTHOR.LAST_NAME);

                log.info("ID: " + id + " first name: " + firstName + " last name: " + lastName);
            }


            /*Update Operation*/
            create.update(AUTHOR)
                .set(AUTHOR.FIRST_NAME, "Hermann")
                .set(AUTHOR.LAST_NAME, "Hesse")
                .where(AUTHOR.ID.eq(1))
                .execute();


            /*Delete Operation*/
            create.delete(AUTHOR)
                .where(AUTHOR.ID.eq(3))
                .execute();



            /*Create Operation*/
            create.insertInto(AUTHOR,
                AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
                .values(3, "Shenglei", "M")
                .execute();



        }

        // For the sake of this tutorial, let's keep exception handling simple
        catch (Exception e) {
            e.printStackTrace();
        }

        /*Create a qualified field, given its (qualified) field name.*/
        //try this later
        final String FIRST_NAME = "first_name";
        final Field<String> ID_FIELD = field(name(FIRST_NAME), VARCHAR);
        log.debug(ID_FIELD.toString());



    }
}