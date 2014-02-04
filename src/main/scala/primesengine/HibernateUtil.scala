package primesengine

import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration

object HibernateUtil {

  def sessionFactory: SessionFactory = {
    try {
      // Create the SessionFactory from hibernate.cfg.xml
      new Configuration().configure().buildSessionFactory();
    } catch {
      case ex:Throwable => 
        System.err.println("Initial SessionFactory creation failed." + ex)
        throw new ExceptionInInitializerError(ex)
    }
  }

}