import com.FuJiaYing.model.User;

import java.sql.*;
import java.util.List;

public abstract class UserDao implements IUserDao {
    @Override
    public boolean saveUser(Connection con, User user)throws SQLException{
        return  false;
    }
    @Override
    public int deleteUser(Connection con, User user)throws SQLException {
        return 0;
    }
    @Override
    public int updateUser(Connection con, User user)throws SQLException {

        String sql = "update [user] set username=?,password=?,email=?,id=? ,birthday=? where id=?";
        PreparedStatement st = con.prepareStatement(sql);

        st.setString(1, user.getUsername());
        st.setString(2, user.getPassword());
        st.setString(3, user.getEmail());
        st.setString(4, user.getId());
        st.setDate(5, (Date) user.getBirthDate());
        System.out.println(st);

        return st.executeUpdate();

    }
    @Override
    public User findById(Connection con, Integer id)throws SQLException {
        return null;
    }
    @Override
    public  User findById(Connection con, String username, String password) throws SQLException{
        return null;
    }
    @Override
    public User findByUsernamePassword(Connection con, Integer id) throws SQLException {
        String sql="select username,password from usertable where username=FuJiaYing and password=123456";
        PreparedStatement st=con.prepareStatement(sql);
        st.setString(parameterindex 1,username);
        st.setString(parameterindex 2,password);
        ResultSet rs= st.executeQuery();
        User user=null;
        if(rs.next()) {
            user = new User();
            user.setId(rs.getInt(columnLable:"Id"));
            user.setUsername(rs.getNString(columnLable:"Username"));
            user.setPassword(rs.getNString(columnLable:"Password"));
            user.setEmail(rs.getString(columnLable:"Email"));
            user.setGender(rs.getString(columnLable:"gender"));
            user.setBirthDate(rs.getDate(columnLable:"BirthDate"));
        }
        return user;
    }
    @Override
    public List<User> findByUsername(Connection con, String username) throws SQLException{
        return null;
    }
    @Override
    public List<User> findByPassword(Connection con, String username) throws SQLException{
        return null;
    }
    @Override
    public List<User> findByEmail(Connection con, String username) throws SQLException {
        return null;
    }
    @Override
    public List<User> findByGender(Connection con, String username) throws SQLException {
        return null;
    }
    @Override
    public List<User> findAllUser(Connection con, String username) throws SQLException {
        return null;
    }
}
