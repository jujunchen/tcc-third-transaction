package csdn.itsaysay.we.third.third2;

import java.util.Objects;

import org.springframework.stereotype.Service;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import csdn.itsaysay.we.bean.model.FaceDO;

@Service
public class T2FaceService {
	
	
	public String faceAdd(FaceDO face) {
		String url = "http://localhost:8082/face/add";
		String res = HttpUtil.post(url, JSONUtil.toJsonStr(face));
		JSONObject resObject = JSONUtil.parseObj(res);
		
		if (!Objects.equals(resObject.getStr("code"), "200")) {
			throw new RuntimeException("third2添加人脸失败，错误信息：" + resObject.getStr("msg"));
		}
		
		return resObject.getStr("data");
	}
	
	public void faceDelete(Integer faceId) {
		String url = "http://localhost:8082/face/delete/%s";
		String res = HttpUtil.post(String.format(url, faceId), "");
		JSONObject resObject = JSONUtil.parseObj(res);
		
		if (!Objects.equals(resObject.getStr("code"), "200")) {
			throw new RuntimeException("third2删除人脸失败，错误信息：" + resObject.getStr("msg"));
		}
	}

}
