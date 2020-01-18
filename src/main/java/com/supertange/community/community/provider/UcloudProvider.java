package com.supertange.community.community.provider;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Author: supertange
 * @Description:
 * @Date: Created in 12:14 2020/1/18
 */
@Service
public class UcloudProvider {

    @Value("${ucloud.ufile.public-key}")
    private String publicKey;

    @Value("${ucloud.ufile.private-key}")
    private String privateKey;


    private String upload(){
        return null;
    }




}
