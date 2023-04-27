package StepProject;

import java.util.HashMap;
import java.util.Map;

public class DaoHashMap<A extends Identifable> implements DAO<A> {

  private final Map<Integer, A> mapFull = new HashMap<>();

  @Override
  public void save(A a) {
    mapFull.put(a.id(), a);
  }

  @Override
  public A load(int id) {
    return mapFull.get(id);
  }

  @Override
  public void delete(int id) {
    mapFull.remove(id);
  }

  @Override
  public A loadAll(String name) {
    return (A) mapFull;
  };
}
