package hzqing.com.hzqingcommon.response;

public class ResponseMessage<T> {

    private int status;
    private T data;

    public ResponseMessage() {
    }

    public ResponseMessage(int status, T data) {
        this.status = status;
        this.data = data;
    }

    /**
     * 返回正确的结果和数据
     * @param data
     * @return
     */
    public ResponseMessage success(T data){
        return  new ResponseMessage(200,data);
    }

    /**
     * 返回成功  数据 success
     * @return
     */
    public ResponseMessage success(){
        return  new ResponseMessage(200,"success");
    }

    /**
     * 返回错误结果
     * @param message
     * @return
     */
    public ResponseMessage error(String message){
        return new ResponseMessage(404,message);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 会话超时，请重新登录，或者取消继续留在该页面
     * @return
     */
    public ResponseMessage<Integer> tokenExpire() {
        return  new ResponseMessage(40101,data);
    }
}
