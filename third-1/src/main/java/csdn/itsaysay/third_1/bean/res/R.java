package csdn.itsaysay.third_1.bean.res;

import lombok.Data;

@Data
public class R {
	
	private String code = "";
	
	private String msg = "";
	
	private Object data = "";
	
	private static final String SUCCESS_CODE = "200";
	
	private static final String SUCCESS = "SUCCESS";
	
	public static R ok(Object data) {
		return new R(SUCCESS_CODE, SUCCESS, data);
	}
	
	public static R fail(String errorCode, String msg) {
		return new R(errorCode, msg, "");
	}
	
	public static R fail(String errorCode, String msg, Object data) {
		return new R(errorCode, msg, data);
	}

	public R(String successCode, Object objData) {
		this.code  = successCode;
		this.data = objData;
	}

	public R(String errorCode, String errormsg, Object objData) {
		this.code  = errorCode;
		this.msg = errormsg;
		this.data = objData;
	}
}
