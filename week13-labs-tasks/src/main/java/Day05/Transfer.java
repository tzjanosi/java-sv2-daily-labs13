package Day05;

public class Transfer {
    private Account from;
    private Account to;
    private int amount;

    public Transfer(Account from, Account to, int amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public void realize(){
        from.minus(amount);
        to.plus(amount);
    }
}
