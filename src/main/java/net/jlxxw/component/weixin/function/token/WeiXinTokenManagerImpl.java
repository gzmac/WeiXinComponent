package net.jlxxw.component.weixin.function.token;

import com.alibaba.fastjson.JSON;
import net.jlxxw.component.weixin.constant.UrlConstant;
import net.jlxxw.component.weixin.exception.WeiXinException;
import net.jlxxw.component.weixin.mapper.TokenMapper;
import net.jlxxw.component.weixin.properties.WeiXinProperties;
import net.jlxxw.component.weixin.response.WeiXinResponse;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.text.MessageFormat;

/**
 * @author chunyang.leng
 * @date 2021/1/19 5:30 下午
 */
public class WeiXinTokenManagerImpl implements WeiXinTokenManager{
    private WeiXinProperties weiXinProperties;
    private RestTemplate restTemplate;
    private TokenMapper tokenMapper;

    public WeiXinTokenManagerImpl(WeiXinProperties weiXinProperties, RestTemplate restTemplate, TokenMapper tokenMapper) {
        this.weiXinProperties = weiXinProperties;
        this.restTemplate = restTemplate;
        this.tokenMapper = tokenMapper;
    }

    /**
     * 保存token
     *
     * @param token
     */
    @Override
    public void saveToken(String token) {
        tokenMapper.insert(token);
    }

    /**
     * 获取token
     *
     * @return token
     */
    @Override
    public String getToken() {
        String url = MessageFormat.format(UrlConstant.TOKEN_URL,weiXinProperties.getGrantType(),weiXinProperties.getAppId(),weiXinProperties.getSecret());
        WeiXinResponse response = restTemplate.getForObject(url, WeiXinResponse.class);
        if(response.getErrcode()!=0){
            throw new WeiXinException(JSON.toJSONString(response));
        }
        return response.getAccess_token();
    }

    /**
     * 获取保存在本地的token
     *
     * @return 保存在本地的token
     */
    @Override
    public String getTokenFromLocal() {
        return tokenMapper.getToken();
    }

    @PostConstruct
    public void postConstruct(){
        tokenMapper.createTable();
    }
}
