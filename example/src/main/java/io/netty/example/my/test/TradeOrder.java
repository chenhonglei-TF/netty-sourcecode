package io.netty.example.my.test;

public class TradeOrder {

    private long id;
    private String status;
    public TradeOrder(int id, String status) {
        this.id = id;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id=" + id + ", status=" + status;
    }
}
