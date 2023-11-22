package pl.bartoszmech.emailsender.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.bartoszmech.emailsender.controller.requestBody.EmailRecipient;
import pl.bartoszmech.emailsender.service.EmailSenderService;

@RestController
@CrossOrigin(origins = "*")
public class EmailController {

    private final EmailSenderService emailSenderService;

    public EmailController(EmailSenderService emailSenderService) {
        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/send-email")
    public ResponseEntity<HttpStatus.Series> sendHtmlEmail(@RequestBody EmailRecipient emailRequest) {
        emailSenderService.sendEmail
                (emailRequest.recipient());
        return ResponseEntity.ok(HttpStatus.Series.SUCCESSFUL);
    }
}
