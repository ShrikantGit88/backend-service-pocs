package com.selflearning.aws.sns;

import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.SubscribeRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.aws.autoconfigure.context.ContextRegionProviderAutoConfiguration;
import org.springframework.cloud.aws.autoconfigure.context.ContextStackAutoConfiguration;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication(exclude = {ContextStackAutoConfiguration.class, ContextRegionProviderAutoConfiguration.class})
@RestController
public class SpringBootAwsSnsExampleApplication {

	Logger logger = LoggerFactory.getLogger(SpringBootAwsSnsExampleApplication.class);

	@Autowired
	private AmazonSNSClient snsClient;

	@Value("${cloud.aws.end-point.uri}")
	private String endpoint;

	@Value("${cloud.aws.topic.arn}")
	private String topicARN;

	@GetMapping("/addSubscription/{email}")
	public String addSubscription(@PathVariable String email) {
		SubscribeRequest request = new SubscribeRequest(topicARN, "email", email);
		snsClient.subscribe(request);
		return "Subscription request is pending. To confirm subscription, check your email: "+email;
	}

	@GetMapping("/sendNotification")
	public String publishMessageToTopic() {
		PublishRequest request = new PublishRequest(topicARN, buildEmailBody(), "Notification: Network Connectivity Issue");
		snsClient.publish(request);
		return "Notification send successfully !!!";
	}

	private String buildEmailBody() {
		return "Dear Employee \n"+
				"\n"+
				"Connection down";
	}


	public static void main(String[] args) {
		SpringApplication.run(SpringBootAwsSnsExampleApplication.class, args);
	}

}
