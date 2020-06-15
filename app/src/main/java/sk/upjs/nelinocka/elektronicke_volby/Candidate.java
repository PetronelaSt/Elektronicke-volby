package sk.upjs.nelinocka.elektronicke_volby;

import java.io.Serializable;

public class Candidate implements Serializable {
    public String meno;
    public String strana;
    public int vek;
    public String info;

    public Candidate() {

    }

    public Candidate(String meno, String strana) {
        this.meno = meno;
        this.strana = strana;
    }

    public Candidate(String meno, String strana, int vek, String info) {
        this.meno = meno;
        this.strana = strana;
        this.vek = vek;
        this.info = info;
    }

    public String getCandidateName() {
        return meno;
    }

    public void setCandidateName(String name) {
        this.meno = meno;
    }

    public int getCandidateAge() {
        return vek;
    }

    public void setCandidateAge(int candidateAge) {
        this.vek = candidateAge;
    }

    public String getInfo() {
        return info;
    }

    public void setCandidateInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return this.meno + " " + this.vek + " " + this.strana + " " + this.info;
    }

    public String getCandidatePoliticalParty() {
        return strana;
    }
}
