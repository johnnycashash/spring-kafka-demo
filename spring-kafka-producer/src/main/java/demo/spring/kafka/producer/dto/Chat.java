package demo.spring.kafka.producer.dto;

public class Chat {

    private String memberId;
    private String msg;

    public Chat() {
    }

    public Chat(String memberId, String msg) {
        this.memberId = memberId;
        this.msg = msg;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "memberId='" + memberId + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}