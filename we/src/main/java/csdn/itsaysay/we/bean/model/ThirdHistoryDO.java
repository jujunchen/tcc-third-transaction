package csdn.itsaysay.we.bean.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@Data
@TableName("third_history")
public class ThirdHistoryDO {

	@TableId(type = IdType.AUTO)
	private Integer id;
	
	private String weData;
	
	private String thirdData;
	
	private String rtype;
	
	public String third;
	
}
