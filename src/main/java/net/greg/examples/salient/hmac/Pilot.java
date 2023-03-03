package net.greg.examples.salient.hmac;

import java.nio.charset.*;

import java.security.*;

// https://mkyong.com/java/java-sha-hashing-example/
public final class Pilot {


  public final byte[] digestMessage(byte[] message) {

    try {

      messageDigest =
        MessageDigest.getInstance(ALGORITHM);
    }
    catch (NoSuchAlgorithmException e) {
      e.printStackTrace();
    }

    return messageDigest.digest(message);
  }


  /**
   *
   */
  public static void main(String[] args) {
    app.process(args[0]);
  }


  private void process(final String payload) {

    System.err.println(
        "\n\n\nPayload       " + payload +
        "\nPayload (len) " + payload.length());



    byte[] messageAsBytes =
      app.digestMessage(
        payload.getBytes(
          StandardCharsets.UTF_8));


    // fixed length of 256 bits (32 bytes).
    System.err.println(
      "\n"  + ALGORITHM + " (hex) " +
      app.convertBytes2Hex(messageAsBytes) +
      "\n" + ALGORITHM + " (len) " +
      messageAsBytes.length + "\n\n");
  }

  /**
   *
   */
  public final String convertBytes2Hex(byte[] bytes) {

    StringBuilder answer =
      new StringBuilder();

    for (byte bight : bytes) {
      answer.append(String.format(HEX, bight));
    }

    return answer + "";  // coercion, SameAs .toString();
  }


  static { app = new Pilot(); }
  private static final Pilot app;


  private static final String ALGORITHM = "SHA3-256";

  private static final String HEX = "%02x";

  private static MessageDigest messageDigest;
}
