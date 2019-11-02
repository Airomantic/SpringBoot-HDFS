package com.panda.hdfs;

import org.apache.hadoop.fs.FileStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.hadoop.fs.FsShell;

@SpringBootApplication
public class SpringBootHdfsApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootHdfsApplication.class, args);
    }

    @Autowired
    FsShell fsShell;//用于执行HDFS shell命令的对象
    @Override
    public void run(String... args) throws Exception {
        //查看根目录下的所有条件
        for (FileStatus fileStatus : fsShell.ls("/")) {
            System.out.println(">"+fileStatus.getPath());
        }
    }
}
