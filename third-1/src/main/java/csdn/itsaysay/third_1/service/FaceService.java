package csdn.itsaysay.third_1.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import csdn.itsaysay.third_1.bean.model.FaceDO;
import csdn.itsaysay.third_1.bean.req.FaceAddReq;
import csdn.itsaysay.third_1.mapper.FaceMapper;
import jakarta.annotation.Resource;

@Service
public class FaceService {
	
	@Resource
	private FaceMapper faceMapper;

	@Transactional
	public Integer faceAdd(FaceAddReq req) {
		FaceDO faceDO = copyProperties(req);
		faceMapper.insert(faceDO);
		return faceDO.getId();
	}
	
	private FaceDO copyProperties(FaceAddReq req) {
		FaceDO faceDO = new FaceDO();
		BeanUtils.copyProperties(req, faceDO);
		return faceDO;
	}

	@Transactional
	public void faceDelete(Integer id) {
		faceMapper.deleteById(id);
	}

}
