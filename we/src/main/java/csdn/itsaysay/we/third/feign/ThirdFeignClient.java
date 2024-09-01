package csdn.itsaysay.we.third.feign;

import org.mengyun.tcctransaction.api.EnableTcc;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import csdn.itsaysay.we.bean.req.FaceAddReq;

@FeignClient(name = "we-third", url = "http://localhost:8088/")
public interface ThirdFeignClient {

	@EnableTcc
    @RequestMapping(value = "/face/add", method = RequestMethod.POST)
    void faceAdd(@RequestBody FaceAddReq req);
}
