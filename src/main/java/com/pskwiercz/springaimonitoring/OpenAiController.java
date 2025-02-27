package com.pskwiercz.springaimonitoring;


import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenAiController {

    ChatClient chatClient;

    public OpenAiController(ChatClient.Builder chatBuilder) {
        this.chatClient = chatBuilder.build();
    }

    @GetMapping("/monitoring")
    public String monitoring() {
        return chatClient.prompt().user("Tell me jake about cats").call().content();
    }
}
