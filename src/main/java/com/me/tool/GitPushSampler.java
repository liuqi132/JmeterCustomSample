package com.me.tool;

import org.apache.jmeter.samplers.AbstractSampler;
import org.apache.jmeter.samplers.Entry;
import org.apache.jmeter.samplers.SampleResult;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GitPushSampler extends AbstractSampler {

    private static final Logger log = Logger.getLogger("GitPushSampler");

    public static final String SERVER = "server.text";
    public static final String PORT = "port.text";
    public static final String USERNAME = "username.text";
    public static final String PASSWORD = "password.text";
    public static final String COOKIE = "cookie.text";
    public static final String FILESNUM = "filesNum.text";
    public static final String GITPUSHGROUPS = "gitPushGroups.text";

    public String getServer(){
        return getPropertyAsString(SERVER);
    }

    public String getPort(){
        return getPropertyAsString(PORT);
    }
    public String getUserName(){
        return getPropertyAsString(USERNAME);
    }
    public String getPassword(){
        return getPropertyAsString(PASSWORD);
    }
    public String getCookie(){
        return getPropertyAsString(COOKIE);
    }
    public String getFilesNum(){
        return getPropertyAsString(FILESNUM);
    }
    public String getGitPushGroups(){
        return getPropertyAsString(GITPUSHGROUPS);
    }

    private String getTitle(){
        return this.getName();
    }
    public void trace(String s){
        String tl = getTitle();
        String tn = Thread.currentThread().getName();
        String th = this.toString();
    }
    public GitPushSampler(){
        setName("GitPushSampler");
    }

    public SampleResult sample(Entry e){
        trace("sample()");
        SampleResult mainRes = new SampleResult();
        String server = getServer();
        String port = getPort();
        String username = getUserName();
        String password = getPassword();
        String cookie = getCookie();
        String filesNum = getFilesNum();
        String gitPushGroups = getGitPushGroups();
        boolean isOK = false;
        String response = null;
        mainRes.setSampleLabel(getTitle());
        mainRes.sampleStart();
        for (String gitPushGroup: gitPushGroups.split("\n")){
            SampleResult subGitPushRes = new SampleResult();
            try{
                subGitPushRes.sampleStart();
                long start = System.currentTimeMillis();
                Thread.sleep(new Random().nextInt(1000));
                long end = System.currentTimeMillis();

                System.out.println("Hello world");
                subGitPushRes.setLatency(end - start);
                subGitPushRes.setSampleLabel("test1");
                subGitPushRes.sampleEnd();
                subGitPushRes.setSamplerData("data-test");
                subGitPushRes.setResponseData("test-result");
                subGitPushRes.setDataType(SampleResult.TEXT);
                subGitPushRes.setResponseOK();

            }catch (Exception xe){
                log.log(Level.INFO, "", xe);
                subGitPushRes.setResponseCode("500");
                subGitPushRes.setSuccessful(false);
                subGitPushRes.setResponseMessage(xe.toString());
            }
            mainRes.addSubResult(subGitPushRes,false);
        }
        mainRes.sampleEnd();
        mainRes.setResponseOK();
        return mainRes;
    }
}
