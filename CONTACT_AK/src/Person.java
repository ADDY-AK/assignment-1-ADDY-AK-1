class Person {
    private String FirstName;
    private String LastName;
    private String eMail;
    private String Number;

    public Person(String FirstName, String LastName, String eMail, String Number) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.eMail = eMail;
        this.Number = Number;
    }

    public String getFirstName() {
        return this.FirstName;
    }

    public void setFirstName(String firstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return this.LastName;
    }

    public void setLastName(String lastName) {
        this.LastName = LastName;
    }

    public String geteMail() {
        return this.eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getNumber() {
        return this.Number;
    }

    public void setNumber(String number) {
        this.Number = Number;
    }
}
