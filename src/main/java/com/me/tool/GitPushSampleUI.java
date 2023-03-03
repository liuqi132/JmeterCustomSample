package com.me.tool;

import org.apache.jmeter.gui.util.HorizontalPanel;
import org.apache.jmeter.gui.util.VerticalPanel;
import org.apache.jmeter.samplers.gui.AbstractSamplerGui;
import org.apache.jmeter.testelement.TestElement;

import javax.swing.*;
import java.awt.*;
import java.util.logging.Logger;

public class GitPushSampleUI extends AbstractSamplerGui {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger("GitPushSampler");

    private JTextField server;

    private JTextField port;

    private JTextField username;

    private JTextField password;

    private JTextField cookie;

    private JTextField filesNum;

    private JTextArea gitPushGroups;

    public GitPushSampleUI() {
        super();
        createPanel();
    }


    private JPanel getServerPanel() {
        server = new JTextField(10);
        JLabel label = new JLabel("Server Host");
        label.setLabelFor(server);

        JPanel jPanel = new HorizontalPanel();
        jPanel.add(label, BorderLayout.WEST);
        jPanel.add(server, BorderLayout.CENTER);
        return jPanel;
    }

    private JPanel getUserNamePanel() {
        username = new JTextField(10);
        JLabel label = new JLabel("username:");
        label.setLabelFor(username);

        JPanel jPanel = new HorizontalPanel();
        jPanel.add(label, BorderLayout.WEST);
        jPanel.add(username, BorderLayout.CENTER);
        return jPanel;
    }

    private JPanel getPasswordPanel() {
        password = new JTextField(10);
        JLabel label = new JLabel("password:");
        label.setLabelFor(password);

        JPanel jPanel = new HorizontalPanel();
        jPanel.add(label, BorderLayout.WEST);
        jPanel.add(password, BorderLayout.CENTER);
        return jPanel;
    }

    private JPanel getCookiePanel() {
        cookie = new JTextField(10);
        JLabel label = new JLabel("cookie:");
        label.setLabelFor(cookie);

        JPanel jPanel = new HorizontalPanel();
        jPanel.add(label, BorderLayout.WEST);
        jPanel.add(cookie, BorderLayout.CENTER);
        return jPanel;
    }

    private JPanel getFileNumPanel() {
        filesNum = new JTextField(10);
        JLabel label = new JLabel("fileNums:");
        label.setLabelFor(filesNum);

        JPanel jPanel = new HorizontalPanel();
        jPanel.add(label, BorderLayout.WEST);
        jPanel.add(filesNum, BorderLayout.CENTER);
        return jPanel;
    }

    private JPanel getPushGroupPanel() {
        gitPushGroups = new JTextArea(20, 20);
        JLabel label = new JLabel("gitPushGroups");
        label.setLabelFor(gitPushGroups);
        JPanel jPanel = new HorizontalPanel();
        jPanel.add(label, BorderLayout.WEST);
        jPanel.add(filesNum, BorderLayout.CENTER);
        return jPanel;
    }

    private void createPanel() {
        JPanel settingPanel = new VerticalPanel(8, 0);
        settingPanel.add(getServerPanel());
        settingPanel.add(getUserNamePanel());
        settingPanel.add(getPasswordPanel());
        settingPanel.add(getCookiePanel());
        settingPanel.add(getFileNumPanel());
        settingPanel.add(getPushGroupPanel());

        JPanel dataPanel = new JPanel(new BorderLayout(8, 0));

        dataPanel.add(settingPanel, BorderLayout.NORTH);
        setLayout(new BorderLayout(0, 8));
        setBorder(makeBorder());
        add(makeTitlePanel(), BorderLayout.NORTH);
        add(dataPanel, BorderLayout.CENTER);

    }

    @Override
    public String getLabelResource() {
        return null;
    }

    @Override
    public TestElement createTestElement() {

        return null;
    }

    @Override
    public void modifyTestElement(TestElement testElement) {
        testElement.clear();
        configureTestElement(testElement);
        testElement.setProperty(GitPushSampler.SERVER, server.getText());
        testElement.setProperty(GitPushSampler.PORT, port.getText());
        testElement.setProperty(GitPushSampler.USERNAME, username.getText());
        testElement.setProperty(GitPushSampler.PASSWORD, password.getText());
        testElement.setProperty(GitPushSampler.COOKIE, cookie.getText());
        testElement.setProperty(GitPushSampler.FILESNUM, filesNum.getText());
        testElement.setProperty(GitPushSampler.GITPUSHGROUPS, gitPushGroups.getText());
    }
    @Override
    public String getStaticLabel(){
        return "GitPushSampler";
    }
    public void cleanGui(){
    server.setText("");
    port.setText("");
    username.setText("");
    password.setText("");
    cookie.setText("");
    filesNum.setText("");
    gitPushGroups.setText("");
    }

    @Override
    public void configure(TestElement testElement){
        super.configure(testElement);
        server.setText(testElement.getPropertyAsString(GitPushSampler.SERVER));
        port.setText(testElement.getPropertyAsString(GitPushSampler.PORT));
        username.setText(testElement.getPropertyAsString(GitPushSampler.USERNAME));
        password.setText(testElement.getPropertyAsString(GitPushSampler.PASSWORD));
        cookie.setText(testElement.getPropertyAsString(GitPushSampler.COOKIE));
        filesNum.setText(testElement.getPropertyAsString(GitPushSampler.FILESNUM));
        gitPushGroups.setText(testElement.getPropertyAsString(GitPushSampler.GITPUSHGROUPS));
    }
    
}
