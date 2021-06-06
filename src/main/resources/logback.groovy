appender("FILE", FileAppender) {
    file = "warningFromGroovy.log"
    append = true
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}
root(WARN, ["FILE"])

appender("FILE2", FileAppender) {
    file = "errorsFromGroovy.log"
    append = true
    encoder(PatternLayoutEncoder) {
        pattern = "%level %logger - %msg%n"
    }
}
root(ERROR, ["FILE2"])