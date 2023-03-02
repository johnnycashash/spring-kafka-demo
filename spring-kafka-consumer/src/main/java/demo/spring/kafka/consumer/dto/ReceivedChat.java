package demo.spring.kafka.consumer.dto;
public class ReceivedChat {

    private String memberId;
    private String msg;

    public ReceivedChat() {
    }

    public ReceivedChat(String memberId, String msg) {
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