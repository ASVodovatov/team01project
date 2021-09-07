package com.db.edu.utils;


import java.io.*;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

public class History {
    private String historyFilePath;
    private ReentrantReadWriteLock historyLock = new ReentrantReadWriteLock();

    public History(String filePath) {
        this.historyFilePath = filePath;
    }

    public void save(String processedMessage) {
        try(BufferedWriter fileWriter = new BufferedWriter(new FileWriter(historyFilePath, true))) {
            historyLock.writeLock().lock();
            fileWriter.append(processedMessage + System.lineSeparator());
            fileWriter.flush();
            historyLock.writeLock().unlock();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String load(){
        String historyMessage = "";
        try (BufferedReader fileReader = new BufferedReader(new FileReader(historyFilePath))){
            historyLock.readLock().lock();
            historyMessage = fileReader.lines().collect(Collectors.joining(System.lineSeparator()));
            historyLock.readLock().unlock();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        return historyMessage.isEmpty() ? "History is empty" : historyMessage;
    }
}

