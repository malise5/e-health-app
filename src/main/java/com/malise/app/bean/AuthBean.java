package com.malise.app.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import com.malise.app.model.entity.AuditLog;
import com.malise.app.model.entity.User;
import com.malise.app.utils.EncryptTextI;

@Stateless
@Remote
public class AuthBean implements AuthBeanI, Serializable {

  @PersistenceContext
  EntityManager em;

  @Inject
  private EncryptTextI hashText;

  @Inject
  private Event<AuditLog> logger;

  public User authenticate(User loginUser) throws SQLException {

    loginUser.setPassword(hashText.hash(loginUser.getPassword()));

    String jpql = "SELECT u FROM User u WHERE u.username = :username AND u.password = :password";
    Query query = em.createQuery(jpql, User.class);
    query.setParameter("username", loginUser.getUsername());
    query.setParameter("password", loginUser.getPassword());

    List<User> resultList = query.getResultList();

    if (!resultList.isEmpty()) {

      AuditLog log = new AuditLog();
      log.setLogDetails("User logged in at " + DateFormat.getDateTimeInstance().format(new Date()) + ", "
          + resultList.get(0).getUsername());

      logger.fire(log);

      return resultList.get(0);
    } else {
      return null; // User not found
    }

  }

}

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

// List<User> users = em.createQuery("FROM User u WHERE u.password=:password AND
// u.email=:email", User.class)
// .setParameter("password", loginUser.getPassword())
// .setParameter("email", loginUser.getEmail())
// .getResultList();