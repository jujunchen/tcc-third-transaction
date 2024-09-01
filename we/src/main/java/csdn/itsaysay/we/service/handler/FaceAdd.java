package csdn.itsaysay.we.service.handler;

import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;

import org.mengyun.tcctransaction.api.Compensable;
import org.mengyun.tcctransaction.api.UniqueIdentity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;

import csdn.itsaysay.we.bean.Third;
import csdn.itsaysay.we.bean.model.FaceDO;
import csdn.itsaysay.we.bean.model.ThirdHistoryDO;
import csdn.itsaysay.we.mapper.ThirdHistoryMapper;
import csdn.itsaysay.we.third.feign.ThirdFeignClient;
import csdn.itsaysay.we.third.third1.T1FaceService;
import csdn.itsaysay.we.third.third2.T2FaceService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FaceAdd {
	
	@Resource
	private T1FaceService third1FaceService;
	@Resource
	private T2FaceService third2FaceService;
	@Resource
	private ThirdHistoryMapper thirdHistoryMapper;
	@Resource
	private ThirdFeignClient thirdFeignClient;
	
	
	@Compensable(confirmMethod = "confirmFaceAdd", cancelMethod = "cancelFaceAdd")
	@Transactional
	public void tryFaceAdd(@UniqueIdentity FaceDO face) {
		log.info("------->we try");
		
		//把第三方接口独立成服务，通过feign去调用
//		FaceAddReq req = BeanUtil.copyProperties(face, FaceAddReq.class);
//		thirdFeignClient.faceAdd(req);
		
		//直接写在当前服务里面
		String id1 = third1FaceService.faceAdd(face);
		thirdHistoryMapper.insert(buildModel(face.getId(), id1, Third.ADD, Third.THIRD1));
		
		String id2 = third2FaceService.faceAdd(face);
		thirdHistoryMapper.insert(buildModel(face.getId(), id2, Third.ADD, Third.THIRD2));
	}
	

	public void confirmFaceAdd(FaceDO face) {
		log.info("------->we confirm");
		

	}
	

	public void cancelFaceAdd(FaceDO face) {
		log.info("------->we cancel");
		List<ThirdHistoryDO> faceThirdDOs = thirdHistoryMapper.selectList(Wrappers.<ThirdHistoryDO>lambdaQuery()
				.eq(ThirdHistoryDO::getWeData, face.getId())
				.eq(ThirdHistoryDO::getRtype, Third.ADD));
		for (ThirdHistoryDO thirdHistoryDO : faceThirdDOs) {
			//如果只有几个的话，可以单独指定，如果是不确定有几个的话，还要根据third字段唯一标识来获取应该调用哪个第三方
			if (Objects.equals(thirdHistoryDO.getThird(), Third.THIRD1)) {
				third1FaceService.faceDelete(thirdHistoryDO.getThirdData());
			}
			
			if (Objects.equals(thirdHistoryDO.getThird(), Third.THIRD2)) {
				third1FaceService.faceDelete(thirdHistoryDO.getThirdData());
			}
		}
		
	}
	
	private ThirdHistoryDO buildModel(Integer id, String thirdId, String rtype, String third) {
		ThirdHistoryDO thirdHistoryDO = new ThirdHistoryDO();
		thirdHistoryDO.setWeData(String.valueOf(id));
		thirdHistoryDO.setThirdData(thirdId);
		thirdHistoryDO.setRtype(rtype);
		thirdHistoryDO.setThird(third);
		return thirdHistoryDO;
	}
	
}
