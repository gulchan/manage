package com.gulchan.manage.service.impl;

import com.gulchan.manage.pojo.User;
import com.gulchan.manage.service.SendEmailService;
import com.gulchan.manage.service.UserService;
import com.sun.xml.internal.org.jvnet.mimepull.MIMEMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.List;
import java.util.Objects;

/**
 * 邮件发送服务
 */
@Service
public class SendEmailServiceImpl implements SendEmailService {

    @Resource
    private JavaMailSender javaMailSender;


    @Value("${spring.mail.username}")
    private String from;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean sendEmail(List<User> userList) {
        try {
            if(Objects.isNull(userList) || userList.isEmpty()){
                return Boolean.FALSE;
            }
            for (User user: userList) {
                MimeMessage mimeMessage = javaMailSender.createMimeMessage();
                MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
                mimeMessageHelper.setFrom("gulchan@qq.com");
                mimeMessageHelper.setSubject("生日祝福");
                mimeMessageHelper.setTo("gulchan@163.com");
                mimeMessageHelper.setText(user.getName() + ",生日快乐呀!");
                javaMailSender.send(mimeMessage);
            }
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
