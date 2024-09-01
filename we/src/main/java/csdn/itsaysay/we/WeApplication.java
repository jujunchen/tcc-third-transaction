package csdn.itsaysay.we;

import org.mengyun.tcctransaction.spring.annotation.EnableTccTransaction;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"csdn.itsaysay.we"})
@MapperScan(basePackages = "csdn.itsaysay.we.mapper")
@EnableFeignClients
@EnableTccTransaction
public class WeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeApplication.class, args);
	}

}
