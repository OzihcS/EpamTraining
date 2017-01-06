package ua.nure.piontkovskyi.Practice10.task4;

import ua.nure.piontkovskyi.Practice10.task4.entity.Role;
import ua.nure.piontkovskyi.Practice10.task4.entity.User;

import java.sql.*;

public class DBManager {

    private static DBManager instance;

    private static final String SQL_FIND_USER_BY_LOGIN_AND_PASSWORD = "SELECT * FROM users WHERE login=? AND pass=?";
    private static final String SQL_FIND_ROLE_BY_ID = "SELECT * FROM roles WHERE id=?";
    private static final String SQL_UPDATE_USER = "UPDATE users SET name=? WHERE login=?";

    private DBManager() {
    }

    public static synchronized DBManager getInstance() {
        if (instance == null) {
            instance = new DBManager();
        }
        return instance;
    }

    public Connection getConnection() throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        return DriverManager.getConnection("jdbc:mysql://localhost/rolesDB?useSSL=true", "root", "123A456B");
    }

    public Role getRoleById(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_FIND_ROLE_BY_ID);
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Role(id, rs.getString("name"));
            }
        } catch (SQLException ex) {
            System.out.println("Can't get Role");
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access:" + e.getMessage());
        } catch (InstantiationException e) {
            System.out.println("InstantiationException:" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }
        return null;
    }

    public User getUserByLoginAndPassword(String login, String pass) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        User user = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_FIND_USER_BY_LOGIN_AND_PASSWORD);
            pstmt.setString(1, login);
            pstmt.setString(2, pass);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setLogin(login);
                user.setName(rs.getString("name"));
                user.setPassword(pass);
                user.setRole(getRoleById(rs.getInt("role_id")));
            }
        } catch (SQLException ex) {
            System.out.println("Can't get User");
        } catch (IllegalAccessException e) {
            System.out.println("Illegal access:" + e.getMessage());
        } catch (InstantiationException e) {
            System.out.println("InstantiationException:" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }
        return user;
    }

    public boolean renameUser(User user) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            pstmt = con.prepareStatement(SQL_UPDATE_USER);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getLogin());
            if (pstmt.executeUpdate() > 0) {
                return true;
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            close(rs, pstmt, con);
        }
        return false;
    }

    private void close(ResultSet rs, Statement stmt, Connection con) {
        close(rs);
        close(stmt);
        close(con);
    }

    private void close(Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException ex) {
            System.out.println("Cannot close a connection");
        }
    }

    private void close(Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        } catch (SQLException ex) {
            System.out.println("Cannot close a statement");
        }
    }

    private void close(ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException ex) {
            System.out.println("Cannot close a result set");
        }
    }

}
