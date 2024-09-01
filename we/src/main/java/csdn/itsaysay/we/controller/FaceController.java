package csdn.itsaysay.we.controller;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import csdn.itsaysay.we.bean.req.FaceAddReq;
import csdn.itsaysay.we.service.FaceService;


/**
 * 我方程序调用
 */
@RestController
public class FaceController {
	
	@Resource
	private FaceService faceService;

	/**
	 * 添加人脸
	 * @return
	 */
	@PostMapping("/face/add")
	public Integer faceAdd(@RequestBody FaceAddReq req) {
		
		return faceService.faceAdd(req);
	}
	
	
}
