package net.jlxxw.component.weixin.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * 微信配置类
 * @author chunyang.leng
 * @date 2021/1/19 5:31 下午
 */
@Configuration
@ConfigurationProperties("weixin")
public class WeiXinProperties {

    /**
     * 第三方用户唯一凭证
     */
    private String appId;

    /**
     * 第三方用户唯一凭证密钥，即appSecret
     */
    private String secret;

    /**
     * 获取access_token填写client_credential
     */
    private String grantType;

    /**
     * 是否启用默认的token管理器
     */
    private boolean enableDefaultTokenManager = false;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getGrantType() {
        return grantType;
    }

    public void setGrantType(String grantType) {
        this.grantType = grantType;
    }

    public boolean isEnableDefaultTokenManager() {
        return enableDefaultTokenManager;
    }

    public void setEnableDefaultTokenManager(boolean enableDefaultTokenManager) {
        this.enableDefaultTokenManager = enableDefaultTokenManager;
    }
}
