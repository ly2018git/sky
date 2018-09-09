package com.skyhospital.tools;

public class AppReturn {
	// 响应业务状态  200=成功，400=失败，500=异常 100=验证码错误
    private Integer status;
    // 响应消息
    private String msg;
    // 响应中的数据
    private Object data;
    
	public AppReturn() {
		super();
	}

	/**
	 * 执行成功
	 * @return
	 */
	public static AppReturn succeed(){
		return new AppReturn(200,"执行成功",null);
	}
	/**
	 * 执行失败
	 * @return
	 */
	public static AppReturn defeated(){
		return new AppReturn(400,"执行失败",null);
	}
	/**自定义
	 * @param status
	 * @param msg
	 * @param data
	 * @return
	 */
	public static AppReturn build(Integer status, String msg, Object data) {
        return new AppReturn(status, msg, data);
    }
	/**执行成功,返回data
	 * 
	 * @param data
	 * @return
	 */
	public static AppReturn ok(Object data) {
	        return new AppReturn(data);
	}
	public AppReturn(Object data) {
        this.status = 200;
        this.msg = "执行成功";
        this.data = data;
    }
	public AppReturn(Integer status, String msg, Object data) {
		super();
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
    
}
