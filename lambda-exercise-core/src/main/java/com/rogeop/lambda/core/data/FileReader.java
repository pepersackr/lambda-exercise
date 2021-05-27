package com.rogeop.lambda.core.data;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.time.Duration;
import java.time.Instant;

public class FileReader {

    public static void main(String[] args) {
        new FileReader().readFile(
                "C:\\Users\\Robert\\workspaces\\Projects\\lambda-filter\\src\\main\\resources\\person5M.json");
    }

    public void readFile(String fileName) {

        try (FileChannel channel = new FileInputStream(fileName).getChannel()) {

            Instant start = Instant.now();

            MappedByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());

            byte[] bytes = new byte[buffer.remaining()];
            buffer.get(bytes);

            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toMillis();
            System.out.println("Time to read " + String.format("%,d", bytes.length) + " byte file: " + timeElapsed);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}