package com.malise.app.bean;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.malise.app.model.entity.User;
import com.malise.app.utils.EncryptSha256;
import com.malise.app.utils.EncryptTextI;
// import com.malise.database.MysqlDb;

@Stateless
@Remote
public class AuthBean implements AuthBeanI, Serializable {

  // @EJB
  // MysqlDb database;
  @PersistenceContext
  EntityManager em;

  @Inject
  private EncryptTextI hashText;

  public User authenticate(User loginUser) throws SQLException {

    loginUser.setPassword(hashText.hash(loginUser.getPassword()));

    // PreparedStatement statement = em.getConnection()
    // .prepareStatement("SELECT id,username from users WHERE username=? and
    // password=?");

    // statement.setString(1, loginUser.getUsername());
    // statement.setString(2, loginUser.getPassword());

    // ResultSet result = statement.executeQuery();

    // User user = new User();

    // while (result.next()) {
    // user.setId(result.getLong("id"));
    // user.setUsername(result.getString("username"));

    // System.out.println("=======================================================================");

    // System.out.println(result.getLong("id"));
    // System.out.println(result.getString("username"));
    // System.out.println("=======================================================================");

    // }

    // return user;

    String jpql = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
    Query query = em.createQuery(jpql, User.class);
    query.setParameter("username", loginUser.getUsername());
    query.setParameter("password", loginUser.getPassword());

    List<User> resultList = query.getResultList();

    if (!resultList.isEmpty()) {
      return resultList.get(0);
    } else {
      return null; // User not found
    }

  }

}
