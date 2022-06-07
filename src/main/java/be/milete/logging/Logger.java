package be.milete.logging;

import logger.TopicLogger;
import logger.TopicLoggerBuilder;
import topic.Topic;
import topic.TopicLibrary;

import java.io.File;
import java.util.Locale;

/**
 * Class responsible for logging information about the application.
 */
public class Logger {
    public static final String LOG_DIRECTORY = "./logs";

    private static final TopicLogger logger = new TopicLoggerBuilder()
            .format(" [%s] %s")
            .withTime()
            .logToFile(new File(LOG_DIRECTORY))
            .build();

    public static void log(TopicName topicName, String text){
        String key = topicName.name().toLowerCase(Locale.ROOT);

        addTopicIfNotExists(key);

        Topic topic = TopicLibrary.retrieve(key);

        logger.log(topic, text);
    }

    private static void addTopicIfNotExists(String key) {
        if (TopicLibrary.retrieve(key) == null){
            Topic topic = new Topic(key);
            TopicLibrary.add(topic);
        }
    }
}
