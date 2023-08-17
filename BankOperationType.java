public enum BankOperationType {
    NEW_ACCOUNT(1), DEPOSIT(2),  WITHDRAWAL(3), CHECK(4), UNKNOWN(-1);

    private final int value;

    BankOperationType(final int newValue) {
        value = newValue;
    }

    public int getValue() { return value; }

    public static BankOperationType getType(int type) {
        switch(type) {
            case 1:
               return  NEW_ACCOUNT;
            case 2:
                return DEPOSIT;
            case 3 :
                return WITHDRAWAL;
            case 4:
                return CHECK;
            default:
                return UNKNOWN;
        }
    }

}
