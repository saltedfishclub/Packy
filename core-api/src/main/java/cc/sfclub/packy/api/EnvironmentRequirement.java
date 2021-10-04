package cc.sfclub.packy.api;

import lombok.Builder;
import lombok.Getter;

//todo EnvironmentChecker in platform-api
@Getter
@Builder
public class EnvironmentRequirement {
    private String target;
    private String condition; //semver dsl
    public String toString(){
        return target+" "+condition;
    }
}
