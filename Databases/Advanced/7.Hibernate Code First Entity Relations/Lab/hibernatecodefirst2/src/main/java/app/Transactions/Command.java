package app.Transactions;

public interface Command<E> {
    E execute();
}
