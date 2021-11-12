package br.com.spring.cache.demo.service;

import br.com.spring.cache.demo.exception.PostNotFoundException;
import br.com.spring.cache.demo.model.Post;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

@Service
@PropertySource("classpath:application.properties")
@Repository
public class PostService {

    @Value("${custom.api.service.host}")
    private String serviceHost;
    @Value("${custom.api.service.post.path}")
    private String servicePath;

    public Post getPostById(String id) throws PostNotFoundException, IOException {

        Gson gson = new Gson();
        URL url = new URL(serviceHost+ servicePath +"/"+id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "UTF-8"))){
                    StringBuilder response = new StringBuilder();
                    String responseLine = null;
                    while((responseLine = br.readLine() ) != null){
                        response.append(responseLine.trim());
                    }
                    System.out.println(response);
                    return gson.fromJson(String.valueOf(response), Post.class);
                }
    }

    public Post deletePostById(String id) throws PostNotFoundException, IOException {

        Gson gson = new Gson();
        URL url = new URL(serviceHost+ servicePath +"/"+id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("DELETE");

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "UTF-8"))){
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while((responseLine = br.readLine() ) != null){
                response.append(responseLine.trim());
            }
            System.out.println(response);
            return gson.fromJson(String.valueOf(response), Post.class);
        }

    }

    public Post updateById(Post body, String id) throws PostNotFoundException, IOException {

        Gson gson = new Gson();
        URL url = new URL(serviceHost+ servicePath +"/"+id);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("PUT");
        con.setRequestProperty("Contenty-Type", "application/json");
        OutputStream os = con.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
        osw.write(body.toString());
        osw.close();
        os.close();
        con.connect();

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "UTF-8"))){
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while((responseLine = br.readLine() ) != null){
                response.append(responseLine.trim());
            }
            System.out.println(response);
            return gson.fromJson(String.valueOf(response), Post.class);
        }

    }

    public Post createNewPost(Post body) throws PostNotFoundException, IOException {

        Gson gson = new Gson();
        URL url = new URL(serviceHost+ servicePath);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setDoOutput(true);
        con.setRequestMethod("POST");
        con.setRequestProperty("Contenty-Type", "application/json");
        OutputStream os = con.getOutputStream();
        OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
        osw.write(body.toString());
        osw.close();
        os.close();
        con.connect();

        try(BufferedReader br = new BufferedReader(
                new InputStreamReader(con.getInputStream(), "UTF-8"))){
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while((responseLine = br.readLine() ) != null){
                response.append(responseLine.trim());
            }
            System.out.println(response);
            return gson.fromJson(String.valueOf(response), Post.class);
        }

    }
}
