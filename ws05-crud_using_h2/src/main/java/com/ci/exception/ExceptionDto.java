package com.ci.exception;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionDto {

	private String statusCodeAndMessage;
	private String cause;
	private LocalDate timeStamp;
}
