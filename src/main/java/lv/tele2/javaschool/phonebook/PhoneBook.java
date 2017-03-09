package lv.tele2.javaschool.phonebook;

import asg.cliche.Command;
import asg.cliche.Param;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Dimitrijs Fedotovs <a href="http://www.bug.guru">www.bug.guru</a>
 * @version 1.0
 * @since 1.0
 */
public class PhoneBook implements Serializable{
    private static final long serialVersionUID=1L;

    private List<Record> recordList = new ArrayList<>();

    @Command(abbrev = "c", name = "create", description = "Creates new record")
    public void create(
            @Param(name = "name", description = "Record's name") String name,
            @Param(name = "phone", description = "Phone number") String... phone) {
        Record r = new Record(name, phone);
        recordList.add(r);
    }

    @Command(abbrev = "l", name = "list", description = "Lists all records")
    public List<Record> list() {
        return recordList;
    }

}
