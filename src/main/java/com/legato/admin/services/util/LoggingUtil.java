/**
 * 
 */
package com.legato.admin.services.util;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

/**
 * @author Af83580
 * 
 *         LoggingUtil - An utility class to handle all the logging
 *         functionality of the application.
 */
public class LoggingUtil {
	private LoggingUtil() {
		super();
	}

	public static void logError(Class<?> clazz, LogDetail logDetail, Exception exception) {
		String system = "";
		String username = "";
		String uri = "";
		String errorMessage = "" + exception;

		if (logDetail != null) {
			system = StringUtils.isEmpty(logDetail.getSystem()) ? "" : logDetail.getSystem();
			username = StringUtils.isEmpty(logDetail.getUsername()) ? "" : logDetail.getUsername();
			uri = StringUtils.isEmpty(logDetail.getUri()) ? "" : logDetail.getUri();

			system = system.replace('\n', '_').replace('\r', '_');
			username = username.replace('\n', '_').replace('\r', '_');
			uri = uri.replace('\n', '_').replace('\r', '_');
			errorMessage = errorMessage.replace('\n', '_').replace('\r', '_');

			LoggerFactory.getLogger(clazz).error("Exception - {SYSTEM : \"{}\", USERID : {}, USERNAME : \"{}\", SERVICE_URI : \"{}\", ERROR_MESSAGE : \"{}\"}", system, 
					logDetail.getUserId(), username, uri, errorMessage);
		}
	}

	public static void logInfo(Class<?> clazz, LogDetail logDetail) {
		String system = "";
		String username = "";
		String uri = "";

		if (logDetail != null) {
			system = StringUtils.isEmpty(logDetail.getSystem()) ? "" : logDetail.getSystem();
			username = StringUtils.isEmpty(logDetail.getUsername()) ? "" : logDetail.getUsername();
			uri = StringUtils.isEmpty(logDetail.getUri()) ? "" : logDetail.getUri();

			system = system.replace('\n', '_').replace('\r', '_');
			username = username.replace('\n', '_').replace('\r', '_');
			uri = uri.replace('\n', '_').replace('\r', '_');

			LoggerFactory.getLogger(clazz).info("Info - {SYSTEM : \"{}\", USERID : {}, USERNAME : \"{}\", SERVICE_URI : \"{}\"}", system,
					logDetail.getUserId(), username, uri);
		}
	}
}