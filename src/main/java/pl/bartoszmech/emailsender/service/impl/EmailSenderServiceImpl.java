package pl.bartoszmech.emailsender.service.impl;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import pl.bartoszmech.emailsender.exception.InvalidEmail;
import pl.bartoszmech.emailsender.service.EmailSenderService;
import org.thymeleaf.context.Context;
import pl.bartoszmech.emailsender.validator.EmailSenderValidator;

@Service
public class EmailSenderServiceImpl implements EmailSenderService {
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;
    private final EmailSenderValidator validator;
    public EmailSenderServiceImpl(JavaMailSender mailSender, TemplateEngine templateEngine, EmailSenderValidator validator) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
        this.validator = validator;
    }

    @Override
    public void sendEmail(String recipient) {
        validateRecipient(recipient);
        String EMAIL_ERROR_MESSAGE = "Error during sending email";

        String EMAIL_TEMPLATE = "email-template.html";
        String SUBJECT = "newsletter registration";

        Context context = new Context();

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        try {
            helper.setTo(recipient);
            helper.setSubject(SUBJECT);

            String htmlContent = templateEngine.process(EMAIL_TEMPLATE, context);
            helper.setText(htmlContent, true);
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new InvalidEmail(EMAIL_ERROR_MESSAGE);
        }
    }

    private void validateRecipient(String recipient) {
        String FAILED_VALIDATION_MESSAGE = "Provide valid email";
        boolean isValid = validator.validateEmail(recipient);
        if(!isValid) {
            throw new InvalidEmail(FAILED_VALIDATION_MESSAGE);
        }
    }
}
