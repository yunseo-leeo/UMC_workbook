package com.example.umc_workbook.global.validator;


import com.example.umc_workbook.global.annotation.ValidPage;
import com.example.umc_workbook.global.errorCode.PageErrorCode;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class PageValidator implements ConstraintValidator<ValidPage, Integer> {

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context){
        if (value == null) return true;

        boolean isValid = value >= 1;

        if (!isValid){
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(PageErrorCode.INVALID_PAGE.getMessage())
                    .addConstraintViolation();
        }

        return isValid;
    }
}
