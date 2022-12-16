package com.victation.AppLocacao.config;



    import org.springframework.boot.context.properties.ConfigurationProperties;

    @ConfigurationProperties("locacao")
    @org.springframework.context.annotation.Configuration
    public class ConfigClient {
        private String value;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

