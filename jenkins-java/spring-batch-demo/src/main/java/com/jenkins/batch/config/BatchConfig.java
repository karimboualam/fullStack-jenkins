package com.jenkins.batch.config;

import com.jenkins.batch.step.Step1Tasklet;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    private final Step1Tasklet step1Tasklet;

    public BatchConfig(Step1Tasklet step1Tasklet) {
        this.step1Tasklet = step1Tasklet;
    }

    @Bean
    public Job demoJob(JobRepository jobRepository, Step step1) {
        return new JobBuilder("demoJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .start(step1)
                .build();
    }

    @Bean
    public Step step1(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("step1", jobRepository)
                .tasklet(step1Tasklet, transactionManager)
                .build();
    }
}
