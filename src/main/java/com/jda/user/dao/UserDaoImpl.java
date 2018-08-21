package com.jda.user.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import com.jda.user.model.Login;
import com.jda.user.model.User;

public class UserDaoImpl implements UserDao 
{
  @Autowired
  private JdbcTemplate jdbcTemplate;
  public void register(User user) {
    String sql = "insert into user values(?,?,?,?,?)";
    jdbcTemplate.update(sql, new Object[] { user.getName(),user.getUsername(), generator(user.getPassword()), 
   user.getMobile(),"abc"});
    }
    public User validateUser(Login login) {
    String sql = "select * from user  where username='" + login.getUsername() +  "'";
    List<User> users = jdbcTemplate.query(sql, new UserMapper());
    return users.size() > 0 ? users.get(0) : null;
    }
    
    public User  validateUserName(String  username)
    {
   	 String sql = "select * from user where username ='"+username+"'" ;
   	 List<User> users = jdbcTemplate.query(sql, new UserMapper());
       return users.size() > 0 ? users.get(0) : null;
		
    }
   
    public void saveToken(String token, String username)
    {
   	 String sql = "update user set token = '"+token+"'  where username = '"+username+"'";
   	 jdbcTemplate.execute(sql);
   	 System.out.println("updated token");
   	 
    }
    public User getUserbyToken(String token) {
	 	   String sql = "select * from user where token='" + token 
	 	    + "'";
	 	    List<User> users = jdbcTemplate.query(sql, new UserMapper());
	 	    return users.size() > 0 ? users.get(0) : null;
	 	    }
    @Transactional
	   public void newPassword(String password,String token) {
	   	
	   	String sql="update user set password='"+generator(password) +"'  where token='"+token+"'";
	   	
			jdbcTemplate.update(sql);
			System.out.println("are atul ur password updated");
		}
	
    public String generator(String password) {

 		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(11);
 		String hashedPassword = passwordEncoder.encode(password);
 		System.out.println(hashedPassword);
 		return hashedPassword;

 	}
    
    
    
  class UserMapper implements RowMapper<User> {
  public User mapRow(ResultSet rs, int arg1) throws SQLException {
    User user = new User();
    user.setName(rs.getString("name"));
    user.setUsername(rs.getString("username"));
    user.setPassword(rs.getString("password"));
    
   
    
   
    user.setMobile(rs.getString("mobile"));
    user.setToken(rs.getString("token"));
    return user;
  }
}



@Override
public User findUserByEmail(String username) {
	// TODO Auto-generated method stub
	return null;
}


}
