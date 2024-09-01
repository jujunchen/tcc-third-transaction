package csdn.itsaysay.we.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("face")
public class FaceDO {

	@TableId(type = IdType.AUTO)
	private Integer id;
	
	private String name;
	
	private String faceUrl;
}
