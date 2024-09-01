package csdn.itsaysay.we.third;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "csdn.itsaysay.we.third.mapper")
public class WeApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeApplication.class, args);
	}

}
