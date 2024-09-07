package com.mirror.finance.biz.dto.form;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class DelForm {

    @NotNull
    private Long id;
}