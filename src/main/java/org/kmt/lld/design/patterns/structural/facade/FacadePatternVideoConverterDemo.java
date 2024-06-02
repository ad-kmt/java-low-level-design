package org.kmt.lld.design.patterns.structural.facade;

import java.io.File;

/**
 * Facade Design Pattern Example
 *
 * Problem:
 * A complex video conversion framework requires multiple classes and configurations
 * to perform video conversion. Using these classes directly in the client code
 * would make it tightly coupled and difficult to maintain.
 *
 * Solution:
 * The Facade pattern provides a simplified interface to this complex subsystem.
 * It defines a higher-level interface that makes the subsystem easier to use.
 *
 * Components:
 * - Facade: Provides a simple method to interact with the subsystem.
 * - Subsystem classes: Complex components that perform the actual work.
 * - Client: Uses the Facade instead of directly interacting with the subsystem.
 *
 * Classes:
 * 1. VideoFile:
 *    - Represents a video file with its name and codec type.
 *    - Contains methods to get the codec type and name of the video file.
 *
 * 2. Codec:
 *    - Interface for different codecs.
 *
 * 3. MPEG4CompressionCodec:
 *    - Implements the Codec interface for the MP4 format.
 *
 * 4. OggCompressionCodec:
 *    - Implements the Codec interface for the OGG format.
 *
 * 5. CodecFactory:
 *    - Extracts the appropriate codec from a video file based on its type.
 *    - Contains a method to determine and return the correct codec.
 *
 * 6. BitrateReader:
 *    - Reads and converts video files.
 *    - Contains methods to read and convert video files using a codec.
 *
 * 7. AudioMixer:
 *    - Fixes the audio in the video file.
 *    - Contains a method to fix audio issues in the video file.
 *
 * 8. VideoConversionFacade:
 *    - Facade interface that provides a method to convert video files.
 *
 * 9. VideoConversionFacadeImpl:
 *    - Implementation of the VideoConversionFacade interface.
 *    - Provides a simplified method to interact with the video conversion subsystem.
 *    - Handles the complexity of configuring the right classes and retrieving the result.
 *
 * 10. Demo:
 *    - Client code that uses the VideoConversionFacade to convert a video file.
 */


// Subsystem VideoFile class
class VideoFile {
    private String name;
    private String codecType;

    public VideoFile(String name) {
        this.name = name;
        this.codecType = name.substring(name.indexOf(".") + 1);
    }

    public String getCodecType() {
        return codecType;
    }

    public String getName() {
        return name;
    }
}

// Subsystem Codec interface
interface Codec {
}

// Subsystem MPEG4CompressionCodec class
class MPEG4CompressionCodec implements Codec {
    public String type = "mp4";
}

// Subsystem OggCompressionCodec class
class OggCompressionCodec implements Codec {
    public String type = "ogg";
}

// Subsystem CodecFactory class
class CodecFactory {
    public static Codec extract(VideoFile file) {
        String type = file.getCodecType();
        if (type.equals("mp4")) {
            System.out.println("CodecFactory: extracting mpeg audio...");
            return new MPEG4CompressionCodec();
        } else {
            System.out.println("CodecFactory: extracting ogg audio...");
            return new OggCompressionCodec();
        }
    }
}

// Subsystem BitrateReader class
class BitrateReader {
    public static VideoFile read(VideoFile file, Codec codec) {
        System.out.println("BitrateReader: reading file...");
        return file;
    }

    public static VideoFile convert(VideoFile buffer, Codec codec) {
        System.out.println("BitrateReader: writing file...");
        return buffer;
    }
}



class AudioMixer {
    public File fix(VideoFile result) {
        System.out.println("AudioMixer: fixing audio...");
        return new File("tmp");
    }
}

// Facade interface
interface VideoConversionFacade {
    File convertVideo(String fileName, String format);
}

// Implementation of Facade interface
class VideoConversionFacadeImpl implements VideoConversionFacade {
    @Override
    public File convertVideo(String fileName, String format) {
        System.out.println("VideoConversionFacade: conversion started.");

        // Create a VideoFile object
        VideoFile file = new VideoFile(fileName);

        // Extract the codec using CodecFactory
        Codec sourceCodec = CodecFactory.extract(file);

        // Determine the destination codec based on the format
        Codec destinationCodec;
        if (format.equals("mp4")) {
            destinationCodec = new MPEG4CompressionCodec();
        } else {
            destinationCodec = new OggCompressionCodec();
        }

        // Read the file using BitrateReader
        VideoFile buffer = BitrateReader.read(file, sourceCodec);

        // Convert the buffer to the destination format using BitrateReader
        VideoFile intermediateResult = BitrateReader.convert(buffer, destinationCodec);

        // Fix the audio using AudioMixer
        File result = (new AudioMixer()).fix(intermediateResult);

        System.out.println("VideoConversionFacade: conversion completed.");
        return result;
    }
}

// Client code
public class FacadePatternVideoConverterDemo {
    public static void main(String[] args) {
        // Create a facade object to simplify the video conversion process
        VideoConversionFacade facade = new VideoConversionFacadeImpl();

        // Convert the video using the facade
        File mp4Video = facade.convertVideo("youtubevideo.ogg", "mp4");

        // Output the result
        System.out.println("Converted video saved as: " + mp4Video.getName());
    }
}

