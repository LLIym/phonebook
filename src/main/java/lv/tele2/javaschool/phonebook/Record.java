package lv.tele2.javaschool.phonebook;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
public class Record implements Serializable{
    private static final long serialVersionUID=1L;
    private static int nextId = 1;

    private int id;
    private String name;
    private List<String> phoneList = new ArrayList<>();

    public Record() {
        this.id = nextId;
        nextId++;
    }

    public Record(String name, String... phones) {
        this();
        this.name = name;
        for (String p : phones) {
            this.phoneList.add(p);
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhoneList() {
        return phoneList;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", name=" + name + '\'' +
                ", phones=" + phoneList;
    }
}
