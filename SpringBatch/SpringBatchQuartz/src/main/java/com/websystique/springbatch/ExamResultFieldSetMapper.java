package com.websystique.springbatch;

import org.joda.time.LocalDate;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.validation.BindException;

import com.websystique.springbatch.model.ExamResult;

public class ExamResultFieldSetMapper implements FieldSetMapper<ExamResult> {
	@Override
	public ExamResult mapFieldSet(FieldSet fieldSet) throws BindException {
		ExamResult result = new ExamResult();
		result.setStudentName(fieldSet.readString(0));
		result.setDob(new LocalDate(fieldSet.readDate(1, "dd/MM/yyyy")));
		result.setPercentage(fieldSet.readDouble(2));
		return result;
	}
}
