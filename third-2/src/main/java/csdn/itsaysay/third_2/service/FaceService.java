package csdn.itsaysay.third_2.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import csdn.itsaysay.third_2.bean.model.FaceDO;
import csdn.itsaysay.third_2.bean.req.FaceAddReq;
import csdn.itsaysay.third_2.mapper.FaceMapper;
import jakarta.annotation.Resource;

@Service
public class FaceService {
	
	@Resource
	private FaceMapper faceMapper;

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

	public void faceDelete(Integer id) {
		faceMapper.deleteById(id);
	}

}
