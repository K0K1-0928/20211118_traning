package jp.evolveit.kouki_murakami.rest_api.api;

import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class GreetingRequest {

    @NotNull
    private String name;
}
