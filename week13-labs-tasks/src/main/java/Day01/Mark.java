package Day01;

public enum Mark {
    ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

    private int value;

    Mark(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
