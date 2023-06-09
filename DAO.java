package StepProject;

import java.util.HashMap;

public interface DAO<A extends Identifable> {

  void save(A a) throws Exception;

  A load(int id) throws Exception;

  void delete(int id) throws Exception;

  default void delete(A a) throws Exception {
    delete(a.id());
  }
  public A loadAll(String name) throws Exception;
}
