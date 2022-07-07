package com.gulchan.manage.controller;

import cn.hutool.json.JSONUtil;
import com.gulchan.manage.entity.LoginEntity;
import com.gulchan.manage.pojo.User;
import com.gulchan.manage.service.UserService;
import com.gulchan.manage.service.UserServiceByJpa;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
public class LoginController implements BeanNameAware, InitializingBean, DisposableBean, ApplicationContextAware {

    @Autowired
    private UserService userService;

    @Autowired
    private UserServiceByJpa userServiceByJpa;

    // 将用户登录信息，缓存到redis中
    @Autowired
    private RedisTemplate redisTemplate;

     @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 跳转到登录页面
     * @param model
     * @return
     */
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(Model model){
        return "login";
    }

    /**
     * 登录的处理
     * @param model
     * @return
     */
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(LoginEntity loginEntity, Model model, HttpSession session){
        if(Objects.isNull(loginEntity) || Objects.isNull(loginEntity.getName())|| Objects.isNull(loginEntity.getPwd())){
            model.addAttribute("msg","请求参数异常");
            model.addAttribute("status","failure");
            return "login";
        }
        List<User> users = userServiceByJpa.findByName(loginEntity.getName());
        if(Objects.isNull(users) || users.isEmpty()){
            model.addAttribute("msg","用户" + loginEntity.getName() + "不存在");
            model.addAttribute("status","failure");
            return "login";
        }else{
            User user = userServiceByJpa.findByNameAndPwd(loginEntity.getName(),loginEntity.getPwd());
            if(Objects.isNull(user)){
                model.addAttribute("msg","用户或密码不正确");
                model.addAttribute("status","failure");
                return "login";
            }
            if(!redisTemplate.hasKey(user.getId())){
                // 将用户信息存入session中
                redisTemplate.opsForValue().set(user.getId(), JSONUtil.toJsonStr(user));
            }
            model.addAttribute("msg","登录成功");
            model.addAttribute("status","success");
            session.setAttribute("user",user);
        }
        return "index";
    }


    @Override
    public void setBeanName(String name) {
        // 此处可以设置当前bean的name
        System.out.println("beanName:" + name);
    }


   /* @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("loginController".equals(beanName)){
            System.out.println("bean initialization before beanName:" + beanName + ";className:" + bean.getClass().getName());
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("loginController".equals(beanName)){
            System.out.println("bean initialization before  beanName:" + beanName + ";className:" + bean.getClass().getName());
        }

        return bean;
    }*/

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("current applicationName:" + applicationContext.getApplicationName());
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("loginController  afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("loginController destroy");
    }
}

