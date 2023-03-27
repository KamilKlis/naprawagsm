package pl.naprawagsm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import pl.naprawagsm.clientRepairs.repository.Repair;
import pl.naprawagsm.clientRepairs.repository.RepairEntity;
import pl.naprawagsm.priceList.repository.PriceList;
import pl.naprawagsm.priceList.repository.PriceListRepository;

@SpringBootApplication
@ComponentScan
public class NaprawagsmApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(NaprawagsmApplication.class, args);
//		PriceList priceList=new PriceList("Samsung","A10",);
//		PriceListRepository repairEntity=ctx.getBean(PriceListRepository.class);
//		repairEntity.save(priceList);
//		
	}
}
