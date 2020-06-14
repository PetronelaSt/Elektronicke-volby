package sk.upjs.nelinocka.elektronicke_volby;

import java.io.Serializable;

public class Candidate implements Serializable {
    public String name;
    public String politicalParty;
    public int age;
    public String info;

    public Candidate() {

    }

    public Candidate(String name, String politicalParty) {
        this.name = name;
        this.politicalParty = politicalParty;
    }

    public Candidate(String name, String politicalParty, int age, String info) {
        this.name = name;
        this.politicalParty = politicalParty;
        this.age = age;
        this.info = info;
    }

    public String getCandidateName() {
        return name;
    }

    public void setCandidateName(String name) {
        this.name = name;
    }

    public int getCandidateAge() {
        return age;
    }

    public void setCandidateAge(int candidateAge) {
        this.age = candidateAge;
    }

    public String getInfo() {
        return info;
    }

    public void setCandidateInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return this.name + " " + this.age + " " + this.politicalParty + " " + this.info;
    }

    public String getCandidatePoliticalParty() {
        return politicalParty;
    }
}
