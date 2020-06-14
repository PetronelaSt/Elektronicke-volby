package sk.upjs.nelinocka.elektronicke_volby;

import java.io.Serializable;
import java.util.Objects;

public class NU_User implements Serializable {
    private String op;
    private String pin;
    private String kraj;
    private int hlasoval;

    public NU_User() {
        // empty constructor
    }

    public NU_User(String op, String pin, String kraj, int hlasoval) {
        this.op = op;
        this.pin = pin;
        this.kraj = kraj;
        this.hlasoval = hlasoval;
    }

    @Override
    public String toString() {
        return this.op + " " + this.pin + " " + this.kraj + " " + this.hlasoval;
    }
    // gettery a settery, hashCode() a equals()
}
