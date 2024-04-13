public class Ticket {
    private int row_num;
    private int seat_num;
    private double prices=0;
    private Person person;


    public Ticket() {

    }

    public Ticket(int row_num, int seat_num, double prices, Person person) {
        this.row_num = row_num;
        this.seat_num = seat_num;
        this.prices = prices;
        this.person = person;
    }

    public int getRow_num() {
        return row_num;
    }

    public void setRow_num(int row_num) {
        this.row_num = row_num;
    }

    public int getSeat_num() {
        return seat_num;
    }

    public void setSeat_num(int seat_num) {
        this.seat_num = seat_num;
    }

    public double getPrices() {
        return prices;
    }

    public void setPrices(double prices) {
        this.prices = prices;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void print(){
        System.out.println("name : "+ person.getNames());
        System.out.println("surname : "+ person.getSurNames());
        System.out.println("email : "+ person.geteMails());
        System.out.println("row : "+ getRow_num());
        System.out.println("seat : "+ getSeat_num());
        System.out.println("prices : Rs."+ getPrices());
    }
}
