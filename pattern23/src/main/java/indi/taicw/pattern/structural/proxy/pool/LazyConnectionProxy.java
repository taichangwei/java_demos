package indi.taicw.pattern.structural.proxy.pool;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.function.Supplier;

public class LazyConnectionProxy extends AbstractConnectionProxy {


    private Connection target = null;
    private Supplier<Connection> supplier;

    public LazyConnectionProxy(Supplier<Connection> supplier) {
        this.supplier = supplier;
    }

    @Override
    public void close() throws SQLException {
        if (target != null) {
            System.out.println("Close connection: " + target);
            super.close();
        }
    }

    @Override
    protected Connection getRealConnection() {
        if (target == null) {
            target = supplier.get();
        }
        return target;
    }
}
