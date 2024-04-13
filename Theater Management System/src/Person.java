public class Person {
    private String names;
    private String surNames;
    private String eMails;

    public Person() {
    }

    public Person(String names, String surNames, String eMails) {
        this.names = names;
        this.surNames = surNames;
        this.eMails = eMails;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getSurNames() {
        return surNames;
    }

    public void setSurNames(String surNames) {
        this.surNames = surNames;
    }

    public String geteMails() {
        return eMails;
    }

    public void seteMails(String eMails) {
        this.eMails = eMails;
    }
}
