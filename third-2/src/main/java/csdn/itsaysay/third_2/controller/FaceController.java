package csdn.itsaysay.third_2.controller;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import csdn.itsaysay.third_2.bean.req.FaceAddReq;
import csdn.itsaysay.third_2.bean.res.R;
import csdn.itsaysay.third_2.service.FaceService;
import jakarta.annotation.Resource;


/**
 * 第一个三方系统
 * 由于三方系统不是我所能控制的，这里只提供
 * 添加人脸、删除人脸接口
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
	@Transactional
	public R faceAdd(@RequestBody FaceAddReq req) {
		//模拟这个服务添加失败
		Integer faceIdId = faceService.faceAdd(req);
		if (faceIdId % 3 == 0) {
			return R.fail("添加人脸失败");
		}
		return R.ok(faceIdId);
	}
	
	
	/**
	 * 删除人脸
	 * @return
	 */
	@PostMapping("/face/delete/{id}")
	public R faceDelete(@PathVariable Integer id) {
		
		faceService.faceDelete(id);
		return R.ok("");
	}
	
	
}
