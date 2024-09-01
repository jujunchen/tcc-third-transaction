package csdn.itsaysay.we.service;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import csdn.itsaysay.we.bean.model.FaceDO;
import csdn.itsaysay.we.bean.req.FaceAddReq;
import csdn.itsaysay.we.mapper.FaceMapper;
import csdn.itsaysay.we.service.handler.FaceAdd;

@Service
public class FaceService {
	
	@Resource
	private FaceMapper faceMapper;
	@Resource
	private FaceAdd faceAdd;
	

	/**
	 * 添加人脸
	 * @param req 人脸参数
	 * @return 人脸id
	 */
	@Transactional
	public Integer faceAdd(FaceAddReq req) {
		
		//添加到自己库里面
		FaceDO faceDO = copyProperties(req);
		
		faceMapper.insert(faceDO);
		
		//添加到第三方系统的库里面
		faceAdd.tryFaceAdd(faceDO);
		
		return faceDO.getId();
	}

	private FaceDO copyProperties(FaceAddReq req) {
		FaceDO faceDO = new FaceDO();
		BeanUtils.copyProperties(req, faceDO);
		return faceDO;
	}

	
}
