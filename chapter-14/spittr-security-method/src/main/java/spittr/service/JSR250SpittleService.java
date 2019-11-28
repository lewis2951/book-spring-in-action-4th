package spittr.service;

import spittr.domain.Spittle;

import javax.annotation.security.RolesAllowed;

public class JSR250SpittleService implements SpittleService {

    @Override
    @RolesAllowed("ROLE_SPITTER")
    public void addSpittle(Spittle spittle) {
        System.out.println("Method was called successfully");
    }

}
