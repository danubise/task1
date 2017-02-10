package youlook.model;

import javax.persistence.*;

@Entity
@Table(name = "processedLog")
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Transient
    private String message;

    private String str;
    private int digitCount;

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public int getDigitCount() {
        return digitCount;
    }

    public void setDigitCount(int digitCount) {
        this.digitCount = digitCount;
    }

    public Record(String str, int digitCount, String message) {
        this.str = str;
        this.digitCount = digitCount;
        this.message = message;
    }

    public Record() {
    }

    public String getMessage() {
        return message;
    }
}
