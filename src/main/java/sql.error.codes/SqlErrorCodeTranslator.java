package sql.error.codes;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.DeadlockLoserDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;

import java.sql.SQLException;

public class SqlErrorCodeTranslator extends SQLErrorCodeSQLExceptionTranslator {
    protected DataAccessException errorTranslate(String task, String hsql, SQLException hsqlex) {
        if(hsqlex.getErrorCode() == -12345){
            return new DeadlockLoserDataAccessException(task, hsqlex);
       }
        return null;
    }
}
