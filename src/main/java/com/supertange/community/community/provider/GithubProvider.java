package com.supertange.community.community.provider;

import com.alibaba.fastjson.JSON;
import com.supertange.community.community.dto.AccessTokenDTO;
import com.supertange.community.community.dto.GithubUser;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Objects;

//controller: 把当前这个类作为路由的承载者
//component: 仅仅把当前类初始化到spring容器之中。自动实例话一个对象，放到了容器池子里，当需要用时，直接注入。
// 就是不需要用new实例话对象，直接采用ioc去注入对象
@Component
public class GithubProvider {
    public String getAccessToken(AccessTokenDTO accessTokenDTO) {
        MediaType mediaType = MediaType.get("application/json");
        OkHttpClient client = new OkHttpClient();
        RequestBody body = RequestBody.create(mediaType, JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            String responses = response.body().string();
            String[] split = responses.split("&");
            String token = split[0].split("=")[1];
            return token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUser getUser(String accessToken) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user")
                .header("Authorization","token "+accessToken)
                .build();
        try {
            Response response = client.newCall(request).execute();
            String string = Objects.requireNonNull(response.body()).string();
            GithubUser githubUser = JSON.parseObject(string, GithubUser.class);
            return githubUser;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
