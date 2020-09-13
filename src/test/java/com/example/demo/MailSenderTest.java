package com.example.demo;

//import freemarker.template.Template;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class MailSenderTest {


    @Autowired
    private JavaMailSender javaMailSender;

//    @Autowired
//    VelocityEngine velocityEngine;

    @Test
    public void sendSimpleMail() throws Exception {

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("972927683@qq.com");
        message.setTo("never_xlc@163.com");
        message.setSubject("主题：简单邮件");
        message.setText("Ceshi 邮件");

        javaMailSender.send(message);

    }


    @Test
    public void sendAttachmentsMail() throws Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("972927683@qq.com");
        helper.setTo("never_xlc@163.com");
        helper.setSubject("主题：带附件");
        helper.setText("Dai附件的邮件测试");

        FileSystemResource file = new FileSystemResource(new File("D:\\IMG_0326.JPG"));
        FileSystemResource file1 = new FileSystemResource(new File("D:\\IMG_0950.JPG"));
        helper.addAttachment("附件-1.jpg", file);
        helper.addAttachment("附件-2.jpg", file1);

        javaMailSender.send(mimeMessage);
    }


    /**
     * 注意的是addInline函数中资源名称pic1需要与正文中cid:pic1z`对应起来
     *
     * @throws Exception
     */
    @Test
    public void sendInlineMail() throws Exception{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("972927683@qq.com");
        helper.setTo("never_xlc@163.com");
        helper.setSubject("主题：嵌入图片");
        helper.setText("<html><body><img src=\"cid:pic1\">" +
                "<hr>" +
                "<img src=\"cid:pic2\">" +
                "</body></html>",true);
        FileSystemResource file = new FileSystemResource(new File("D:\\IMG_0326.JPG"));
        FileSystemResource file1 = new FileSystemResource(new File("D:\\IMG_0950.JPG"));
        helper.addInline("pic1", file);
        helper.addInline("pic2", file1);

        javaMailSender.send(mimeMessage);
    }


    @Test
    public void sendTemplateMail() throws Exception {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom("972927683@qq.com");
        helper.setTo("never_xlc@163.com");
        helper.setSubject("主题：模板邮件");
//        Template template = new Template();

//        Map<String, String> model = new HashMap<>();

//        FreeMarkerTemplateUtils.processTemplateIntoString(template, )
        Template template = new VelocityEngine().getTemplate("templates/template.vm");
        VelocityContext velocityContext = new VelocityContext();
        velocityContext.put("userName", "许林创");
        StringWriter stringWriter = new StringWriter();
//        template.merge(velocityContext, stringWriter);
        helper.setText(stringWriter.toString(), true);

        javaMailSender.send(mimeMessage);
    }
}
