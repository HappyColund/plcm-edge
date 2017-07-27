package com.svocloud.plcmedge;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

import com.svocloud.plcmedge.enums.ConferenceRoleEnum;
import com.svocloud.plcmedge.plcm.RestApiVerticle;
import com.svocloud.plcmedge.plcm.model.Conference;
import com.svocloud.plcmedge.utils.Runner;
import io.vertx.core.VertxOptions;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws Exception {
		
		ConferenceRoleEnum[] values = ConferenceRoleEnum.values();
		List<ConferenceRoleEnum> asList = Arrays.asList(values);
		System.out.println(asList);
	}

}
