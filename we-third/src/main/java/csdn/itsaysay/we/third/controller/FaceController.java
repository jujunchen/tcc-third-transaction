package csdn.itsaysay.we.third.controller;

import org.mengyun.tcctransaction.api.Compensable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import csdn.itsaysay.we.third.bean.req.FaceAddReq;
import lombok.extern.slf4j.Slf4j;


/**
 * 我方程序调用第三方系统接口
 */
@Slf4j
@RestController
public class FaceController {
	
	/**
	 * 添加人脸
	 * @return
	 */
	@PostMapping("/face/add")
	@Compensable(confirmMethod = "confirmFaceAdd", cancelMethod = "cancelFaceAdd")
    @Transactional
	public void faceAdd(@RequestBody FaceAddReq req) {
		
		log.info("------->we-third try");
	}
	
	
    @Transactional
	public void confirmFaceAdd(FaceAddReq req) {
		
		log.info("------->we-third confirm");
	}
    
    @Transactional
	public void cancelFaceAdd(FaceAddReq req) {
		
		log.info("------->we-third cancel");
	}
	
}
