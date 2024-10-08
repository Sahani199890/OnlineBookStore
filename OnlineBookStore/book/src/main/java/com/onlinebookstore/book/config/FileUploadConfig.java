//package com.onlinebookstore.book.config;
//
//import org.springframework.boot.web.servlet.MultipartConfigFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.util.unit.DataSize;
//
//import jakarta.servlet.MultipartConfigElement;
//@Configuration
//public class FileUploadConfig {
//	@Bean
//  public MultipartConfigElement multipartConfigElement() {
//      MultipartConfigFactory factory = new MultipartConfigFactory();
//
//      // Set max file size and max request size using DataSize
//      factory.setMaxFileSize(DataSize.ofMegabytes(10));  // Set max file size to 10MB
//      factory.setMaxRequestSize(DataSize.ofMegabytes(10));  // Set max request size to 10MB
//
//     return factory.createMultipartConfig();
//  }
//}
