package hzqing.com.hzqingcommon.response;

public class ResponseMessage<T> {

    private String status;
    private T body;

    public ResponseMessage() {
    }

    public ResponseMessage(String status, T body) {
        this.status = status;
        this.body = body;
    }

    /**
     * 返回正确的结果和数据
     * @param body
     * @return
     */
    public ResponseMessage success(T body){
        return  new ResponseMessage("success",body);
    }

    /**
     * 返回错误结果
     * @param message
     * @return
     */
    public ResponseMessage error(String message){
        return new ResponseMessage("error",message);
    }
}
