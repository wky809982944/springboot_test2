package com.wangkaiyi.service;
public interface MailService {
    /**
     * 发送邮件
     * @param to 邮件收件人
     * @param subject 邮件主题
     * @param id 邮件验证码
     */
    public void sendMail(String to, String subject, String id);
}
