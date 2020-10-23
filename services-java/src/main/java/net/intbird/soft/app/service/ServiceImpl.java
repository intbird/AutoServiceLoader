package net.intbird.soft.app.service;

/**
 * created by Bird
 * DingTalk id: net.intbird
 */
public class ServiceImpl implements ServiceInterface {

    @Override
    public void doMessage(String message) {
        System.out.println(message);
    }
}
