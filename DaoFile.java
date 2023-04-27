package StepProject;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class DaoFile<A extends IdentifableSerializable> implements DAO<A> {

    private final File file;

    public DaoFile(File file) {
        this.file = file;
    }

    @Override
    public void save(A a) throws Exception {
        ArrayList<A> as;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            as = (ArrayList<A>) ois.readObject();
            ois.close();
        } catch (Exception x) {
            as = new ArrayList<>();
        }
        as.add(a);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(as);
        oos.close();
    }

    @Override
    public A load(int id) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<A> as = (ArrayList<A>) ois.readObject();
        ois.close();
        for (A a : as) {
            if (a.id() == id) return a;
        }
        throw new IllegalStateException(String.format("given id:%d not found", id));
    }

    @Override
    public void delete(int id) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<A> as = (ArrayList<A>) ois.readObject();
        ois.close();
        as.removeIf(a -> a.id() == id);
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(as);
        oos.close();
    }
    @Override
    public A loadAll(String name) throws Exception {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<A> as = (ArrayList<A>)ois.readObject();
        ois.close();
        for (A a: as) {
            System.out.println(a);
        }
        return null;
    }
}
