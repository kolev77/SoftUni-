package app.Transactions;

import java.util.List;

public interface MultiResultCommand<E> {
    List<E> execute();
}
